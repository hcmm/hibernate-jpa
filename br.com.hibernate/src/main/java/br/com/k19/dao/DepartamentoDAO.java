package br.com.k19.dao;

import javax.persistence.Query;

public class DepartamentoDAO extends GenericDAO{

	/**
	 * Resolvendo problema do lazy n + 1, com o lazy quando se quer o funcionario,
	 * faz uma consulta para cada departmaneto encontrado, dessa forma vc trara os funcionarios nos objetos
	 * do departamento em um unica consulta
	 */
	public void getDepartamentoFuncionario(){
		String sql = "SELECT DISTINCT(d) FROM Departamento d LEFT JOIN FETCH d.funcionarios";
	}
	
	
	/**
	 * Utilizado quando nao se quer transferir dados do banco para a memoria da aplicacao
	 */
	public void operacaoEMLote(){
		Query sql = getManager().createQuery("UPDATE Deparamento d set d.preco = d.preco * 1.1");
		sql.executeUpdate();
	}
	
	
	
}
