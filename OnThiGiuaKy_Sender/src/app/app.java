package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import entity.Cat;

import helper.XMLConvert;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.net.ssl.SSLEngine;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class app extends JFrame {

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtCanNang;
	private JTextField textField_5;
	private JTextField textlist;
	
	private ArrayList<Cat> cats = new ArrayList<Cat>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app frame = new app();
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
	public app() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAT SENDER");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 595, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã");
		lblNewLabel_1.setBounds(35, 74, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên");
		lblNewLabel_2.setBounds(35, 112, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tuổi");
		lblNewLabel_3.setBounds(35, 153, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cân nặng");
		lblNewLabel_4.setBounds(35, 197, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Người chăm sóc");
		lblNewLabel_5.setBounds(35, 234, 81, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày đến");
		lblNewLabel_6.setBounds(35, 289, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Số phần tử  trong list");
		lblNewLabel_7.setBounds(35, 359, 173, 13);
		contentPane.add(lblNewLabel_7);
		
		txtMa = new JTextField();
		txtMa.setBounds(123, 71, 343, 19);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(123, 109, 343, 19);
		contentPane.add(txtTen);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(123, 150, 343, 19);
		contentPane.add(txtTuoi);
		
		txtCanNang = new JTextField();
		txtCanNang.setColumns(10);
		txtCanNang.setBounds(123, 194, 343, 19);
		contentPane.add(txtCanNang);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(123, 286, 343, 19);
		contentPane.add(textField_5);
		
		textlist = new JTextField();
		textlist.setColumns(10);
		textlist.setBounds(218, 356, 96, 19);
		contentPane.add(textlist);
		

		
		

		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 230, 340, 21);
		
		
		 List<String> list = new ArrayList<String>();
		 list.add("Huy số 1");
		 list.add("Huy số 2");
		 list.add("Huy số 3");
		 list.add("Huy số 4");
		 
		   
		   for (String s : list) {
			   comboBox.addItem(s);	
		
		
		
		
		
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6_1 = new JLabel("Giới tính");
		lblNewLabel_6_1.setBounds(35, 266, 45, 13);
		contentPane.add(lblNewLabel_6_1);
		
		JRadioButton nam = new JRadioButton("Nam");
		nam.setBounds(136, 257, 103, 21);
		
		ButtonGroup G = new ButtonGroup();
		G.add(nam);
		
		
		contentPane.add(nam);
		
		JRadioButton btNu = new JRadioButton("Nữ");
		btNu.setBounds(292, 259, 103, 21);
		G.add(btNu);
		contentPane.add(btNu);
		
		
		JButton btnSenOj = new JButton("Send cat");
		btnSenOj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ma = Integer.parseInt(txtMa.getText().toString());
				String ten = txtTen.getText().toString();
				int tuoi = Integer.parseInt(txtTuoi.getText().toString());
				double cannang = Double.parseDouble(txtCanNang.getText().toString());
				
				String chamsoc = comboBox.getSelectedItem().toString();
				
				boolean gioitinh =  nam.isSelected();
				Date ngay = new Date();
				
				Cat cat = new Cat(ma, ten, tuoi, cannang, chamsoc, gioitinh, ngay);
				
				try {
					sendOj(cat);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
			}
		});
		btnSenOj.setBounds(70, 328, 85, 21);
		contentPane.add(btnSenOj);
		
		
		JButton btnAdd = new JButton("add list");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int ma = Integer.parseInt(txtMa.getText().toString());
				String ten = txtTen.getText().toString();
				int tuoi = Integer.parseInt(txtTuoi.getText().toString());
				double cannang = Double.parseDouble(txtCanNang.getText().toString());
				
				String chamsoc = comboBox.getSelectedItem().toString();
				
				boolean gioitinh =  nam.isSelected();
				Date ngay = new Date();
				
				Cat cat = new Cat(ma, ten, tuoi, cannang, chamsoc, gioitinh, ngay);
				
				
				
				cats.add(cat);
				textlist.setText(cats.size()+"");
				
				
				
				
				
				
				
			}
		});
		btnAdd.setBounds(229, 328, 85, 21);
		contentPane.add(btnAdd);
		

		JButton btnSendList = new JButton("Send list cat");
		btnSendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Cat c : cats) {
					try {
						sendOj(c);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				cats.clear();
				textlist.setText(cats.size()+"");
			}
		});
		btnSendList.setBounds(361, 328, 103, 21);
		contentPane.add(btnSendList);
		
		
	}
}
	void sendOj(Cat cat) throws Exception{
		
		BasicConfigurator.configure();
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		Context ctx = new InitialContext(settings);
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
		Connection con = factory.createConnection("admin", "admin");
		con.start();
		Session session = con.createSession(/* transaction */false, /* ACK */Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(destination);
		//Message msg = session.createTextMessage("hello mesage from ActiveMQ");
		String xml = new XMLConvert<Cat>(cat).object2XML(cat);
		
		Message msg = session.createTextMessage(xml);
		
		producer.send(msg);
//shutdown connection
		session.close();
		con.close();
		System.out.println("Finished...");
		
	}


}
