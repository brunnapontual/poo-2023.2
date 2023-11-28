package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	FEMININO(0, "Feminino"),
	MASCULINO(1, "Masculino");
	
	private int codigo;
	private String descricao;
	
	private Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}