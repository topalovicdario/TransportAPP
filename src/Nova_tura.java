import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Nova_tura {

	private JFrame frame;
	private JTextField datum_pocekta;
	private JTextField novac_gorivo;
	private JTextField litara_goriva;
	private JTextField putarina_trosak;
	private JTextField steta_ture;
	private JTextField kazna_ture;
	private JTextField opis_stete;
	private JTextField opis_kazne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nova_tura window = new Nova_tura();
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
	public Nova_tura() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 26));
		frame.setBounds(100, 100, 1339, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("KREIRANJE TURE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(128, 128, 192));
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(967, 44, 348, 102);
		frame.getContentPane().add(lblNewLabel);

		datum_pocekta = new JTextField();
		datum_pocekta.setBounds(1056, 231, 176, 35);
		frame.getContentPane().add(datum_pocekta);
		datum_pocekta.setColumns(10);

		novac_gorivo = new JTextField();
		novac_gorivo.setColumns(10);
		novac_gorivo.setBounds(57, 160, 168, 44);
		frame.getContentPane().add(novac_gorivo);

		JLabel lblNewLabel_1 = new JLabel("DATUM POCETKA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		lblNewLabel_1.setBounds(1056, 185, 188, 35);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("NASUTO GORIVA CIJENA");
		lblNewLabel_2.setForeground(new Color(92, 96, 209));
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_2.setBounds(57, 111, 319, 38);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("NASUTO GORIVA LITARA");
		lblNewLabel_2_1.setForeground(new Color(92, 96, 209));
		lblNewLabel_2_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(57, 215, 319, 38);
		frame.getContentPane().add(lblNewLabel_2_1);

		litara_goriva = new JTextField();
		litara_goriva.setColumns(10);
		litara_goriva.setBounds(57, 264, 168, 44);
		frame.getContentPane().add(litara_goriva);

		JButton btnNewButton = new JButton("KREIRAJ TURU");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tura nova = new Tura();
				try {
					nova.datum_pocetka = datum_pocekta.getText();
				nova.nasuto_goriva = Integer.parseInt(litara_goriva.getText());
				nova.novac_na_gorivo = Integer.parseInt(novac_gorivo.getText());
				nova.putarine = Integer.parseInt(putarina_trosak.getText());
				nova.steta=Integer.parseInt("0"+steta_ture.getText());
				nova.kazna=Integer.parseInt("0"+steta_ture.getText());
				nova.opis_kazne = opis_kazne.getText();
				nova.opis_stete = opis_stete.getText();
				
				if ( nova.prosla_tura() == true) {
					System.out.println("cao");
					if (nova.get_tura() == true) {
						TURE_gui_pristup gui = new TURE_gui_pristup();
					frame.dispose();
					gui.main(null);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Nazalost doslo je do greske u dodavju nove ture");
				}
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Nazalost doslo je do greske u upisu");
				}
				
				

			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 26));
		btnNewButton.setBounds(1023, 319, 236, 72);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("PUTARINE");
		lblNewLabel_3.setForeground(new Color(92, 96, 209));
		lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_3.setBounds(57, 319, 111, 44);
		frame.getContentPane().add(lblNewLabel_3);

		putarina_trosak = new JTextField();
		putarina_trosak.setBounds(57, 374, 151, 44);
		frame.getContentPane().add(putarina_trosak);
		putarina_trosak.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("PROSLA TURA");
		lblNewLabel_4.setForeground(new Color(92, 96, 209));
		lblNewLabel_4.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
		lblNewLabel_4.setBounds(60, 25, 255, 56);
		frame.getContentPane().add(lblNewLabel_4);
		
		steta_ture = new JTextField();
		steta_ture.setColumns(10);
		steta_ture.setBounds(57, 484, 151, 44);
		frame.getContentPane().add(steta_ture);
		
		JLabel lblNewLabel_3_1 = new JLabel("CIJENA STETE");
		lblNewLabel_3_1.setForeground(new Color(92, 96, 209));
		lblNewLabel_3_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_3_1.setBounds(57, 429, 168, 44);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		kazna_ture = new JTextField();
		kazna_ture.setColumns(10);
		kazna_ture.setBounds(57, 607, 151, 44);
		frame.getContentPane().add(kazna_ture);
		
		JLabel lblNewLabel_3_2 = new JLabel("CIJENA KAZNE");
		lblNewLabel_3_2.setForeground(new Color(92, 96, 209));
		lblNewLabel_3_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_3_2.setBounds(57, 552, 168, 44);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 484, 646, 44);
		frame.getContentPane().add(scrollPane);
		
		opis_stete = new JTextField();
		scrollPane.setViewportView(opis_stete);
		opis_stete.setColumns(10);
		
		JLabel lblNewLabel_3_3 = new JLabel("OPIS");
		lblNewLabel_3_3.setForeground(new Color(92, 96, 209));
		lblNewLabel_3_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_3_3.setBounds(256, 429, 151, 44);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(257, 608, 645, 42);
		frame.getContentPane().add(scrollPane_1);
		
		opis_kazne = new JTextField();
		scrollPane_1.setViewportView(opis_kazne);
		opis_kazne.setColumns(10);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("OPIS");
		lblNewLabel_3_3_1.setForeground(new Color(92, 96, 209));
		lblNewLabel_3_3_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblNewLabel_3_3_1.setBounds(256, 552, 151, 44);
		frame.getContentPane().add(lblNewLabel_3_3_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 23, 131));
		panel.setBounds(939, 11, 376, 659);
		frame.getContentPane().add(panel);

	}
}
