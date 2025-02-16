import java.util.ArrayList;
import java.util.List;

public class Firma {
	static double prihodi = 0;
	static double rashodi = 0;
	static double dobit = 0;
	static double dug = 0;
	static double plata_vozaca = 600;
	// stanja

	public static void proracun_dobiti() {
		dobit = prihodi - rashodi;
	}

	public static boolean plati_vozaca() {
		if (prihodi >= plata_vozaca) {
			rashodi -= plata_vozaca;

			System.out.println("Platili ste radnika");
			return true;
		} else {
			System.out.println("Nemate dovoljno novca da platite radnika");
			return false;
		}
	}
	// funkcije firme
}
