package it.orm;

import jakarta.persistence.EntityManager;

public class MuseoDao {
	private EntityManager em;
	public MuseoDao(EntityManager em) {
		
	}
	
	public void add(Museo m) {
		em.persist(m);
	}

}
