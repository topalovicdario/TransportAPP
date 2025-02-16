import java.awt.EventQueue;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JFrame;
import javax.swing.JTextField; 
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.IntelliJTheme;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
//proracun stanja firme, dodavanja odjela za stetu i kazne u tablici ture, 
public class GUI_MENi {

	public JFrame frame;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MENi window = new GUI_MENi();try { 
		            
		            IntelliJTheme.setup(GUI_MENi.class.getResourceAsStream("/template.theme.json"));
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
	public GUI_MENi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));

		frame.setBounds(100, 100, 1563, 865);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		 frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 23, 131));
		panel.setBounds(10, 0, 447, 817);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
				JButton btnNewButton_1 = new JButton("ARHIVA FIRME");
				btnNewButton_1.setContentAreaFilled(false);
				btnNewButton_1.setBorderPainted(false);
				btnNewButton_1.setBounds(60, 193, 291, 73);
				panel.add(btnNewButton_1);
				btnNewButton_1.setBackground(new Color(255, 128, 64));
				btnNewButton_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
				btnNewButton_1.setForeground(new Color(255, 255, 255));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Arhiva arhiva = new Arhiva();
						arhiva.main(null);
					}
				});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(459, 0, 1090, 817);
		frame.getContentPane().add(panel_1);
				panel_1.setLayout(new CardLayout(0, 0));
		
				JButton btnNewButton = new JButton("VAŠA TURA");
				btnNewButton.setBorderPainted(false);
				btnNewButton.setContentAreaFilled(false);
				btnNewButton.setBounds(60, 95, 291, 72);
				panel.add(btnNewButton, "name_100878802095300");
				btnNewButton.setBackground(new Color(255, 128, 0));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 35));
				
				lblNewLabel = new JLabel("POWERED BY DARIO");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setBounds(10, 11, 291, 73);
				panel.add(lblNewLabel, "name_100878816237000");
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				
				JLayeredPane layeredPane = new JLayeredPane();
				panel_1.add(layeredPane, "name_100888849481300");
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(10, 11, 1070, 795);
				layeredPane.add(panel_2);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBounds(10, 11, 1070, 795);
				layeredPane.add(panel_3);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// if select iz tablice tura pod tipom postoji false onda ga saljes na ucitanu
						// turu ako je true kreira novu turu otvara drugi gui
						frame.dispose();
						KONEKCIJA_baze kon = new KONEKCIJA_baze();
						Random_generator rand = new Random_generator();
						kon.kreiranje_konekcije();
						int broj = -1;
						// tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE
						try {
							String quers = "Select idTURE from ture where zavrsena_tura='nije'";
							kon.pr = kon.con.prepareStatement(quers);
							kon.rs = kon.pr.executeQuery();
							while (kon.rs.next()) {
								broj = kon.rs.getInt(1);
							}

						} catch (Exception e2) {
							System.out.println("Greska otvaranja ture");

						}
						if (broj == -1) {
							Nova_tura nova_tura = new Nova_tura();
							nova_tura.main(null);
						} else {
							Tura tura1 = new Tura();
							tura1.id_ture = broj;
							
							TURE_gui_pristup ture = new TURE_gui_pristup();
							ture.main(null);
						}

					}
				});
	}
}
