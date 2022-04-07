package entity;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import backend.DiceShaker;
import password.Passord;

@Entity
@Table(name = "spiller", schema = "yatzy")
public class Spiller implements Comparable<Spiller> {

	@Id
	private String brukernavn;
	@Override
	public String toString() {
		return "Spiller [brukernavn=" + brukernavn + ", navn=" + navn + ", epost=" + epost + "]";
	}

	private String navn;
	private String epost;
	@Embedded
	private Passord passordhash;
	
	@ManyToMany(mappedBy = "spillere")
	private Set<Yatzy> yatzy;

	public Spiller() {

	}

	public Spiller(String brukernavn, String navn, String epost, Passord passordhash) {
		this.brukernavn = brukernavn;
		this.navn = navn;
		this.epost = epost;
		this.passordhash = passordhash;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public String getNavn() {
		return navn;
	}

	public String getEpost() {
		return epost;
	}

	public Passord getPassord() {
		return passordhash;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public void setPassord(Passord passordhash) {
		this.passordhash = passordhash;
	}

	public void spill(DiceShaker kopp) {
		kopp.shakeDice();
	}

	public void behold(DiceShaker kopp, int[] terninger) {
		kopp.lockDice(terninger);
	}

	public void reset(DiceShaker kopp) {
		kopp.reset();
	}

	@Override
	public boolean equals(Object obj) {
		Spiller other = (Spiller) obj;
		return this.getBrukernavn().equals(other.getBrukernavn());
	}

	@Override
	public int compareTo(Spiller that) {
		return this.getBrukernavn().compareTo(that.getBrukernavn());
	}


}
