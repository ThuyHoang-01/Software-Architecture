package uer_interface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import entity.Person;
import helper.XMLConvert;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;

public class UISender extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMSSV;
	private JTextField txtHoTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISender frame = new UISender();
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
	public UISender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMSSV = new JTextField();
		txtMSSV.setBounds(74, 38, 130, 20);
		contentPane.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("MSSV:");
		lblNewLabel.setBounds(10, 44, 54, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ho Ten:");
		lblNewLabel_1.setBounds(10, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(74, 66, 130, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JButton btnGui = new JButton("Gui");
		btnGui.setBounds(174, 160, 89, 23);
		contentPane.add(btnGui);
		
		btnGui.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String hoTen = txtHoTen.getText();
				String MSSV = txtMSSV.getText();
				int maSV = Integer.parseInt(MSSV);
				
				Person p = new Person(maSV, hoTen, new Date());
				
				BasicConfigurator.configure();
				//config environment for JNDI
				Properties settings=new Properties();
				settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
						"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
				settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
				//create context
				Context ctx = null;
				ConnectionFactory factory = null;
				Destination destination = null;
				Connection con = null;
				Session session = null;
				MessageProducer producer = null;
				Message msg = null;
				String xml = null;
				try {
					ctx = new InitialContext(settings);
					factory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
					destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
					con = factory.createConnection("admin","admin");
					con.start();
					session = con.createSession(
							/*transaction*/false,
							/*ACK*/Session.AUTO_ACKNOWLEDGE
							);
					producer = session.createProducer(destination);
					msg = session.createTextMessage("hello mesage from ActiveMQ");
					producer.send(msg);
					xml = new XMLConvert<Person>(p).object2XML(p);
					msg=session.createTextMessage(xml);
					producer.send(msg);
					session.close();
					con.close();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Finished");
			}
		});
	}
}
