package uer_interface;

import java.awt.EventQueue;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import entity.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import javax.swing.JLabel;

public class UIReceiver extends JFrame {

	/**
	 * 
	 */
	private static Person p;
	private static JLabel lblHoTen = new JLabel("Ho Ten");
	private static JLabel lblMSSV = new JLabel("MSSV");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel lblDate = new JLabel("Date");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//thiết lập môi trường cho JMS
					BasicConfigurator.configure();
					//thiết lập môi trường cho JJNDI
					Properties settings=new Properties();
					settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
							"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
					settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
					//tạo context
					Context ctx=new InitialContext(settings);
					//lookup JMS connection factory
					Object obj=ctx.lookup("ConnectionFactory");
					ConnectionFactory factory=(ConnectionFactory)obj;
					//lookup destination
					Destination destination
					=(Destination) ctx.lookup("dynamicQueues/thanthidet");
					//tạo connection
					Connection con=factory.createConnection("admin","admin");
					//nối đến MOM
					con.start();
					//tạo session
					Session session=con.createSession(
							/*transaction*/false,
							/*ACK*/Session.CLIENT_ACKNOWLEDGE
							);
					//tạo consumer
					MessageConsumer receiver = session.createConsumer(destination);
					//blocked-method for receiving message - sync
					//receiver.receive();
					//Cho receiver lắng nghe trên queue, chừng có message thì notify - async
					System.out.println("Tý was listened on queue...");
					receiver.setMessageListener(new MessageListener() {
						@Override
						//có message đến queue, phương thức này được thực thi
						public void onMessage(Message msg) {//msg là message nhận được
							try {
								if(msg instanceof TextMessage){
									TextMessage tm=(TextMessage)msg;
									String txt=tm.getText();
									
									
									JAXBContext ctx= JAXBContext.newInstance(Person.class);
									Unmarshaller ms = ctx.createUnmarshaller();
									p = (Person) ms.unmarshal(new StringReader(txt));
									
									System.out.println("Nhận được: "+ p.toString());
									
									
									msg.acknowledge();//gửi tín hiệu ack
									
									String hoTen = p.getHoten();
									String mSSV = String.valueOf(p.getMssv());
									
									Date date = p.getNgaysinh(); 
									DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
									String strDate = dateFormat.format(date);  
									
									lblMSSV.setText(mSSV);
									lblHoTen.setText(hoTen);
									lblDate.setText(strDate);
								}
								else if(msg instanceof ObjectMessage){
									ObjectMessage om=(ObjectMessage)msg;
									System.out.println(om);
								}
								//others message type....
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					UIReceiver frame = new UIReceiver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIReceiver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMSSV.setBounds(156, 36, 67, 14);
		contentPane.add(lblMSSV);
		
		JPanel panel = new JPanel();
		panel.setBounds(206, 16, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblHoTen.setBounds(156, 87, 210, 14);
		contentPane.add(lblHoTen);
		lblDate.setBounds(156, 141, 193, 14);
		
		contentPane.add(lblDate);
	}

}
