import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tura extends Firma {
	static int id_ture = 11;
	static int prihod_ture = 0;
	static String ime_ture;
	static String tip_ture;
	static String datum_pocetka = "12.2.12";
	static int kazna=0;
	static int steta=0;
	static String opis_kazne="";
	static String opis_stete="";
	static int nasuto_goriva = 0;
	static int novac_na_gorivo = 0;
	static int dobit_ture = 0;
	static int rashodi_ture = 0;
	static int zavrseno = 0;
	static int putarine = 0;
	// broj kilometara predjenih na turi

	// svojstva
	static Scanner scan = new Scanner(System.in);

	public static boolean get_tura() {
		
		

		// tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE
		try {
			KONEKCIJA_baze kon = new KONEKCIJA_baze();
			kon.kreiranje_konekcije();
			String query = "insert into ture (datum_pocetka,idTURE,zavrsena_tura) values(?,?,?) ";
			kon.pr = kon.con.prepareStatement(query);
			System.out.println(id_ture);
			kon.pr.setString(1, datum_pocetka);
			kon.pr.setInt(2, id_ture);
			kon.pr.setString(3, "nije");
			System.out.println("tu3");
			kon.pr.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Greska u kreiranju ture");
			return false;
		}

	}// zamjentit tip pdoataka u datumu tura u varchar i pogleda zastio nece da
		// kreira turu

	public static boolean close_tura() {
		// proc kroz bazu u vidit da li postoje objekti vozila pod id ture a da im je
		// stanje false u zavrsenosti
		prihodi += prihod_ture;
		rashodi += rashodi_ture;

		KONEKCIJA_baze kon = new KONEKCIJA_baze();

		kon.kreiranje_konekcije();

		// tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE
		try {
			String quers = "UPDATE ture set zavrsena_tura=? WHERE idTURE=?";

			kon.pr = kon.con.prepareStatement(quers);
			
			kon.pr.setString(1, "Zavrsena");
			kon.pr.setInt(2, id_ture);
			kon.pr.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Greska u zavrsavanju ture");
			return false;
		}
	}

	public static boolean prosla_tura() {
		KONEKCIJA_baze kon = new KONEKCIJA_baze();
		id_ture = Random_generator.brojac();
		kon.kreiranje_konekcije();

		// tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE
		try {
			String quers2 = "Select rashodi_ture, prihodi_ture from ture WHERE idTURE=?";

			kon.pr = kon.con.prepareStatement(quers2);
			kon.pr.setInt(1, id_ture - 1);

			kon.rs = kon.pr.executeQuery();
			while (kon.rs.next()) {

				rashodi_ture = kon.rs.getInt(1);
				
				prihod_ture = kon.rs.getInt(2);
			}

			

			String quers = "UPDATE ture set nasuto_goriva=?, novac_na_gorivo=?, rashodi_ture=?, putarine=?, dobit_ture=?,kazne=?,ostecenja=?,kazna_opis=?,ostecenja_opis=? WHERE idTURE=?";
			rashodi_ture += putarine + novac_na_gorivo+kazna+steta;
			
			System.out.println(rashodi_ture + " rashodi");
			kon.pr = kon.con.prepareStatement(quers);
			dobit_ture = prihod_ture - rashodi_ture;
			kon.pr.setInt(1, nasuto_goriva);
			kon.pr.setInt(2, novac_na_gorivo);
			kon.pr.setInt(3, rashodi_ture);
			kon.pr.setInt(4, putarine);
			kon.pr.setInt(5, dobit_ture);
			
			kon.pr.setInt(6, kazna);
			kon.pr.setInt(7, steta);
			kon.pr.setString(8, opis_kazne);
			kon.pr.setString(9, opis_stete);
			
			kon.pr.setInt(10, id_ture - 1);
			System.out.println("cao mace");
			kon.pr.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Greska u dodovanju vrijendosti za gorivo prethodne ture");
			return false;
		}

	}

	// funkcije ture

}