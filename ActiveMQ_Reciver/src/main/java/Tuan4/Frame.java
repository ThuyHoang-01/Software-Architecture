package Tuan4;

import java.awt.EventQueue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.BasicConfigurator;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<benhnhan> ds = new ArrayList<benhnhan>();
	private ArrayList dsma = new ArrayList<String>();
	JList list;
	private DefaultListModel listModel;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JMSException 
	 * @throws NamingException 
	 */
	public Frame() throws NamingException, JMSException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh sach benh nhan cho kham", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 212, 345);
		contentPane.add(panel);
		
		panel.setLayout(null);
		
		
    ///////////////////////////////////////////////////////////////
		list = new JList(dsma.toArray());
		listModel = new DefaultListModel();	
		list.setModel(listModel);
		list.setBounds(10, 20, 194, 315);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				
				String ma = (String) list.getSelectedValue();

			for(benhnhan bn : ds) {
				if(bn.getMsbn()==ma) {
					textField.setText(bn.getMsbn());
					textField_1.setText(bn.getHoten());
					textField_2.setText(bn.getDiachi());
					textArea.setText(bn.getSocmnd());
				}
			}
			
			
				
			}
		});
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Thong tin benh nhan duoc chon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(232, 10, 470, 370);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MSBN");
		lblNewLabel.setBounds(46, 39, 88, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(163, 37, 193, 16);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ho va Ten");
		lblNewLabel_1.setBounds(46, 82, 88, 16);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 82, 193, 16);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CMND");
		lblNewLabel_2.setBounds(46, 123, 88, 13);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 121, 193, 16);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dia Chi");
		lblNewLabel_3.setBounds(46, 165, 88, 16);
		panel_1.add(lblNewLabel_3);
		
		textArea = new JTextArea();
		textArea.setBounds(163, 147, 193, 48);
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Noi dung kham", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(35, 205, 327, 123);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 20, 307, 93);
		panel_2.add(textArea_1);
		
		
		
		
		BasicConfigurator.configure();
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		Context ctx = new InitialContext(settings);
		Object obj = ctx.lookup("ConnectionFactory");
		ConnectionFactory factory = (ConnectionFactory) obj;
		Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
		Connection con = factory.createConnection("admin", "admin");
		con.start();
		Session session = con.createSession(/* transaction */false, /* ACK */Session.CLIENT_ACKNOWLEDGE);
		MessageConsumer receiver = session.createConsumer(destination);
		System.out.println("Tý was listened on queue...");
		receiver.setMessageListener(new MessageListener() {
			public void onMessage(Message msg) {// msg là message nhận được
				try {
					if (msg instanceof TextMessage) {
						list.setSelectedIndex(-1);
						TextMessage tm = (TextMessage) msg;
						String txt = tm.getText();
						String a[] = txt.split("-");
						benhnhan bn = new benhnhan();
						bn.setMsbn(a[0]);
						bn.setHoten(a[1]);
						bn.setSocmnd(a[2]);
						bn.setDiachi(a[3]);
						ds.add(bn);
						listModel.addElement(a[0]);
						list.setModel(listModel);
						System.out.println(ds.toString());
						msg.acknowledge();// gửi tín hiệu ack
					} else if (msg instanceof ObjectMessage) {
						ObjectMessage om = (ObjectMessage) msg;
						System.out.println(om);
					}
//others message type....
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		
	}

	
}
