package it.orm;


import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

/**
 * Session Bean implementation class MuseoEjb
 */
@Stateful
@LocalBean
public class MuseoEjb implements MuseoEjbRemote, MuseoEjbLocal {
	@PersistenceContext(unitName =  "calcio" )
	EntityManager em;
    public void salva() {
    	//Museo m = em.find(Museo.class,1);
    	Museo m = new Museo();
    	Artista a = new Artista();
    	
    	a.setNome("Mario");
    	a.setCognome("Scussel");
    	Dipinto d = new Dipinto();
    	d.setNome("Primavera");
    	d.setMuseo(m);
    	
    	a.getDipinti().add(new Dipinto());
    	m.setCitta("firenze----");
    	
    	m.setNome("uffizi");
    	d.setMuseo(m);
    	d.getArtisti().add(a);
    	
    	Direttore dir = new Direttore();
    	dir.setNome("Mauro");
    	dir.setCognome("Larese");
    	dir.setMuseo(m);
    	em.persist(d);
    	em.persist(dir);
    	em.persist(a);
    	em.flush();
    	//m.setCitta("Milano");
    	System.out.println(m.getCitta());
    			
    }
   
    public void reload() {
    	System.out.println("reloading team");
    	Squadra s1 = em.find(Squadra.class, 1);
    	if(	s1 != null )s1.printGiocatori();
    }
    public void aggiorna() {
    	
    	CriteriaBuilder b = em.getCriteriaBuilder();
    	CriteriaQuery<User> q = b.createQuery(User.class);
    	
   
    	
    	System.out.println("aggiorno con user");
    	User u = new User();
    	u.setNome("mauro") ;

    	Address a = new Address(); 
    	a.setName("via di foro");
    	a.setOwner(u);
    	
    	u.setAddress(a);
    	
    	em.persist(u);
    	em.flush();
    	
    	
    	
    }
    
    public MuseoEjb() {
        // TODO Auto-generated constructor stub
    }

}
