package business;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgrammaEntityManagerFactory {
	
	
	private static EntityManagerFactory emf;
	
	private static Logger log = Logger.getLogger("listaClienti");
	
	public static EntityManager getEm() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("listaClienti");
		}
		log.log(Level.FINE, "richiesto nuovo entitymanager");
		return emf.createEntityManager();
	}
	
	

}
