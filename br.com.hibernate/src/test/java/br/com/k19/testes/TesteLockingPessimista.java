package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import br.com.k19.modelo.Conta;

public class TesteLockingPessimista {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		/**
		 * Caso esteja lockado o entiny manager vai fazer a transcao aguardar
		 */
		Conta x = manager.find(Conta.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
