package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Produto;

public class AdicionaProduto {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		Produto produto = new Produto();
		produto.setNome("K19 - Caneta");
		produto.setPreco(4.56);
		
		manager.getTransaction().begin();
		
		manager.persist(produto);
		
		manager.getTransaction().commit();
		
		factory.close();
	
	}

}
