package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

public class TesteCascade {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();

		Governador governador = new Governador();
		governador.setNome("Pesao");

		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");

		
		governador.setEstado(estado);
		estado.setGovernador(governador);
		
		
		manager.getTransaction().begin();
		manager.persist(estado);
		manager.getTransaction().commit();

		System.out.println("nome: " + estado.getGovernador().getNome());

		manager.close();
		factory.close();

	}

}
