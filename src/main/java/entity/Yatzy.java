package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "yatzy", schema = "yatzy")
public class Yatzy {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer antall;
	private String brett;
	
	
	public Yatzy() {
		super();
	}
	
	@ManyToMany
	@JoinTable(
			name = "spilldeltagelse",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "brukernavn"))
	private List<Spiller> spillere = new ArrayList<Spiller>();
	

	
	@Override
	public String toString() {
		return "Yatzy [id=" + id + ", antall=" + antall + ", brett=" + brett + ", spillere=" + spillere + "]";
	}


	public String getBrett() {
		return brett;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAntall() {
		return antall;
	}

	public void setAntall(Integer antall) {
		this.antall = antall;
	}

	public List<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(List<Spiller> spillere) {
		this.spillere = spillere;
	}
	
	public void leggTilSpiller(Spiller spiller) {
		this.spillere.add(spiller);
	}

	public void setBrett(String brett) {
		this.brett = brett;
	}
	
}
