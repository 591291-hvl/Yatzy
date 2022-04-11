package dao;

import entity.SpillerEntity;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SpillerDAO {
	
	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public SpillerEntity finnMedBrukernavn(String brukernavn) {
		return em.find(SpillerEntity.class, brukernavn);
	}
	
	public boolean erRegistrert(String brukernavn) {
		return finnMedBrukernavn(brukernavn) != null;
	}

	public List<SpillerEntity> finnAlleEtterBrukernavn(){
		return em.createQuery("SELECT d FROM Spiller d", SpillerEntity.class).getResultList();
	}
	
	
	public void update(SpillerEntity spiller) {
		em.merge(spiller);
	}

	public void lagre(SpillerEntity spiller) {
		em.persist(spiller);
	}
	
	public void slett(SpillerEntity spiller) {
		em.remove(spiller);
	}
	
	
}
