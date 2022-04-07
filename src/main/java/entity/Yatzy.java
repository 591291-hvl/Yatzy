package entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "yatzy", schema = "yatzy")
public class Yatzy {
	
	@Id
	private String id;
	private Integer antall;
	private int[][] brett;
	
	@ManyToMany
	@JoinTable(
			name = "spilldeltagelse",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "brukernavn"))
	private Set<Spiller> spillere;
	
	public Yatzy() {
		
	}


	public int[][] getBrett() {
		return brett;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAntall() {
		return antall;
	}

	public void setAntall(Integer antall) {
		this.antall = antall;
	}

	public Set<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(Set<Spiller> spillere) {
		this.spillere = spillere;
	}

	public void setBrett(int[][] brett) {
		this.brett = brett;
	}
	
}
