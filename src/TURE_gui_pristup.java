import java.awt.EventQueue;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class TURE_gui_pristup {

	private JFrame frame;
	private JTextField tip_vozila;
	private JTextField marka_vozila;
	private JTextField cijena;
	private JTextField utovar_lokacija;
	private JTextField istovar_lokacija;
	private JTable table;
	private JTable table_1;
	private JTextField racun1;
	private JTextField id_auta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TURE_gui_pristup window = new TURE_gui_pristup();try { 
			            
			            IntelliJTheme.setup(TURE_gui_pristup.class.getResourceAsStream("/template.theme.json"));
			        } catch ( Exception e) {
			            e.printStackTrace();
			        }
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
	public TURE_gui_pristup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1402, 953);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 151));
		panel.setBounds(0, 11, 344, 916);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("PREGLED TURE");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(128, 255, 255));

		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 24));
		btnNewButton.setBounds(44, 169, 222, 81);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("NOVO VOZILO");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 24));

		btnNewButton_1.setBounds(44, 277, 222, 81);
		panel.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("MENU");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GUI_MENi meni = new GUI_MENi();
				meni.main(null);

			}
		}); 
		btnNewButton_4.setBackground(new Color(64, 128, 128));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnNewButton_4.setBounds(10, 21, 146, 71);
		panel.add(btnNewButton_4);
		
				JButton btnZavrsiTuru = new JButton("ZAVRSI TURU");
				btnZavrsiTuru.setForeground(new Color(255, 255, 255));
				btnZavrsiTuru.setContentAreaFilled(false);
				btnZavrsiTuru.setBorderPainted(false);
				btnZavrsiTuru.setBounds(55, 777, 222, 71);
				panel.add(btnZavrsiTuru);
				btnZavrsiTuru.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Tura tura_nova = new Tura();
						
						if (tura_nova.close_tura() == true) {

							JOptionPane.showMessageDialog(null, "Uspjesno zavrsena tura");
							btnNewButton_1.show(false);

						} else {
							JOptionPane.showMessageDialog(null, "Nazalost doslo je do greske u zavrsavanju ture");
						}
					}
				});
				btnZavrsiTuru.setBackground(new Color(128, 0, 0));
				btnZavrsiTuru.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 26));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(354, 11, 1024, 894);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		panel_1.add(layeredPane, "name_181521685662600");
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel dodavanje_vozila = new JPanel();
		dodavanje_vozila.setBackground(new Color(255, 255, 255));

		dodavanje_vozila.setLayout(null);

		JLabel tip_vozila1 = new JLabel("TIP VOZILA");
		tip_vozila1.setForeground(new Color(92, 96, 209));
		tip_vozila1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		tip_vozila1.setBounds(119, 96, 96, 58);
		dodavanje_vozila.add(tip_vozila1);

		JLabel marka_vozila1 = new JLabel("VLASNIK");
		marka_vozila1.setForeground(new Color(92, 96, 209));
		marka_vozila1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		marka_vozila1.setBounds(241, 96, 132, 58);
		dodavanje_vozila.add(marka_vozila1);

		JLabel cijena_auta1 = new JLabel("CIJENA");
		cijena_auta1.setForeground(new Color(92, 96, 209));
		cijena_auta1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		cijena_auta1.setBounds(366, 96, 88, 58);
		dodavanje_vozila.add(cijena_auta1);

		JLabel utovar_lokacija1 = new JLabel("UTOVAR LOKACIJA");
		utovar_lokacija1.setForeground(new Color(92, 96, 209));
		utovar_lokacija1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		utovar_lokacija1.setBounds(119, 220, 165, 58);
		dodavanje_vozila.add(utovar_lokacija1);

		JLabel istovar_lokacija1 = new JLabel("ISTOVAR LOKACIJA");
		istovar_lokacija1.setForeground(new Color(92, 96, 209));
		istovar_lokacija1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		istovar_lokacija1.setBounds(309, 220, 201, 58);
		dodavanje_vozila.add(istovar_lokacija1);

		tip_vozila = new JTextField();
		tip_vozila.setCaretColor(new Color(255, 255, 255));
		tip_vozila.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tip_vozila.setBounds(119, 152, 88, 35);
		dodavanje_vozila.add(tip_vozila);
		tip_vozila.setColumns(10);

		marka_vozila = new JTextField();
		marka_vozila.setFont(new Font("Times New Roman", Font.BOLD, 13));
		marka_vozila.setColumns(10);
		marka_vozila.setBounds(241, 152, 88, 35);
		dodavanje_vozila.add(marka_vozila);

		cijena = new JTextField();
		cijena.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cijena.setColumns(10);
		cijena.setBounds(366, 152, 66, 35);
		dodavanje_vozila.add(cijena);

		utovar_lokacija = new JTextField();
		utovar_lokacija.setFont(new Font("Times New Roman", Font.BOLD, 13));
		utovar_lokacija.setColumns(10);
		utovar_lokacija.setBounds(119, 289, 145, 58);
		dodavanje_vozila.add(utovar_lokacija);

		istovar_lokacija = new JTextField();
		istovar_lokacija.setFont(new Font("Times New Roman", Font.BOLD, 13));
		istovar_lokacija.setColumns(10);
		istovar_lokacija.setBounds(308, 289, 146, 58);
		dodavanje_vozila.add(istovar_lokacija);

		JLabel lblNewLabel_2 = new JLabel("INFORMACIJE O VOZILU");
		lblNewLabel_2.setForeground(new Color(92, 96, 209));
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 31));
		lblNewLabel_2.setBounds(119, 24, 396, 48);
		dodavanje_vozila.add(lblNewLabel_2);

		JButton btnNewButton_3 = new JButton("UTOVARI");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);

		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 28));
		btnNewButton_3.setBounds(99, 514, 165, 66);
		dodavanje_vozila.add(btnNewButton_3);
		
		racun1 = new JTextField();
		racun1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		racun1.setColumns(10);
		racun1.setBounds(183, 375, 66, 35);
		dodavanje_vozila.add(racun1);
		
		JLabel racun = new JLabel("RACUN");
		racun.setForeground(new Color(92, 96, 209));
		racun.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		racun.setBounds(119, 365, 115, 58);
		dodavanje_vozila.add(racun);

		JPanel pregled_ture = new JPanel();
		pregled_ture.setBackground(new Color(255, 255, 255));
		pregled_ture.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 12));
		scrollPane.setBounds(34, 217, 910, 464);
		pregled_ture.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		scrollPane_1.setBounds(34, 90, 936, 43);
		pregled_ture.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JLabel lblNewLabel_1 = new JLabel("INFO O TURI");
		lblNewLabel_1.setForeground(new Color(92, 96, 209));
		lblNewLabel_1.setBounds(34, 24, 257, 42);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 29));
		pregled_ture.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(pregled_ture);
				layeredPane.repaint();
				layeredPane.revalidate();
				table_1.setModel(new DefaultTableModel());
				table.setModel(new DefaultTableModel());
				ispis_ture();
				ispis_vozila();

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(dodavanje_vozila);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vozilo novo_vozilo = new Vozilo();
				novo_vozilo.tip_vozila = tip_vozila.getText();
				novo_vozilo.marka = marka_vozila.getText();
				novo_vozilo.cijena = Integer.parseInt(cijena.getText());
			
				novo_vozilo.utovar_lok = utovar_lokacija.getText();

				novo_vozilo.istovar_lok = istovar_lokacija.getText();
				novo_vozilo.racun = Integer.parseInt(racun1.getText());
				if (novo_vozilo.take() == true) {
					JOptionPane.showMessageDialog(null, "Uspjesno dodan novi auto na kamion");
				} else {
					JOptionPane.showMessageDialog(null, "Nazalost doslo je do greske u dodavanju auta");
				}

			}
		});
		
		
		JLabel lblNewLabel_1_1 = new JLabel("VOZILA NA TURI");
		lblNewLabel_1_1.setForeground(new Color(92, 96, 209));
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 27));
		lblNewLabel_1_1.setBounds(34, 159, 284, 42);
		pregled_ture.add(lblNewLabel_1_1);
		
		id_auta = new JTextField();
		id_auta.setBounds(34, 772, 145, 35);
		pregled_ture.add(id_auta);
		id_auta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID AUTA");
		lblNewLabel.setForeground(new Color(92, 96, 209));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(34, 727, 145, 32);
		pregled_ture.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("PLAĆEN");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setForeground(new Color(92, 96, 209));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vozilo novo=new Vozilo();
				novo.placeno=1;
				novo.id_auta=Integer.parseInt(id_auta.getText());
				if  (novo.close()==true) {
					JOptionPane.showMessageDialog(null, "Uspjesno naplacen auto");
				}else {
					JOptionPane.showMessageDialog(null, "Pogreska u naplati vozila");
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 27));
		btnNewButton_2.setBounds(221, 752, 154, 66);
		pregled_ture.add(btnNewButton_2);
		layeredPane.add(pregled_ture);
	}

	public void ispis_ture() {
		Tura turanova = new Tura();

		try {
			KONEKCIJA_baze kon = new KONEKCIJA_baze();
			kon.kreiranje_konekcije();
			String query = "Select idTURE,datum_pocetka,prihodi_ture,zavrsena_tura from ture where idTURE=?";

			kon.pr = kon.con.prepareStatement(query);
			kon.pr.setInt(1, turanova.id_ture);
			kon.rs = kon.pr.executeQuery();
			kon.rsmd = kon.rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();

			int cols = 4;
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = kon.rsmd.getColumnName(i + 1);
			}
			
			model.setColumnIdentifiers(colName);

			String[] atributi = new String[4];
			int brojac = 0;
			while (kon.rs.next()) {
				for (int i = 0; i < 4; i++) {
					atributi[i] = kon.rs.getString(i + 1);
				}
				model.addRow(atributi);
				
				

			}
		
turanova.id_ture = Integer.parseInt(atributi[0]);
			kon.pr.close();
			kon.con.close();
			
		} catch (Exception e) {
			System.out.println("kreska ispisa tablice ture");
		}
		
	}

	public void ispis_vozila() {
		try {
			KONEKCIJA_baze kon = new KONEKCIJA_baze();
			kon.kreiranje_konekcije();
			String query = "Select * from vozila where idTURE=?";
			Tura turanova = new Tura();

			kon.pr = kon.con.prepareStatement(query);
			kon.pr.setInt(1, turanova.id_ture);
			kon.rs = kon.pr.executeQuery();
			kon.rsmd = kon.rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			int cols = kon.rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = kon.rsmd.getColumnName(i + 1);
			}
			for (int i = 0; i < cols; i++) {

			}
			model.setColumnIdentifiers(colName);

			String[] atributi = new String[12];
			int brojac = 0;
			while (kon.rs.next()) {
				for (int i = 0; i < 12; i++) {
					atributi[i] = kon.rs.getString(i + 1);
				}
				model.addRow(atributi);
			}

			kon.pr.close();
			kon.con.close();
		} catch (Exception e) {
			System.out.println("greska ispisa tablice vozila");
		}
	}
}
