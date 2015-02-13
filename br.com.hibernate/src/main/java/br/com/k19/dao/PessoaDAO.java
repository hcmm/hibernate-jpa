package br.com.k19.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.k19.modelo.Pessoa;

public class PessoaDAO extends GenericDAO{
	
	
	public void listaPessoas(){
		Query query = getManager().createNamedQuery("Pessoa.findAll");
		
		List<Pessoa> pessoas = query.getResultList();
		
	}
	
	
	public void listaPessoasPorIdade(int idade){
		Query query = getManager().createNamedQuery("Pessoa.findByIdade");
		query.setParameter(1, idade);
		List<Pessoa> pessoas = query.getResultList();
	}
	

}
