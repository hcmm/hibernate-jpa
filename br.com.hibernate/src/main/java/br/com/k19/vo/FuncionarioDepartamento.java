package br.com.k19.vo;

public class FuncionarioDepartamento {

	private String funcrionaNome;
	private String departamentoNome;
	
	public FuncionarioDepartamento(String funcrionaNome, String departamentoNome) {
		this.funcrionaNome = funcrionaNome;
		this.departamentoNome = departamentoNome;
	}

	public String getFuncrionaNome() {
		return funcrionaNome;
	}

	public void setFuncrionaNome(String funcrionaNome) {
		this.funcrionaNome = funcrionaNome;
	}

	public String getDepartamentoNome() {
		return departamentoNome;
	}

	public void setDepartamentoNome(String departamentoNome) {
		this.departamentoNome = departamentoNome;
	}
	
}
