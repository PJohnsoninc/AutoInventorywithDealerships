package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AutoBrands;
import model.AutoList;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
public class AutoListHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AutoInventorywithDealerships"); 
	
	public void insertAuto(AutoList auto) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(auto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteAuto(AutoList auto) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AutoList> typedQuery = em.createQuery("select a from AutoList a where a.id = :selectedId", AutoList.class);
		typedQuery.setParameter("selectedId", auto.getId());
		typedQuery.setMaxResults(1);
		AutoList result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AutoList> showAll(){
		EntityManager em = emfactory.createEntityManager();
		List<AutoList> allVehicles = em.createQuery("SELECT a FROM AutoList a").getResultList();
		return allVehicles;
	}
	
	public List<AutoList> searchByMake(String make){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AutoList> typedQuery = em.createQuery("select m from AutoList m where m.make = :selectedMake", AutoList.class); 
		typedQuery.setParameter("selectedMake", make);
		List<AutoList> foundMake = typedQuery.getResultList();
		return foundMake;
	}
	
	public List<AutoList> searchByModel(String model){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AutoList> typedQuery = em.createQuery("select m from AutoList m where m.model = :selectedModel", AutoList.class); 
		typedQuery.setParameter("selectedModel", model);
		List<AutoList> foundModel = typedQuery.getResultList();
		return foundModel;
	}
	
	public List<AutoList> searchByYear(String year){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AutoList> typedQuery = em.createQuery("select y from AutoList y where y.year = :selectedYear", AutoList.class); 
		typedQuery.setParameter("selectedYear", year);
		List<AutoList> foundYear = typedQuery.getResultList();
		return foundYear;
	}
	
	public AutoList searchById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AutoList found = em.find(AutoList.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateAuto(AutoList idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(idToEdit);
		em.getTransaction().commit();
		em.close();
	}

}
