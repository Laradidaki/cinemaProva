package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contatto;

public class aggiungiContatto {

	public static void main(String[] args) {
		
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("listaClienti");
		em = emf.createEntityManager();
		
	
	Contatto c1 = new Contatto();
	c1.setName("Dario");
	c1.setLastName("Corona");
	c1.setFiscalCode("DRNCRN70F57L500J");
	c1.setAddress("via Ludovico Einaudi 33");
	c1.setPhone("3398765411");
	
	Contatto c2 = new Contatto();
	c2.setName("Rosa");
	c2.setLastName("Lucchetta");
	c2.setFiscalCode("RSNCMN70F57L800R");
	c2.setAddress("via Don Luigi Sturzo 5");
	c2.setPhone("3403704273");
	
	Contatto c3 = new Contatto();
	c3.setName("Patrizia");
	c3.setLastName("Marcon");
	c3.setFiscalCode("PTRMCN70F57L400R");
	c3.setAddress("via Giotto 66");
	c3.setPhone("3452274813");
	
	em.getTransaction().begin();
	em.persist(c1);
	em.persist(c2);
	em.persist(c3);
	em.getTransaction().commit();
	em.close();
	 
	}

}
