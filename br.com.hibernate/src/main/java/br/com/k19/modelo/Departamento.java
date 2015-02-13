package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToMany  //tabela join tera esse nome
	@JoinTable(name="DEP_FUNC",
		joinColumns=@JoinColumn(name="DEP_ID"),
		inverseJoinColumns=@JoinColumn(name="FUNC_ID"))
	private Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();

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

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	
	
	

}
