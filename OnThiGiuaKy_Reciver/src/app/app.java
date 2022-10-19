package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
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
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class app extends JFrame {

	private static final Exception Exception = null;

	JComboBox comboBox;

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtCanNang;
	private JTextField txtNgay;
	private JTable table;
	 DefaultTableModel model = new DefaultTableModel(6, 7);
	JRadioButton nam;
  public static String email;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app frame = new app();
					
					
					
					System.out.println(email);

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
		setBounds(100, 100, 619, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CAT RECEIVE");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 595, 54);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã");
		lblNewLabel_1.setBounds(46, 48, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên");
		lblNewLabel_2.setBounds(46, 89, 45, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tuổi");
		lblNewLabel_3.setBounds(46, 129, 45, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Cân nặng");
		lblNewLabel_4.setBounds(46, 177, 45, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Người chăm sóc");
		lblNewLabel_5.setBounds(36, 229, 81, 13);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Ngày đến");
		lblNewLabel_6.setBounds(35, 311, 45, 13);
		contentPane.add(lblNewLabel_6);

		txtMa = new JTextField();
		txtMa.setBounds(146, 45, 343, 19);
		contentPane.add(txtMa);
		txtMa.setColumns(10);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(146, 86, 343, 19);
		contentPane.add(txtTen);

		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(146, 126, 343, 19);
		contentPane.add(txtTuoi);

		txtCanNang = new JTextField();
		txtCanNang.setColumns(10);
		txtCanNang.setBounds(146, 174, 343, 19);
		contentPane.add(txtCanNang);

		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(123, 308, 343, 19);
		contentPane.add(txtNgay);
		// hàng , cột
		DefaultTableModel model = new DefaultTableModel(0, 7);
		table = new JTable(model);
		
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(550, 399, 17, 48);
		
	
		contentPane.add(scrollBar);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 230, 340, 21);

		List<String> list = new ArrayList<String>();
		list.add("Vũ Quang Huy số 1");
		list.add("Vũ Quang Huy số 2");
		list.add("Vũ Quang Huy số 3");
		list.add("Vũ Quang Huy số 4");

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
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int row = table.getSelectedRow();
					txtMa.setText(table.getValueAt(row,0).toString());
					txtTen.setText(table.getValueAt(row,1).toString());
					txtTuoi.setText(table.getValueAt(row,2).toString());
					txtCanNang.setText(table.getValueAt(row,3).toString());
					//comboBox.setSelectedIndex(3);
					
					comboBox.setSelectedItem(table.getValueAt(row, 4).toString());
					if(true)
						nam.setSelected(true);
					txtNgay.setText(table.getValueAt(row,6).toString());
					
					
					
				}
			});
			table.setBounds(18, 365, 583, 154);

			contentPane.add(table);
			
			
			
			
			
			//
			
			
			try {
				
				BasicConfigurator.configure();
				//thiết lập môi trường cho JJNDI
						Properties settings = new Properties();
						settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
						settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
				//tạo context
						Context ctx = new InitialContext(settings);
				//lookup JMS connection factory
						Object obj = ctx.lookup("ConnectionFactory");
						ConnectionFactory factory = (ConnectionFactory) obj;
				//lookup destination
						Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
				//tạo connection
						Connection con = factory.createConnection("admin", "admin");
				//nối đến MOM
						con.start();
				//tạo session
						Session session = con.createSession(/* transaction */false, /* ACK */Session.CLIENT_ACKNOWLEDGE);
				//tạo consumer
						MessageConsumer receiver = session.createConsumer(destination);
				//blocked-method for receiving message - sync
				//receiver.receive();
				//Cho receiver lắng nghe trên queue, chừng có message thì notify - async
						System.out.println("Tý was listened on queue...");
						receiver.setMessageListener(new MessageListener() {
							@Override
				//có message đến queue, phương thức này được thực thi
							public void onMessage(Message msg) {// msg là message nhận được
								try {
									if (msg instanceof TextMessage) {
										TextMessage tm = (TextMessage) msg;
										String txt = tm.getText();
										System.out.println("Nhận được " + txt);
										Cat p = new Cat();
										String xml = txt+"";
										Cat ps = new XMLConvert<Cat>(p).xml2Object(xml);
										
										String gioitinh;
										if (ps.isGioiTinh())
											gioitinh = "nam";
										else gioitinh = "nu";
											
										
										
										
										
										
										
									

										
										
										  Object[] rowData= {ps.getMa()+"", ps.getTen(),
										 ps.getTuoi()+"",ps.getCanNang()+"",ps.getNguoiChamSoc(),gioitinh,
										 ps.getNgayDen().toString()
										  
										  
										  };
										  
										  
										  
										 
										  model.addRow(rowData); 
										  
										  table.setModel(model);
										  contentPane.add(table);
										
										
										
										
									   System.out.println(ps);
										
										
										msg.acknowledge();// gửi tín hiệu ack
									} else if (msg instanceof ObjectMessage) {
										
									}
				//others message type....
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
				
				
				
				
				
				
				
			
		}
				
			
				
			 catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			

      /*  void Exception {

		Cat catt = new Cat();

		BasicConfigurator.configure();
		// thiết lập môi trường cho JJNDI
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		// tạo context
		Context ctx = new InitialContext(settings);
		// lookup JMS connection factory
		Object obj = ctx.lookup("ConnectionFactory");
		ConnectionFactory factory = (ConnectionFactory) obj;
		// lookup destination
		Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
		// tạo connection
		Connection con = factory.createConnection("admin", "admin");
		// nối đến MOM
		con.start();
		// tạo session
		Session session = con.createSession( transaction false,  ACK Session.CLIENT_ACKNOWLEDGE);
		// tạo consumer
		MessageConsumer receiver = session.createConsumer(destination);
		// blocked-method for receiving message - sync
		// receiver.receive();
		// Cho receiver lắng nghe trên queue, chừng có message thì notify - async
		System.out.println("Tý was listened on queue...");
		receiver.setMessageListener(new MessageListener() {
			@Override
			// có message đến queue, phương thức này được thực thi
			public void onMessage(Message msg) {// msg là message nhận được
				try {
					if (msg instanceof TextMessage) {
						TextMessage tm = (TextMessage) msg;
						String txt = tm.getText();
						System.out.println("Nhận được " + txt);
						Cat p = new Cat();
						String xml = txt + "";
						
						
						Cat ps = new XMLConvert<Cat>(p).xml2Object(xml);

						
						
						 * Object[] rowData= {ps.getMa()+"", ps.getTen(),
						 * ps.getTuoi()+"",ps.getCanNang()+"",ps.getNguoiChamSoc(),ps.isGioiTinh(),
						 * ps.getNgayDen().toString()
						 * 
						 * 
						 * 
						 * };
						 * 
						 * 
						 * 
						 * 
						 * model.addRow(rowData); contentPane.add(table);
						 
						 
						email = xml;
						System.out.println(ps);

						msg.acknowledge();// gửi tín hiệu ack
					} else if (msg instanceof ObjectMessage) {

					}
					// others message type....
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		

	
		}}}
