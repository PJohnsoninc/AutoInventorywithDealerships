package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AutoBrands;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
public class AutoBrandsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AutoInventorywithDealerships");

	public void insertBrand(AutoBrands brand) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(brand);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteBrand(AutoBrands brand) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AutoBrands> typedQuery = em.createQuery("select b from AutoBrands b where b.id = :selectedBrand", AutoBrands.class);
		typedQuery.setParameter("selectedBrand", brand.getId());
		typedQuery.setMaxResults(1);
		AutoBrands result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AutoBrands> showAll(){
		EntityManager em = emfactory.createEntityManager();
		List<AutoBrands> allBrands = em.createQuery("SELECT b FROM AutoBrands b").getResultList();
		return allBrands;
	}
	
	public AutoBrands searchById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AutoBrands found = em.find(AutoBrands.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateBrand(AutoBrands idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(idToEdit);
		em.getTransaction().commit();
		em.close();
	}
}
