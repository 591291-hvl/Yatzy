<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="no">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="icon" href="data:," />
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script src="js/FORMController.js" defer></script>
    <title>Registrering</title>
  </head>
  <body>
    <h2>Registrering</h2>    

      <form method="post" id="skjema">
        <fieldset>
          <label for="brukernavn">Brukernavn:</label>
          <input type="text" name="brukernavn" id="brukernavn" value="${spillerrForm.brukernavn}"
               placeholder="Fyll inn brukernavn"
               title="Brukernavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
               required pattern="\s*\p{Lu}\p{Ll}+(\s+\p{Lu}\p{Ll}+)*\s*"
           />
          <span class="melding">${spillerForm.brukernavnMelding}</span>

          <label for="navn">Navn:</label>
          <input type="text" name="navn" id="navn" value="${spillerForm.navn}"
               placeholder="Fyll inn navn"
               title="Navn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 50."
              required pattern="\s*\p{Lu}\p{Ll}+\s*"
           />
          <span class="melding">${spillerForm.navnMelding}</span>

          <label for="epost">Epost:</label>
          <input type="text" name="epost" id="epost" value="${spillerForm.epost}"
              placeholder="Fyll inn epost"
              title="Epost må bestå av minst 8 siffre."
              required pattern=".{8,}"
           />
          <span class="melding">${spillerForm.epostMelding}</span>

          <label for="passord">Passord:</label>
          <input type="password" name="passord" id="passord" value="${spillerForm.passord}"
              placeholder="Velg et passord"
              title="Passordet må bestå av minst 8 tegn, men bør ha minst 14 tegn."
              required pattern=".{8,}"
           />
         <span class="melding">${spillerForm.passordMelding}</span>

          <label for="passordRepetert">Passord repetert:</label>
          <input type="password" name="passordRepetert" id="passordRepetert" value="${spillerForm.passordRepetert}"
              placeholder="Gjenta passord"
              required  />
          <span class="melding">${spillerForm.passordRepetertMelding}</span>

          <button type="submit">Registrer</button>
        </fieldset>
      </form>
      
      	<h2>
		Har du allerede bruker? <a href="LoggInnServlet">Logg Inn</a>
	</h2>

  </body>
</html>