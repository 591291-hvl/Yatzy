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
	private Integer aktiv;
	private String brett;

	
	@ManyToMany
	@JoinTable(
			name = "yatzy.spilldeltagelse",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "brukernavn"))
	private List<Spiller> spillere = new ArrayList<Spiller>();
	
	public Yatzy() {
		super();
	}
	
	public void opprettSpill() {
		antall = 0;
		aktiv = 0;
		brett = "";
	}
	
	public void startSpill() {
		aktiv = 1;
		createBrett(antall);
	}
	
	public void leggTilSpiller(Spiller spiller) {
        spillere.add(spiller);
        antall++;
        spiller.getYatzy().add(this);
    }
	
	@Override
	public String toString() {
		return "Yatzy [id=" + id + ", antall=" + antall + "aktiv=" + aktiv + ", brett=" + brett + "]";
	}
	
	public void createBrett(int antallSpillere) {
		String brettString = "";
		
		//Result should be:
		// brett = "playerVal1,playerVal2,playerVal3-playerVal1,playerVal2,playerVal3
		//unfolded to:
		//int[][] = 
		//{{playerVal1,playerVal2,PlayerVal3},{playerVal1,playerVal2,PlayerVal3}};
		//Matrix dimensions are int[18][number of players]
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < antallSpillere; j++){
				brettString += "0,";
			}
			brettString += "-";
			
		}
		this.brett = brettString;
	}
	
	public int[][] toArray(String brett, int antallSpillere){
		int[][] brettArray = new int[18][antallSpillere]; 
		
		//size = 18;
		String[] rundeRow = brett.split("-");
		String[][] brettString = new String[rundeRow.length][antallSpillere]; 
		for(int i = 0; i < rundeRow.length; i++) {
			brettString[i] = rundeRow[i].split(",");
		}
		
		for(int i = 0; i < brettString.length; i++){
			for(int j = 0; j < brettString[i].length; j++) {
				brettArray[i][j] = Integer.parseInt(brettString[i][j]);
			}
		}
		
		return brettArray;
	}
	
	public String toArrayString(int[][] brett) {
		String brettString = "";
		
		for(int i = 0; i < brett.length; i++) {
			for(int j = 0; j < brett[i].length; j++) {
				brettString += brett[i][j] + "";
				if(j != brett[i].length-1) {
					brettString += ",";
				}
			}
			if(i != brett.length -1) {
				brettString += "-";
			}
			
		}
		
		return brettString;
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
	


	public void setBrett(String brett) {
		this.brett = brett;
	}

	public Integer getAktiv() {
		return aktiv;
	}

	public void setAktiv(Integer aktiv) {
		this.aktiv = aktiv;
	}
	
}
