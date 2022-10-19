package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.BasicConfigurator;
import entity.Person;
import helper.XMLConvert;

import javax.swing.JTable;

public class App extends JFrame {
	
	private static final Exception Exception = null;

	JComboBox comboBox;
	
	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtCanNang;
	private JTextField textField_5;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel(6, 7);
	JRadioButton nam;
	// private ArrayList<Person> persons = new ArrayList<Person>();
	public static String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
					System.out.println(email);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setTitle("Form_Recievr");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("RECIVER");
		lblNewLabel.setBounds(350, 24, 117, 42);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã gửi : ");
		lblNewLabel_1.setBounds(49, 71, 117, 33);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);

		JLabel lblTnNgiGi = new JLabel("Tên người gửi :");
		lblTnNgiGi.setBounds(49, 114, 145, 33);
		lblTnNgiGi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblTnNgiGi);

		JLabel lblTui = new JLabel("Tuổi: ");
		lblTui.setBounds(49, 157, 145, 31);
		lblTui.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblTui);

		JLabel lblCnNng = new JLabel("Cân nặng:");
		lblCnNng.setBounds(49, 198, 145, 35);
		lblCnNng.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblCnNng);

		JLabel lblNgiChmSc = new JLabel("Người chăm sóc:");
		lblNgiChmSc.setBounds(49, 243, 145, 31);
		lblNgiChmSc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNgiChmSc);

		JLabel lblNgyn = new JLabel("Ngày đến:");
		lblNgyn.setBounds(49, 327, 145, 33);
		lblNgyn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNgyn);

		txtMa = new JTextField();
		txtMa.setBounds(202, 71, 550, 33);
		txtMa.setColumns(10);
		contentPane.add(txtMa);

		txtTen = new JTextField();
		txtTen.setBounds(202, 115, 550, 33);
		txtTen.setColumns(10);
		contentPane.add(txtTen);

		txtTuoi = new JTextField();
		txtTuoi.setBounds(204, 158, 548, 33);
		txtTuoi.setColumns(10);
		contentPane.add(txtTuoi);

		txtCanNang = new JTextField();
		txtCanNang.setBounds(202, 201, 550, 33);
		txtCanNang.setColumns(10);
		contentPane.add(txtCanNang);

		textField_5 = new JTextField();
		textField_5.setBounds(200, 329, 552, 33);
		textField_5.setColumns(10);
		contentPane.add(textField_5);

		DefaultTableModel model = new DefaultTableModel(0, 7);
		table = new JTable(model);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(202, 244, 550, 33);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 17));
		comboBox.setBackground(SystemColor.text);
		comboBox.setForeground(Color.BLACK);
	

		List<String> list = new ArrayList<String>();
		list.add("Y tá số 1");
		list.add("Y tá số 2");
		list.add("Y tá số 3");
		list.add("Y tá số 4");

		for (String s : list) {
			comboBox.addItem(s);

			contentPane.add(comboBox);

			JLabel lblNewLabel_6_1 = new JLabel("Giới tính: ");
			lblNewLabel_6_1.setBounds(49, 284, 145, 33);
			lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(lblNewLabel_6_1);

			JRadioButton nam = new JRadioButton("Nam");
			nam.setBounds(273, 290, 103, 21);
			nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));

			ButtonGroup G = new ButtonGroup();
			G.add(nam);
			
			contentPane.add(nam);

			JRadioButton nu = new JRadioButton("Nữ");
			nu.setBounds(418, 290, 103, 21);
			nu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			G.add(nu);
			contentPane.add(nu);

			//table = new JTable();

			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					txtMa.setText(table.getValueAt(row, 0).toString());
					txtTen.setText(table.getValueAt(row, 1).toString());
					txtTuoi.setText(table.getValueAt(row, 2).toString());
					txtCanNang.setText(table.getValueAt(row, 3).toString());

					comboBox.setSelectedItem(table.getValueAt(row, 4).toString());

					if (true)
						nam.setSelected(true);
					textField_5.setText(table.getValueAt(row, 6).toString());
				}
			});
			table.setBounds(206, 372, 550, 110);
			contentPane.add(table);

			//

			try {

				BasicConfigurator.configure();
				// thiết lập môi trường cho JJNDI
				Properties settings = new Properties();
				settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
						"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
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
				Session session = con.createSession(/* transaction */false, /* ACK */Session.CLIENT_ACKNOWLEDGE);
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
								Person p = new Person();
								String xml = txt + "";
								Person ps = new XMLConvert<Person>(p).xml2Object(xml);

								String gioiTinh;
								if (ps.isGioiTinh())
									gioiTinh = "nam";
								else
									gioiTinh = "nu";

								Object[] rowData = { ps.getMa() + "", ps.getTen(), ps.getTuoi() + "",
										ps.getCanNang() + "", ps.getNguoiChamSoc(), gioiTinh, ps.getNgayDen().toString()

								};

								model.addRow(rowData);

								table.setModel(model);
								contentPane.add(table);

								System.out.println(ps);

								msg.acknowledge();// gửi tín hiệu ack
							} else if (msg instanceof ObjectMessage) {

							}
							// others message type....
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

			catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}
}
