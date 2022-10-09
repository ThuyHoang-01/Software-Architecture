package uer_interface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.StringReader;
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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

import org.apache.log4j.BasicConfigurator;

import entity.Person;
import entity.Persons;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import javax.swing.JList;
import javax.swing.JButton;

public class UIGetList {

	private JFrame frame;
	private static DefaultListModel colorsName = new DefaultListModel();;
	private static JList list = new JList(colorsName);
	private static JScrollPane scrollPane  = new JScrollPane(list);
	private static Persons p = new Persons();
	private final JLabel lblMSSV = new JLabel("");
	private final JLabel lblHeaderHoTen = new JLabel("Ho ten");
	private final JLabel lblHoTen = new JLabel("");
	private final JButton btnHien = new JButton("Hien");

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

									Persons p = null;
									JAXBContext ctx= JAXBContext.newInstance(Persons.class);
									Unmarshaller ms = ctx.createUnmarshaller();
									p = (Persons) ms.unmarshal(new StringReader(txt));

									System.out.println("Nhận được: "+ p.getListPerson().toString());
									msg.acknowledge();//gửi tín hiệu ack

									for(int i = 0; i < p.length(); i++) {
										colorsName.addElement(p.getHoTen(i));
									}
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

					UIGetList window = new UIGetList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIGetList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblHeaderMSSV = new JLabel("MSSV");
		lblHeaderMSSV.setBounds(165, 37, 75, 14);
		frame.getContentPane().add(lblHeaderMSSV);

		scrollPane.setBounds(32, 50, 103, 157);
		frame.getContentPane().add(scrollPane);
		lblMSSV.setBounds(260, 37, 123, 14);

		frame.getContentPane().add(lblMSSV);
		lblHeaderHoTen.setBounds(165, 62, 75, 14);

		frame.getContentPane().add(lblHeaderHoTen);
		lblHoTen.setBounds(260, 62, 123, 14);

		frame.getContentPane().add(lblHoTen);
		btnHien.setBounds(42, 218, 89, 23);

		frame.getContentPane().add(btnHien);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					JList target = (JList)me.getSource();
					int index = target.locationToIndex(me.getPoint());
					if (index >= 0) {
						Object item = target.getModel().getElementAt(index);
//						lblHoTen.setText(item.toString());
						Person person = new Person();
						person = p.getPersonFromIndex(index);
						lblHoTen.setText(person.getHoten());
					}
				}
			}
		});
	}
}
