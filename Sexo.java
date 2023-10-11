package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	FEMININO(1, "Feminino"),
	MASCULINO(2, "Masculino");
	
	private String descricao;
	private int codigo;
	
	private Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public int getCodigo() {
		return codigo;
	}	
}
//public static Sexo fromCodigo(int codigo) {
//for (Sexo sexo : values()) {
 //   if (sexo.getCodigo() == codigo) {
   //     return sexo;
   // }
//}
//return null;
//}

//}