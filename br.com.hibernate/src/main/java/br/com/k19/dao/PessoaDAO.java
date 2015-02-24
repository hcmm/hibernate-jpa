package br.com.k19.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	
	public Long comMaisde18Anos(){
		TypedQuery<Long> query = getManager().createQuery("select COUNT(p) FROM Pessoa p where p.idade >= 18", Long.class);
		Long numeroPessoas = query.getSingleResult();
		return numeroPessoas;
	}
	
	
	public Long maiorIdade(){
		TypedQuery<Long> query = getManager().createQuery("select MAX(p.idade) FROM Pessoa p where p.idade >= 18", Long.class);
		Long idadePessoas = query.getSingleResult();
		return idadePessoas;
	}
	

}
