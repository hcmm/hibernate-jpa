package br.com.k19.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.k19.vo.FuncionarioDepartamento;

public class FuncionarioDAO extends GenericDAO{
	
	public void buscarComRetornoDeDoisTipos(){
		String query = "SELECT f.nome, f.departamento.nome FROM Funcionario f";
		Query querys = getManager().createQuery(query);
		List<Object[]> lista = querys.getResultList();
		
		for (Object[] tupla : lista) {
			System.out.println("Funcionario: "+ tupla[0]);
			System.out.println("Funcionario: "+ tupla[1]);
			
		}
	}
	
	
	public void vuscarComRetornoDeDoisTipoComVO(){
		String query = "SELECT NEW resultado.FuncionarioDepartamento(f.nome, f.departamento.nome) FROM Funcionario f";
		Query querys = getManager().createQuery(query);
		
		List<FuncionarioDepartamento> resultados = querys.getResultList();
		
		for (FuncionarioDepartamento funcionarioDepartamento : resultados) {
			System.out.println(" Funcionario "+funcionarioDepartamento.getFuncrionaNome());
		}
		
	}

}
