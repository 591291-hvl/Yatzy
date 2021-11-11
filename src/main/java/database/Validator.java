package database;

public class Validator {

	public static boolean isGyldigName(String name) {

		if (name == null) {
			return false;
		}
		return name.matches("^[A-Z���][a-z���]*(([ -])[A-Z���][a-z���]*)*$");
	}
//^[A-Z���][a-z���]+(\\s|-)?[A-Z���][a-z���]+$
//^[A-Z���][A-Z���a-z���0-9- ]{3,19}$
	public static boolean isGyldigMobil(String mobil) {
		if (mobil == null) {
			return false;
		}
		return mobil.matches("^\\d{8}$");
	}

	public static boolean isGyldigPassord(String passord) {
		if (passord == null) {
			return false;
		}
		return passord.matches("^(?=.*[0-9])(?=.*[a-z���])(?=.*[A-Z���])(?=.*[\\W|\\_])(?=\\S+$).{8,}$");
	}
}