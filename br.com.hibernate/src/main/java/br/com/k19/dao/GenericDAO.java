package br.com.k19.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class GenericDAO {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	private CriteriaBuilder managerCriteria;
	
	public GenericDAO() {
		factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		manager = factory.createEntityManager();
		managerCriteria = manager.getCriteriaBuilder();
	}

	public EntityManager getManager() {
		return manager;
	}

	public CriteriaBuilder getManagerCriteria() {
		return managerCriteria;
	}

}
