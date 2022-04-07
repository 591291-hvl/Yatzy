package password;

public class Validator {

	public static final String ANY_LETTER_SPACE_OR_HYPHEN = "[a-zA-ZæøåÆØÅ -]";
	public static final String ANY_LETTER_OR_HYPHEN = "[a-zA-ZæøåÆØÅ-]";
	public static final String ANY_CAPITAL_LETTER = "[A-ZÆØÅ]";
	public static final String ANY_DIGIT = "[0-9]";

	public static final String ZERO_OR_MORE_TIMES = "*";
	public static final String ONE_TO_NINETEEN_TIMES = "{1,19}";
	public static final String EIGHT_TIMES = "{8}";

	/**
	 * @param brukernavn
	 * @return
	 */
	public static boolean isValidBrukernavn(String brukernavn) {
		return brukernavn != null && brukernavn.matches("^" + ANY_LETTER_OR_HYPHEN + ONE_TO_NINETEEN_TIMES + "$");
	}

	/**
	 * @param navn
	 * @return
	 */
	public static boolean isValidNavn(String navn) {
		return navn != null && navn.matches("^" + ANY_CAPITAL_LETTER + ANY_LETTER_SPACE_OR_HYPHEN + ZERO_OR_MORE_TIMES + "$");
	}

	/**
	 * 
	 * @param epost
	 * @return
	 */
	public static boolean isValidEpost(String epost) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @param passord
	 * @return
	 */
	public static boolean isValidPassord(String passord) {
		return passord != null && passord.length() >= 4;
	}

}
