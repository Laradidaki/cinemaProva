package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import business.ProgrammaEntityManagerFactory;

import model.Contatto;

public class ContattoManager {

	
	private static Logger log = Logger.getLogger("listaClienti-business");
	
	public void riempiRubrica() {
		System.out.println("ciao"); }

	public static void aggiugiContatto(Contatto c) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Contatto cDb = null;
		if (c.getFiscalCode() != null) {
			cDb = em.find(Contatto.class, c.getFiscalCode());
		}
		if (cDb == null) {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto contatto");
		} else {
			log.log(Level.WARNING, "contatto esiste già");
		}
	}

	public static List<Contatto> elencoContatti() {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		return em.createQuery("select c from Contatto c", Contatto.class).getResultList();
	}

	public static void eliminaContatto(Integer idDaEliminare) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Contatto con = em.find(Contatto.class, idDaEliminare);
		if (con != null) {
				em.getTransaction().begin();
				em.remove(con);
				em.getTransaction().commit();
			}
		}
	

	public static Contatto perId(Integer parameter) {
		if (parameter != null) {
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			return em.find(Contatto.class, parameter);
		}
		return null;
	} 
}
