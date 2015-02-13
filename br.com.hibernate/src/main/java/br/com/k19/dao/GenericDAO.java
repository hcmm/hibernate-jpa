package br.com.k19.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public GenericDAO() {
		factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		manager = factory.createEntityManager();
	}

	public EntityManager getManager() {
		return manager;
	}
	
	

}
