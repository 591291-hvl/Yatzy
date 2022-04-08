package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Spiller;
import entity.Yatzy;

public class YatzyDAO {

	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public List<Yatzy> finnAlleSpill() {
		return em.createQuery("SELECT y FROM yatzy y ORDER BY y.id ASC", Yatzy.class).getResultList();
	}
	
	public void lagNyttSpill(Yatzy yatzy) {
		
		em.persist(yatzy);
	}

}
