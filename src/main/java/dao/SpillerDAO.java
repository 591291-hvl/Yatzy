package dao;

import entity.Spiller;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SpillerDAO {
	
	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public Spiller finnMedBrukernavn(String brukernavn) {
		return em.find(Spiller.class, brukernavn);
	}
	
	public boolean erRegistrert(String brukernavn) {
		return finnMedBrukernavn(brukernavn) != null;
	}

	public List<Spiller> finnAlleEtterBrukernavn(){
		return em.createQuery("SELECT d FROM Spiller d", Spiller.class).getResultList();
	}
	
	
	public void update(Spiller spiller) {
		em.merge(spiller);
	}

	public void lagre(Spiller spiller) {
		em.persist(spiller);
	}
	
	public void slett(Spiller spiller) {
		em.remove(spiller);
	}
	
	
}
