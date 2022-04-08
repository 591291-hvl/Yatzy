package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Yatzy;

@Stateless
public class YatzyDAO {

	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public List<Yatzy> finnAlleSpill() {
		return em.createQuery("SELECT y FROM yatzy y ORDER BY y.id ASC", Yatzy.class).getResultList();
	}

	public void lagNyttSpill(Yatzy yatzy) {
		System.out.println("===========================");
		em.persist(yatzy);
	}
	
	public Yatzy finnSpillID(Integer spillID) {
		return em.find(Yatzy.class, spillID);
	}
	
	public boolean spillFinnes(Integer spillID) {
		return finnSpillID(spillID) != null;
	}

}
