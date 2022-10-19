package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import entity.Person;
import helper.XMLConvert;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JRadioButton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtCanNang;
	private JTextField txtList;
	private JTextField textField_5;

	private ArrayList<Person> persons = new ArrayList<Person>();
	private JTextField txtMa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setTitle("Form_Sender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SENDER ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(350, 24, 117, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã gửi : ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(49, 71, 117, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblTnNgiGi = new JLabel("Tên người gửi :");
		lblTnNgiGi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTnNgiGi.setBounds(49, 114, 145, 33);
		contentPane.add(lblTnNgiGi);

		JLabel lblTui = new JLabel("Tuổi: ");
		lblTui.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTui.setBounds(49, 157, 145, 31);
		contentPane.add(lblTui);

		JLabel lblCnNng = new JLabel("Cân nặng:");
		lblCnNng.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCnNng.setBounds(49, 198, 145, 35);
		contentPane.add(lblCnNng);

		JLabel lblNgiChmSc = new JLabel("Người chăm sóc:");
		lblNgiChmSc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgiChmSc.setBounds(49, 243, 145, 31);
		contentPane.add(lblNgiChmSc);

		JLabel lblNgyn = new JLabel("Ngày đến:");
		lblNgyn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgyn.setBounds(49, 327, 145, 33);
		contentPane.add(lblNgyn);

		JLabel lblSPhnT = new JLabel("Số phần tử trong danh sách:");
		lblSPhnT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSPhnT.setBounds(49, 416, 247, 33);
		contentPane.add(lblSPhnT);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(202, 71, 509, 33);
		contentPane.add(txtMa);
		

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(202, 115, 509, 33);
		contentPane.add(txtTen);

		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(204, 158, 509, 33);
		contentPane.add(txtTuoi);

		txtCanNang = new JTextField();
		txtCanNang.setColumns(10);
		txtCanNang.setBounds(202, 201, 509, 33);
		contentPane.add(txtCanNang);

		txtList = new JTextField();
		txtList.setColumns(10);
		txtList.setBounds(306, 418, 407, 33);
		contentPane.add(txtList);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(200, 329, 511, 33);
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 17));
		comboBox.setBackground(SystemColor.text);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(202, 244, 511, 33);
	

		List<String> list = new ArrayList<String>();
		list.add("Y tá số 1");
		list.add("Y tá số 2");
		list.add("Y tá số 3");
		list.add("Y tá số 4");

		for (String s : list) {
			comboBox.addItem(s);
			
			contentPane.add(comboBox);
		
			

		JLabel lblNewLabel_6_1 = new JLabel("Giới tính: ");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(49, 284, 145, 33);
		contentPane.add(lblNewLabel_6_1);

		JRadioButton nam = new JRadioButton("Nam");
		nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nam.setBounds(273, 290, 103, 21);
		contentPane.add(nam);
		
		ButtonGroup G = new ButtonGroup();
		G.add(nam);

		JRadioButton nu = new JRadioButton("Nữ");
		nu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nu.setBounds(418, 290, 103, 21);
		G.add(nu);
		contentPane.add(nu);

		// Xử lý nút gửi đối tượng
		JButton btnSenObj = new JButton("Send Person");
		btnSenObj.setBackground(new Color(102, 153, 255));
		btnSenObj.setFont(new Font("Times New Roman", Font.BOLD, 18));

		btnSenObj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int ma = Integer.parseInt(txtMa.getText().toString());
				String ten = txtTen.getText().toString();
				int tuoi = Integer.parseInt(txtTuoi.getText().toString());
				double cannang = Double.parseDouble(txtCanNang.getText().toString());

				String chamsoc = comboBox.getSelectedItem().toString();

				boolean gioiTinh = nam.isSelected();

				Date ngay = new Date();

				Person person = new Person(ma, ten, tuoi, cannang, chamsoc, gioiTinh, ngay);

				try {
					sendObj(person);

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

		});
		btnSenObj.setBounds(202, 372, 145, 34);
		contentPane.add(btnSenObj);

		// Xu ly nut them vao danh sach
		JButton btnAdd = new JButton("Add List");
		btnAdd.setBackground(new Color(255, 0, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int ma = Integer.parseInt(txtMa.getText().toString());
				String ten = txtTen.getText().toString();
				int tuoi = Integer.parseInt(txtTuoi.getText().toString());
				double cannang = Double.parseDouble(txtCanNang.getText().toString());
				String chamsoc = comboBox.getSelectedItem().toString();

				boolean gioiTinh = nam.isSelected();

				Date ngay = new Date();

				Person person = new Person(ma, ten, tuoi, cannang, chamsoc, gioiTinh, ngay);

				persons.add(person);
				// lấy kích thước mảng sau đó chuyển chuỗi rồi add lên số lượng
				txtList.setText(persons.size() + "");

			}
		});
		btnAdd.setBounds(384, 372, 145, 34);
		contentPane.add(btnAdd);

		// Xu ly nut gui nhieu doi tuong

		JButton btnSendList = new JButton("Send List Person");
		btnSendList.setBackground(new Color(255, 255, 51));
		btnSendList.setFont(new Font("Times New Roman", Font.BOLD, 18));

		btnSendList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (Person p : persons) {
					try {
						sendObj(p);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				// gửi xong sẽ clear khỏi mảng
				persons.clear();
				txtList.setText(persons.size() + "");
			}
		});

		btnSendList.setBounds(537, 372, 176, 34);
		contentPane.add(btnSendList);
		
	
		}
	}

	void sendObj(Person person) throws Exception {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		// config environment for JNDI
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		// create context
		Context ctx = new InitialContext(settings);
		// lookup JMS connection factory
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		// lookup destination. (If not exist-->ActiveMQ create once)
		Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
		// get connection using credential
		Connection con = factory.createConnection("admin", "admin");
		// connect to MOM
		con.start();
		// create session
		Session session = con.createSession(/* transaction */false, /* ACK */Session.AUTO_ACKNOWLEDGE);
		// create producer
		MessageProducer producer = session.createProducer(destination);
		// create text message
		Message msg = session.createTextMessage("hello mesage from ActiveMQ");
		producer.send(msg);
		String xml = new XMLConvert<Person>(person).object2XML(person);
		msg = session.createTextMessage(xml);
		producer.send(msg);
		// shutdown connection
		session.close();
		con.close();
		System.out.println("Finished...");
	}
}
