import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;
import java.util.Random;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import java.util.Random;

public class Random_generator {
	static int id2 = 1;

	public static int gen_id() {
		Random rand = new Random();
		int id = rand.nextInt(10000);
		if (check(id) == true) {
			return id;

		} else {
			return gen_id();
		}

	}

	private static boolean check(int a) {
		KONEKCIJA_baze kon = new KONEKCIJA_baze();
		kon.kreiranje_konekcije();
		boolean b = false;
		String query2 = "Select idTURE from ture";

		try {
			kon.pr = kon.con.prepareStatement(query2);
			kon.rs = kon.pr.executeQuery();

			while (kon.rs.next()) {
				if (kon.rs.getInt(1) == a) {

					return false;
				} else {

					b = true;
				}
			}
		} catch (Exception e) {
			System.out.println("Greska u pozivu baze za pretrazivanje postojecih brojeva");

		}

		return b;

	}

	public static int brojac() {

		if (check(id2) == true) {
			return id2;

		} else {
			id2++;
			return brojac();
		}

	}

}
