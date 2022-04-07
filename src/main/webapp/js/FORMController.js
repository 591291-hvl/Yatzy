/**
 * 
 */

class FORMController {

	constructor(root) {
		this.root = root;
		this.run = this.run.bind(this);
	}


	sjekkPassordStyrke(event) {

		// Skjekker bare styrken når passordet er valid
		if (event.target.validity.valid) {
			
			const passord = document.getElementById('passord');

			// Skjekker om passordet er sterkt
			if (passord.value.length <= 14) {
				passord.classList.add('mediumPassword');
			}
		}
	}

	skjekkPasordMatcher(event) {
		const passord = document.getElementById('passord');
		const passordRepetert = document.getElementById('passordRepetert');
		
		if (PassordValidator.valider(passord, passordRepetert)) {
			event.target.setCustomValidity("");
		} else {
			event.target.setCustomValidity("Repetert passord er feil!");
		}

	}

	run() {
		const passord = document.getElementById('passord');
		const passordRepetert = document.getElementById('passordRepetert');
		
		passord.addEventListener("input", sjekkPassordStyrke);
		passordRepetert.addEventListener("input", skjekkPasordMatcher);
	}
}

class PassordValidator {

	static valider(pass, passRep) {
		if (pass.value === passRep.value) {
			return true;
		} else {
			return false;
		}
	}
}

const controller = new FORMController("root");
document.addEventListener("DOMContentLoaded", controller.run);