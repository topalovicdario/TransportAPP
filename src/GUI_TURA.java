import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_TURA extends JFrame {
	static Connection con;
	static Statement st;
	static ResultSet rs;
	static ResultSetMetaData rsmd;
String id_ture;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTura;
	private JTable table;
	private JTextField txtVozilaNaTuri;
	private JTable table_1;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TURA frame = new GUI_TURA();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}public  void tablica_tura() {
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(54, 120, 1152, 72);
	contentPane.add(scrollPane);
	
	table = new JTable();
	table.setEnabled(false);
	table.setFont(new Font("Times New Roman", Font.BOLD, 15));
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
		}
	));
	scrollPane.setViewportView(table);
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3307/firma_transport","root","12345");	
	
			String query="Select * from ture where zavrsena_tura='nije'";
			
			
		
			st=con.createStatement();
			
			rs=st.executeQuery(query);
			rsmd=rs.getMetaData();
			
			
			int cols=rsmd.getColumnCount();
			String []colName=new String[cols];
			for (int i=0; i<cols; i++) {
				colName[i]=rsmd.getColumnName(i+1);
				}
			for (int i=0; i<5; i++) {
				System.out.println(colName[i]+"a");
			}
				model.setColumnIdentifiers(colName);
				
				String []atributi=new String [11];
				int brojac=0;
				while(rs.next()) {
					for (int i=0; i<11; i++) {
						
						atributi[i]=rs.getString(i+1);
					}
					
					model.addRow(atributi);
				}
				
			id_ture=atributi[0];
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("cao");
		}
	
	}
	public  void tablica_auta() {scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(54, 377, 968, 381);
	contentPane.add(scrollPane_1);
	
	table_1 = new JTable();
	scrollPane_1.setViewportView(table_1);
	
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3307/firma_transport","root","12345");	
			
			String query="Select * from vozila where idTURE="+id_ture;
			
			
		
			st=con.createStatement();
			
			rs=st.executeQuery(query);
			rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table_1.getModel();
			
			int cols=rsmd.getColumnCount();
			String []colName=new String[cols];
			for (int i=0; i<cols; i++) {
				colName[i]=rsmd.getColumnName(i+1);
				}
			for (int i=0; i<cols; i++) {
				System.out.println(colName[i]);
			}
				model.setColumnIdentifiers(colName);
				
				String []atributi=new String [11];
				int brojac=0;
				while(rs.next()) {
					for (int i=0; i<10; i++) {
						atributi[i]=rs.getString(i+1);
					}
					model.addRow(atributi);
				}
			System.out.println("cao2");
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("cao");
		}
	}
	

	/**
	 * Create the frame.
	 */
	public GUI_TURA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 859);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTura = new JTextField();
		txtTura.setBackground(new Color(128, 128, 128));
		txtTura.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtTura.setText("TURA");
		txtTura.setBounds(54, 39, 105, 44);
		contentPane.add(txtTura);
		txtTura.setColumns(10);
		
		
		txtVozilaNaTuri = new JTextField();
		txtVozilaNaTuri.setBackground(new Color(128, 128, 64));
		txtVozilaNaTuri.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtVozilaNaTuri.setHorizontalAlignment(SwingConstants.CENTER);
		txtVozilaNaTuri.setText("VOZILA NA TURI");
		txtVozilaNaTuri.setBounds(54, 251, 213, 72);
		contentPane.add(txtVozilaNaTuri);
		txtVozilaNaTuri.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("DODAJ VOZILO");
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vozilo vozilo =new Vozilo();
				
				//dodaj.main(null);
			}
		});
		btnNewButton.setBounds(1062, 534, 207, 83);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("NAZAD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);				GUI_MENi nova=new GUI_MENi();
				nova.frame.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnNewButton_1.setBounds(1016, 11, 257, 83);
		contentPane.add(btnNewButton_1);
			
		tablica_tura();
		tablica_auta();
	}
}
