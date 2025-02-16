import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Vozilo extends Tura {
	static int id_auta;
	static String tip_vozila = "auto_231";
	static String marka;
	static int cijena;
	static String utovar_lok;
	static String utovar_datum;
	static String istovar_datum;
	static int vozilo_zavrseno = 0;
	static String istovar_lok;
	static String vlasnik;
	static int racun=0;
	static int placeno=0;
	static Scanner scan = new Scanner(System.in);
//lok saljem u bazu a tamo radimo sa lok

//svojstava vozila
	public static boolean take() {
		KONEKCIJA_baze kon = new KONEKCIJA_baze();
		Random_generator rand = new Random_generator();
		kon.kreiranje_konekcije();
		id_auta = rand.gen_id();
		// tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE
		try {
			String query = "insert into vozila (idvozila,tip_vozila,vlasnik_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,racun,zavresno,idTURE) values(?,?,?,?,?,?,?,?,?)";
			kon.pr = kon.con.prepareStatement(query);

			kon.pr.setInt(1, id_auta);
			kon.pr.setString(2, tip_vozila);
			kon.pr.setString(3, marka);
			kon.pr.setInt(4, cijena);
			kon.pr.setString(5, utovar_lok);
			kon.pr.setString(6, istovar_lok);
			kon.pr.setInt(7, racun);

			kon.pr.setInt(8, vozilo_zavrseno);
			kon.pr.setInt(9, id_ture);
			kon.pr.execute();

			String quers2 = "Select prihodi_ture from ture WHERE idTURE=?";

			kon.pr = kon.con.prepareStatement(quers2);
			kon.pr.setInt(1, id_ture);

			kon.rs = kon.pr.executeQuery();
			while (kon.rs.next()) {

				prihod_ture = kon.rs.getInt(1);
			}

			String quers3 = "UPDATE ture set prihodi_ture=? WHERE idTURE=?";
			prihod_ture += cijena;

			kon.pr = kon.con.prepareStatement(quers3);
			kon.pr.setInt(1, prihod_ture);
			kon.pr.setInt(2, id_ture);

			kon.pr.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Greska u ubacivanju u bazu");
			return false;
		}
		// povecat prihod ture za cijenz vozila
	}

	public static boolean close() {

		KONEKCIJA_baze kon = new KONEKCIJA_baze();
		Random_generator rand = new Random_generator();
		kon.kreiranje_konekcije();

		// tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE
		try {
			String quers = "UPDATE  vozila set placeno=? WHERE idvozila=?";
			kon.pr = kon.con.prepareStatement(quers);
			System.out.println(placeno);
			kon.pr.setInt(1, placeno);
			
			kon.pr.setInt(2, id_auta);
			kon.pr.execute();
			

			return true;
		} catch (Exception e) {
			System.out.println("Greska u ubacivanju u bazu za skidanje sa trajlera");
			return false;
		}

	}public static String rok_placanja(int id) {String datum_utovara_auta="";
		KONEKCIJA_baze kon = new KONEKCIJA_baze();
		Random_generator rand = new Random_generator();
		kon.kreiranje_konekcije();
		try {
			String quers = "Select datum_pocetka from ture where idTURE=(Select idTURE from vozila where idvozila=?)";
			kon.pr = kon.con.prepareStatement(quers);
			
			kon.pr.setInt(1,id);
			
		
			kon.rs = kon.pr.executeQuery();
			while (kon.rs.next()) {

				datum_utovara_auta = kon.rs.getString(1);
			}
			

			
		} catch (Exception e) {
			System.out.println("Greska dobijanju datuma kad je utovaren auto");
			
		}
		return datum_utovara_auta;
	}public static long proslo_dana(String date1) {
		SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy");
		long diff;
		long dani=0;
			
			try {
				Date danas=new Date();
			Date date2=format.parse(date1);
			 diff=danas.getTime()-date2.getTime();
			 dani=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			return dani;
		
		
	}
}
//funkcije vozila
/*
 * try {String query
 * ="insert into vozila (idvozila,tip_vozila,marka_vozila,cijena_vozila,utovar_lokacija,istovar_lokacija,utovar_datum,istovar_datum,zavrseno,idTURE) values(?,?,?,?,?,?,?,?,?,?)"
 * ; kon.pr=kon.con.prepareStatement(query);
 * 
 * kon.pr.setInt(1, id_auta); kon.pr.setString(2, tip_vozila);
 * kon.pr.setString(3, marka); kon.pr.setInt(4, cijena); kon.pr.setString(5,
 * utovar_lok); kon.pr.setString(6, istovar_lok); kon.pr.setString(7,
 * utovar_datum); kon.pr.setString(8, istovar_datum); kon.pr.setInt(9,
 * vozilo_zavrseno); kon.pr.setInt(10, id_ture); kon.pr.execute();
 */