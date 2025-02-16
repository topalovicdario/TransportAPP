import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Arhiva {

	private JFrame frame;
	private JTextField id_ture2;
	private JTable table;
	private JTable table_1;
	private JTextField id_auta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arhiva window = new Arhiva();
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
	public Arhiva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1644, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 23, 131));
		panel.setBounds(10, 0, 271, 727);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton auto = new JButton("AUTA");
		auto.setForeground(new Color(255, 255, 255));
		auto.setBorderPainted(false);
		auto.setContentAreaFilled(false);

		auto.setBackground(new Color(0, 128, 64));
		auto.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
		auto.setBounds(20, 133, 195, 71);
		panel.add(auto);

		JButton ture = new JButton("TURE");
		ture.setForeground(new Color(255, 255, 255));
		ture.setContentAreaFilled(false);
		ture.setBorderPainted(false);

		ture.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
		ture.setBackground(new Color(0, 128, 64));
		ture.setBounds(20, 229, 195, 71);
		panel.add(ture);

		JButton btnNewButton = new JButton("MENU");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GUI_MENi novi = new GUI_MENi();
				novi.main(null);
			}
		});
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(20, 11, 117, 78);
		panel.add(btnNewButton);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(284, 11, 1326, 716);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel ture_show = new JPanel();
		ture_show.setBackground(new Color(255, 255, 255));
		layeredPane.add(ture_show, "name_4370533327400");
		ture_show.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(92, 96, 209));
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		lblNewLabel.setBounds(16, 615, 29, 40);
		ture_show.add(lblNewLabel);

		id_ture2 = new JTextField();
		id_ture2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		id_ture2.setBounds(55, 617, 124, 40);
		ture_show.add(id_ture2);
		id_ture2.setColumns(10);

		JButton sveture = new JButton("PRETRAZI SVE TURE");
		sveture.setForeground(new Color(92, 96, 209));
		sveture.setHorizontalAlignment(SwingConstants.LEFT);
		sveture.setContentAreaFilled(false);
		sveture.setBorderPainted(false);
		sveture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(ture_show);
				layeredPane.repaint();
				layeredPane.revalidate();

				table.setModel(new DefaultTableModel());
				ispis_ture();

			}
		});
		sveture.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		sveture.setBackground(new Color(128, 0, 0));
		sveture.setBounds(10, 11, 350, 40);
		ture_show.add(sveture);

		JButton pregled_vozila = new JButton("PREGLED VOZILA");
		pregled_vozila.setForeground(new Color(92, 96, 209));
		pregled_vozila.setBorderPainted(false);
		pregled_vozila.setContentAreaFilled(false);
		pregled_vozila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tura nova = new Tura();
				nova.id_ture = Integer.parseInt(id_ture2.getText());

				table.setModel(new DefaultTableModel());
				ispis_vozila_id();

			}
		});
		pregled_vozila.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		pregled_vozila.setBackground(new Color(128, 0, 0));
		pregled_vozila.setBounds(229, 615, 217, 40);
		ture_show.add(pregled_vozila);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 62, 1306, 534);
		ture_show.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);

		JPanel auta_show = new JPanel();
		auta_show.setBackground(new Color(255, 255, 255));
		layeredPane.add(auta_show, "name_4391446257200");
		auta_show.setLayout(null);

		JButton pretrazi_auta_ime = new JButton("PRETRAZI AUTA KOJA NISU NAPLACENA");
		pretrazi_auta_ime.setForeground(new Color(92, 96, 209));
		pretrazi_auta_ime.setHorizontalAlignment(SwingConstants.LEFT);
		pretrazi_auta_ime.setContentAreaFilled(false);
		pretrazi_auta_ime.setBorderPainted(false);

		pretrazi_auta_ime.setBackground(new Color(128, 0, 0));
		pretrazi_auta_ime.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 33));
		pretrazi_auta_ime.setBounds(24, 11, 698, 46);
		auta_show.add(pretrazi_auta_ime);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(255, 255, 255));
		scrollPane_1.setBounds(38, 68, 1258, 626);
		auta_show.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID AUTA");
		lblNewLabel_1.setForeground(new Color(92, 96, 209));
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		lblNewLabel_1.setBounds(921, 12, 88, 46);
		auta_show.add(lblNewLabel_1);
		
		id_auta = new JTextField();
		id_auta.setBounds(1032, 14, 81, 46);
		auta_show.add(id_auta);
		id_auta.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("NAPLATI");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(new Color(92, 96, 209));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				Vozilo novo = new Vozilo();
				novo.id_auta=Integer.parseInt(id_auta.getText());
				if  (novo.close()==true) {
					JOptionPane.showMessageDialog(null, "Uspjesno naplacen auto");
				}else {
					JOptionPane.showMessageDialog(null, "Pogreska u naplati vozila");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 23));
		btnNewButton_1.setBounds(1147, 12, 149, 46);
		auta_show.add(btnNewButton_1);
		ture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(ture_show);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(auta_show);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		pretrazi_auta_ime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vozilo novo = new Vozilo();
				novo.placeno=1;
				table_1.setModel(new DefaultTableModel());
				ispis_neplacenih_vozila();
				
			}
		});

	}

	public void ispis_ture() {
		Tura turanova = new Tura();

		try {
			KONEKCIJA_baze kon = new KONEKCIJA_baze();
			kon.kreiranje_konekcije();
			String query = "Select * from ture";

			kon.pr = kon.con.prepareStatement(query);

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
			String[] atributi = new String[cols];
			int brojac = 0;
			while (kon.rs.next()) {

				for (int i = 0; i < cols; i++) {
					atributi[i] = kon.rs.getString(i + 1);
				}
				model.addRow(atributi);

			}

			kon.pr.close();
			kon.con.close();
		} catch (Exception e) {
			System.out.println("greska ispisa svih tura");
		}
	}

	public void ispis_vozila_id() {
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

			String[] atributi = new String[cols];
			int brojac = 0;
			while (kon.rs.next()) {
				for (int i = 0; i < cols; i++) {
					atributi[i] = kon.rs.getString(i + 1);
				}
				model.addRow(atributi);
			}

			kon.pr.close();
			kon.con.close();
		} catch (Exception e) {
			System.out.println("greska ispisa vozila po id");
		}
	}

	public void ispis_neplacenih_vozila() {
		try {
			KONEKCIJA_baze kon = new KONEKCIJA_baze();
			kon.kreiranje_konekcije();
			String query = "Select * from vozila where placeno=0";
		

			kon.pr = kon.con.prepareStatement(query);
			
			kon.rs = kon.pr.executeQuery();
			kon.rsmd = kon.rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();

			int cols = kon.rsmd.getColumnCount()+2;
			String[] colName = new String[cols];
			
			for (int i = 0; i < cols-2; i++) {
				colName[i] = kon.rsmd.getColumnName(i + 1);
			}
		colName[cols-2]="Datum ture";
		colName[cols-1]="Proslo dana";
			model.setColumnIdentifiers(colName);

			String[] atributi = new String[cols-2];
			int brojac = 0;
			while (kon.rs.next()) {
				brojac++;
				for (int i = 0; i < cols-2; i++) {
					atributi[i] = kon.rs.getString(i + 1);
				}
				;
				
				model.addRow(atributi);
			}
			
                 Vozilo novo=new Vozilo();
				
				
				for (int i=0; i<brojac; i++) {
					int a=Integer.parseInt(model.getValueAt(i, 0).toString());
					
					
					String datum_utovara=novo.rok_placanja(a);
				   long broj_dana=novo.proslo_dana(datum_utovara)-7;
					model.setValueAt(datum_utovara, i, 12);
					model.setValueAt(broj_dana, i, 13);
				}
			kon.pr.close();
			kon.con.close();
		} catch (Exception e) {
			System.out.println("greska ispisa vozila po placenosti");
		}
	}

}// provjeti zasto daje pogreske u kontaktu sa bazom
