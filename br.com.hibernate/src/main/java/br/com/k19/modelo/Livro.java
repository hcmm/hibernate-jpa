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
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name="Liv_Aut",
		joinColumns=@JoinColumn(name="Liv_ID"),
		inverseJoinColumns=@JoinColumn(name="Aut_ID"))
	private Collection<Autor> autores;
	
	private Blob arquivo;
	
	private Double preco;

	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

<<<<<<< HEAD
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
=======
	public String getNome() {
		return this.nome;
	}
	
	
	
	
	
	
	
	
	
>>>>>>> branch 'master' of https://github.com/hcmm/hibernate-jpa.git
	

}
