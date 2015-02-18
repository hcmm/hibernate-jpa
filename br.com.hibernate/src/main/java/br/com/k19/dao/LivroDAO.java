package br.com.k19.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Livro;

public class LivroDAO extends GenericDAO{
	
	
	/**
	 * Selecionao os livros mais caros;
	 */
	
	public void livroMaisCaro(){
		String sql = "SELECT livro from Livro livro WHERE livro.preco >= ALL(SELECT livro.preco FROM Livro livro)";
	}
	
	public void livrosQuePossuemTitulosEmComum(){
		String sql = "SELECT livro FROM Livro livro WHERE livro.titulo = ANY(SELECT livro2.titulo FROM Livro livro2 WHEER livro <> livro2";
	}
	
	
	@SuppressWarnings("unchecked")
	public void nativeQuery(){
		String sql = "SELECT * from Livro";
		TypedQuery<Livro> nativeQuery = (TypedQuery<Livro>) getManager().createNativeQuery(sql, Livro.class);
		List<Livro> livros = nativeQuery.getResultList();
		
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}
	}
	
	
	public void testeConsultaCriteria(){
		CriteriaQuery<Livro> c = getManagerCriteria().createQuery(Livro.class);
		Root<Livro> l = c.from(Livro.class);
		c.select(l);
	}
	public void testeConsultaCriteria2(){
		CriteriaQuery<String> c = getManagerCriteria().createQuery(String.class);
		Root<Livro> l = c.from(Livro.class);
		c.select(l.<String>get("nome"));
	}
	//avg
	public void testeConsultaCriteria3(){
		CriteriaQuery<Double> c = getManagerCriteria().createQuery(Double.class);
		Root<Livro> l = c.from(Livro.class);
		c.select(getManagerCriteria().avg(l.<Double>get("nome")));
	}
	
	
	//Multiplos atributos
	public void testeConsultaCriteria4(){
		CriteriaQuery<Object[]> c = getManagerCriteria().createQuery(Object[].class);
		Root<Livro> l = c.from(Livro.class);
		c.multiselect(l.<String>get("nome"), l.<Double>get("preco"));
		
		TypedQuery<Object[]> query = getManager().createQuery(c);
		List<Object[]> resultado = query.getResultList();
		
		for (Object[] registro : resultado) {
			System.out.println(registro[0]);
		}
	}
	
	//Multiplos atributos com Tuple para nao trabalhar com arrays
	public void testeConsultaCriteria5(){
		CriteriaQuery<Tuple> c = getManagerCriteria().createQuery(Tuple.class);
		Root<Livro> l = c.from(Livro.class);
		c.multiselect(l.<String>get("nome").alias("livro.nome"), l.<Double>get("preco").alias("livro.preco"));
		
		TypedQuery<Tuple> query = getManager().createQuery(c);
		List<Tuple> resultado = query.getResultList();
		
		for (Tuple registro : resultado) {
			System.out.println(registro.get("livro.nome"));
		}
	}
	
	//predicados - usados para filtrar consultas
	public void testeConsultaCriteria6(){
		CriteriaQuery<Livro> c = getManagerCriteria().createQuery(Livro.class);
		Root<Livro> l = c.from(Livro.class);
		c.select(l);
		
		//Predicate predicate = getManagerCriteria().equal(l.get("nome"), "Star Wars");
		Predicate predicate = getManagerCriteria(). and(
				getManagerCriteria().equal(l.get("nome"), "Star Wars"),
				getManagerCriteria().equal(l.get("preco"), 1500.)
				);
		c.where(predicate);
		
		TypedQuery<Livro> query = getManager().createQuery(c);
		List<Livro> livros = query.getResultList();
		
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}
	}
	
	//ordenacao
	public void testeConsultaCriteria7(){
		CriteriaQuery<Livro> c = getManagerCriteria().createQuery(Livro.class);
		Root<Livro> l = c.from(Livro.class);
		c.select(l);
		
		c.orderBy(getManagerCriteria().desc(l.<Double>get("preco")));
	}
}
