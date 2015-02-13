package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;

public class AdicionaEstadoGovernador {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
//		
//		Governador governador = new Governador();
//		governador.setNome("Pesao");
//		
//		Estado estado = new Estado();
//		estado.setNome("Rio de Janeiro");
//		estado.setGovernador(governador);
//		
//		manager.persist(governador);
//		manager.persist(estado);
		
//		manager.getTransaction().commit();
		
		Estado estado = manager.find(Estado.class, 1L);
		
		System.out.println("nome: "+estado.getGovernador().getNome());
		
		manager.close();
		factory.close();
		
		
		
	}

}
