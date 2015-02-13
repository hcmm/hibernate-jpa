package br.com.k19.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //Heranca, probelma que se criar uma unica tabela e que para determinados registros nao sterao colunas utilzadas
//@Inheritance(strategy=InheritanceType.JOINED) //AS subclasses terao suas proprias tabelas com seus atribuitos e a a fk da superclasse
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // as tabelas filhas terao o registro da tabela pai, mas sem nenhum fk
@NamedQueries({
	@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p"),
	@NamedQuery(name="Pessoa.count", query="SELECT COUNT(p) FROM Pessoa p"),
	@NamedQuery(name="Pessoa.findById", query="SELECT p FROM Pessoa p WHERE p.id = :id"),
	@NamedQuery(name="Pessoa.findByIdade", query="SELECT P FROM Pessoa p WHERE p.idade > ?1")
})
public class Pessoa {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(length=30, nullable=false, unique=true)
	private String nome;
	
	@Column(precision=3, scale=2)
	private BigDecimal altura;
	
	@Lob
	private byte[] avatar;
	
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
//	@Embedded
	private Endereco endereco;
	
	//@Transient
	private int idade;

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

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	

}
