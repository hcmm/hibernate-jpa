package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity
//@EntityListeners(K19Listener.class)
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private Double preco;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@PrePersist
	public void prePersist(){
		System.out.println("Persistido um novo objeto ocm persit() ou merge() ...");
	}
	
	@PostPersist
	public void postPersist(){
		System.out.println("Um comando insert foi executado no banco de dados ...");
		System.out.println("Um rollback ainda pode desfazer o comando insert ...");
	}
	
	@PreRemove
	public void preRemove(){
		System.out.println("Removendo um objeto gerenciado com remove()...");
	}
	
	@PostRemove
	public void postRemove(){
		System.out.println("O camando delete foi executado no banco de dados...");
		System.out.println("Um roolback ainda pode desfazer o comando delete...");
	}
	
	@PreUpdate
	public void preUpdate(){
		System.out.println("O ccomando update executara no banco de dados...");
	}
	
	@PostUpdate
	public void postUpdate(){
		System.out.println("O comando update foi executado no banco de dados...");
		System.out.println("Um roolback ainda podera desfazer o comando update");
	}
	
	@PostLoad
	public void postLoad(){
		System.out.println("Um objeto foi carregado com os dados do Banco de dados.");
	}
	
}
