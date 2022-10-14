package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dealership;

/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */

public class DealershipHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AutoInventorywithDealerships");
	
	public void insertDealership(Dealership d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteDealership(Dealership name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dealership> typedQuery = em.createQuery("select b from Dealership b where b.id = :selectedDealership", Dealership.class);
		typedQuery.setParameter("selectedDealership", name.getId());
		typedQuery.setMaxResults(1);
		Dealership result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Dealership> showDealerships(){
		EntityManager em = emfactory.createEntityManager();
		List<Dealership> allDealerships = em.createQuery("SELECT b FROM Dealership b").getResultList();
		return allDealerships;
	}
	
	public Dealership searchById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Dealership found = em.find(Dealership.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateDealership(Dealership idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(idToEdit);
		em.getTransaction().commit();
		em.close();
	}

}
