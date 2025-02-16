import java.sql.DriverManager;
import java.sql.*;

public class KONEKCIJA_baze {
	static Connection con;
	static Statement st;
	static PreparedStatement pr;
	static ResultSet rs;
	static ResultSetMetaData rsmd;

	public static void kreiranje_konekcije() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/firma_transport", "root", "12345");

		} catch (Exception e) {
			System.out.println("Nema konekcije sa bazom");
		}

	}
}
//Statement st=con.createStatement();
//String query="select * from ture";
//ResultSet rs=st.executeQuery(query);
//String a="";
//while (rs.next()) {
//	a=rs.getString(2);
//}
//System.out.println(a);