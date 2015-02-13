package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteFindEager {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		
		System.out.println("---------------- Chamando FIND -----------------");
		Pessoa pessoa2 = manager.find(Pessoa.class, 1L);
		
		manager.close();
		factory.close();
		
		System.out.println("---------------- Fez o SELECT -----------------");
		System.out.println("Nome: "+pessoa2.getNome());
		
		
	}

}
