package br.com.k19.modelo;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Funcionario {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	
	
	@ElementCollection
	@CollectionTable(name="Telefones_dos_Funcionarios", joinColumns=@JoinColumn(name="func_id"))
	@Column(name="telefone")
	private Collection<String> telefones;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<String> telefones) {
		this.telefones = telefones;
	}

}
