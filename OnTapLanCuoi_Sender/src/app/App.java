package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Person;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class App extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtMa ;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField  ;
	private ArrayList<Person> persons = new ArrayList<Person>();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SENDER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(343, 23, 97, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã benh nhan");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(59, 107, 156, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên benh nhan");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(59, 163, 132, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tuoi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(59, 211, 132, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nguoi cham soc");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(59, 251, 156, 27);
		contentPane.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_6 = new JLabel("Ngay den");
		lblNewLabel_6 .setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6 .setBounds(59, 354, 156, 27);
		contentPane.add(lblNewLabel_6 );
		
		
		
		
		txtMa  = new JTextField();
		txtMa .setBounds(250, 107, 301, 26);
		contentPane.add(txtMa );
		txtMa .setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(250, 163, 301, 26);
		contentPane.add(txtTen);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(250, 218, 301, 26);
		contentPane.add(txtTen);
			
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(250, 355, 301, 26);
		contentPane.add(txtTuoi);
		
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(250, 257, 301, 27);
		List<String> list = new ArrayList<String>();
		list.add("Y tá số 1");
		list.add("Y tá số 2");
		list.add("Y tá số 3");
		list.add("Y tá số 4");
		
		for(String s : list) {
			comboBox.addItem(s);
			contentPane.add(comboBox);
			
			JLabel lblNewLabel_5 = new JLabel("Gioi tinh");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_5.setBounds(59, 299, 156, 27);
			contentPane.add(lblNewLabel_5);

			JRadioButton nam= new JRadioButton("Nam");
			nam.setFont(new Font("Tahoma", Font.BOLD, 16));
			nam.setBounds(249, 305, 103, 21);
			contentPane.add(nam);
			ButtonGroup G = new ButtonGroup();
			G.add(nam);
			
			JRadioButton nu = new JRadioButton("Nu");
			 nu.setFont(new Font("Tahoma", Font.BOLD, 17));
			 nu.setBounds(354, 305, 103, 21);
			contentPane.add( nu);
			G.add(nu);
		
		
			JButton btnSendObj = new JButton("Send Object");
			btnSendObj.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnSendObj.setBounds(130, 430, 148, 36);
			// Xu ly gui doi tuong
			btnSendObj.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int ma = Integer.parseInt(txtMa.)
					
				}
			});
			
			contentPane.add(btnSendObj);
			
			
			
			JButton btnAddList = new JButton("Add List");
			btnAddList.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnAddList.setBounds(309, 430, 148, 36);
			contentPane.add(btnAddList);
			
			JButton btnSendListObject = new JButton("Send List Object");
			btnSendListObject.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnSendListObject.setBounds(494, 430, 169, 36);
			contentPane.add(btnSendListObject);
			
		
		
		}
		
		
	
	}
}
