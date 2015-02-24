package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Livro;

public class PopulaBancoLivros {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();
		
		
		manager.getTransaction().begin();
		
		Livro livro1 = new Livro();
		livro1.setNome("The Battle for Your Mind");
		livro1.setPreco(20.6);
		manager.persist(livro1);
		
		Livro livro2 = new Livro();
		livro1.setNome("Differentiate or Die");
		livro1.setPreco(20.6);
		manager.persist(livro2);
		
		Livro livro3 = new Livro();
		livro1.setNome("The Battle for Your Mind");
		livro1.setPreco(20.6);
		manager.persist(livro3);
		
		Livro livro4 = new Livro();
		livro1.setNome("Digital Fortress");
		livro1.setPreco(20.6);
		manager.persist(livro4);
		
		Livro livro5 = new Livro();
		livro1.setNome("Digital Fortress");
		livro1.setPreco(20.6);
		manager.persist(livro5);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		factory.close();
	}

}
