package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

public class CaixaDeBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class);
	
	public CaixaDeBonus buscar(long numero) {
		return (CaixaDeBonus)cadastro.buscar(BRANCO + numero);
	}
	
	public boolean incluir(CaixaDeBonus caixaDeBonus) {
		CaixaDeBonus caixaDeBonusBusca = buscar(caixaDeBonus.getNumero());
		if (caixaDeBonusBusca != null) { 
			return false;
		} else {
			cadastro.incluir(caixaDeBonus, BRANCO + caixaDeBonus.getNumero());
			return true;
		}		 
	}
	
	public boolean excluir(CaixaDeBonus caixaDeBonus) {
		CaixaDeBonus caixaDeBonusBusca = buscar(caixaDeBonus.getNumero());
		if (caixaDeBonusBusca == null) { 
			return false;
		} else {
			cadastro.excluir(BRANCO + caixaDeBonus.getNumero());
			return true;
		}		 
	}
	
	public boolean alterar(CaixaDeBonus caixaDeBonus) {
		CaixaDeBonus caixaDeBonusBusca = buscar(caixaDeBonus.getNumero());
		if (caixaDeBonusBusca == null) {
			return false;
		} else {
			cadastro.alterar(caixaDeBonus, BRANCO + caixaDeBonus.getNumero());
			return true;
		}		
	}
	
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(CaixaDeBonus.class);
		CaixaDeBonus[] caixasDeBonus = new CaixaDeBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			caixasDeBonus[i] = (CaixaDeBonus)rets[i];
		}
		return caixasDeBonus;
	} 
}