package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.SpillerEntity;
import entity.YatzyEntity;

@Stateless
public class YatzyDAO {

	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public List<YatzyEntity> finnAlleSpill() {
		return em.createQuery("SELECT y FROM yatzy y ORDER BY y.id ASC", YatzyEntity.class).getResultList();
	}
	

	
	public void leggTilSpiller(YatzyEntity yatzy, SpillerEntity spiller) {
        yatzy.leggTilSpiller(spiller);
        em.merge(yatzy);
    }

	public void lagNyttSpill(YatzyEntity yatzy) {
		System.out.println("===========================");
		em.persist(yatzy);
	}
	
	public void update(YatzyEntity yatzy) {
		em.merge(yatzy);
	}
	
	public YatzyEntity finnSpillID(Integer spillID) {
		return em.find(YatzyEntity.class, spillID);
	}
	
	public boolean spillFinnes(Integer spillID) {
		return finnSpillID(spillID) != null;
	}
	
	public Integer finnSpillerTur(Integer spillID) {
		return finnSpillID(spillID).getPlayerTurn();
	}

}
