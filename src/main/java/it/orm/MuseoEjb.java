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
    	m.setCitta("Milano");
    	m.setNome("Louvre");
    	em.persist(m);

    	em.flush();
    

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
    	User u = new User(); u.setNome("mauro") ;

    	Address a = new Address();  a.setName("via di foro");
    	a.setOwner(u);
    	
    	u.setAddress(a);
    	
    	DAO<Address> d = new DAO<Address>(em) {};
    	DAO<User> du = new DAO<User>(em) {};
    	d.insert(a);
    	Address a1 = new Address();  a1.setName("via Rova");
    	
    	User u1 = new User(); u.setNome("mario") ;
    	a1.setOwner(u1);
    	//d.insert(a1);
    	
    	Object fa = du.get(getClass("user"), 1);
    	
    	System.out.println("found "+fa);
    	
    }
    
    private Class getClass(String name) {
    	name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
    	Class clazz=null;
    	try {  
    		clazz = Class.forName("it.orm."+name); 
    	} catch (Exception e) {
    		
    	}
    	return clazz;
    }
    
    public MuseoEjb() {
        // TODO Auto-generated constructor stub
    }

}
