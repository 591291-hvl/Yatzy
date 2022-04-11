package entity;

import java.util.ArrayList;
import java.util.List;
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
public class SpillerEntity implements Comparable<SpillerEntity> {

	@Id
	private String brukernavn;
	private String navn;
	private String epost;
	@Embedded
	private Passord passordhash;

	@ManyToMany(mappedBy = "spillere")
	private List<YatzyEntity> yatzy = new ArrayList<>();

	public SpillerEntity() {
		super();
	}

	public SpillerEntity(String brukernavn, String navn, String epost, Passord passordhash) {
		this.brukernavn = brukernavn;
		this.navn = navn;
		this.epost = epost;
		this.passordhash = passordhash;
	}

	@Override
	public String toString() {
		return "Spiller [brukernavn=" + brukernavn + ", navn=" + navn + ", epost=" + epost + ", passordhash="
				+ passordhash + "]";
	}

	public void bliMedIYatzy(YatzyEntity yatzy) {
		this.yatzy.add(yatzy);
		yatzy.getSpillere().add(this);
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
		SpillerEntity other = (SpillerEntity) obj;
		return this.getBrukernavn().equals(other.getBrukernavn());
	}

	@Override
	public int compareTo(SpillerEntity that) {
		return this.getBrukernavn().compareTo(that.getBrukernavn());
	}

	public List<YatzyEntity> getYatzy() {
		return yatzy;
	}

}
