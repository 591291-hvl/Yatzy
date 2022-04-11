package servletUtil;

import javax.servlet.http.HttpServletRequest;

import dao.SpillerDAO;
import entity.SpillerEntity;
import password.Passord;
import password.Validator;


public class SpillerForm {

	private String brukernavn;
	private String brukernavnMelding;

	private String navn;
	private String navnMelding;

	private String epost;
	private String epostMelding;

	private String passord;
	private String passordMelding;

	private String passordRepetert;
	private String passordRepetertMelding;

	private boolean alleGyldig;

	public SpillerEntity lagSpillerFraForm() {
		Passord passordHash = Passord.lagPassord(passord);
		return new SpillerEntity(brukernavn, navn, epost, passordHash);
	}

	public void populerFraRequestOgSettOppEvtFeilmeldinger(HttpServletRequest request, SpillerDAO spillerDao) {
		populerFraRequest(request);
		settOppEvtFeilmeldinger(spillerDao);
	}

	private void populerFraRequest(HttpServletRequest request) {
		brukernavn = request.getParameter("brukernavn");
		navn = request.getParameter("navn");
		epost = request.getParameter("epost");
		passord = request.getParameter("passord");
		passordRepetert = request.getParameter("passordRepetert");
	}

	private void settOppEvtFeilmeldinger(SpillerDAO spillerDao) {

		boolean brukernavnOk = Validator.isValidBrukernavn(brukernavn);
		boolean finnesAllerede = spillerDao.erRegistrert(brukernavn);
		if (!brukernavnOk) {
			brukernavn = "";
			brukernavnMelding = "Ugyldig brukernavn";
		} else if (finnesAllerede) {
			brukernavn = "";
			brukernavnMelding = "Brukernavn finnes allerede";
		}

		boolean navnOk = Validator.isValidNavn(navn);
		if (!navnOk) {
			navn = "";
			navnMelding = "Ugyldig navn";
		}

		boolean epostOk = Validator.isValidEpost(epost);
		if (!epostOk) {
			epost = "";
			epostMelding = "Ugyldig navn";
		}

		boolean passordOk = Validator.isValidPassord(passord);
		if (!passordOk) {
			passord = ""; // Kanskje passord burde v�rt blanket ut uansett?!
			passordMelding = "Ugyldig passord";
		}

		boolean passordRepOk = passordOk && passord.equals(passordRepetert);
		if (!passordRepOk) {
			passordRepetert = ""; // Kanskje passord burde v�rt blanket ut uansett?!
			passordRepetertMelding = "Passordene m� v�re like";
		}

		alleGyldig = brukernavnOk && navnOk && epostOk && !finnesAllerede && passordOk && passordRepOk;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getBrukernavnMelding() {
		return brukernavnMelding;
	}

	public void setBrukernavnMelding(String brukernavnMelding) {
		this.brukernavnMelding = brukernavnMelding;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavnMelding() {
		return navnMelding;
	}

	public void setNavnMelding(String navnMelding) {
		this.navnMelding = navnMelding;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getEpostMelding() {
		return epostMelding;
	}

	public void setEpostMelding(String epostMelding) {
		this.epostMelding = epostMelding;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordMelding() {
		return passordMelding;
	}

	public void setPassordMelding(String passordMelding) {
		this.passordMelding = passordMelding;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public void setPassordRepetert(String passordRepetert) {
		this.passordRepetert = passordRepetert;
	}

	public String getPassordRepetertMelding() {
		return passordRepetertMelding;
	}

	public void setPassordRepetertMelding(String passordRepetertMelding) {
		this.passordRepetertMelding = passordRepetertMelding;
	}

	public boolean isAlleGyldig() {
		return alleGyldig;
	}

	public void setAlleGyldig(boolean alleGyldig) {
		this.alleGyldig = alleGyldig;
	}

}
