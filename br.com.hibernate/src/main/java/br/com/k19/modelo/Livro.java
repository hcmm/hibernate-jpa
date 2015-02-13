package br.com.k19.modelo;

import java.sql.Blob;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	@JoinTable(name="Liv_Aut",
		joinColumns=@JoinColumn(name="Liv_ID"),
		inverseJoinColumns=@JoinColumn(name="Aut_ID"))
	private Collection<Autor> autores;
	
	private Blob arquivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Autor> getAutores() {
		return autores;
	}
	
	@Basic(fetch=FetchType.LAZY)
	public Blob getArquivo() {
		return arquivo;
	}

	public void setArquivo(Blob arquivo) {
		this.arquivo = arquivo;
	}

	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}
	
	
	
	
	
	
	
	
	
	

}
