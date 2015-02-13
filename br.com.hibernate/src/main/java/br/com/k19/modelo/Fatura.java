package br.com.k19.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fatura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private BigDecimal valor;
	
	@OneToMany(mappedBy="fatura")
	private Collection<Ligacao> ligacoes = new ArrayList<Ligacao>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Collection<Ligacao> getLigacoes() {
		return ligacoes;
	}
	public void setLigacoes(Collection<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}
	

}
