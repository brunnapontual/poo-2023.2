package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import java.time.LocalDate;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);
	
	public LancamentoBonus buscar(long numeroCaixaDeBonus, LocalDate dataHoraLancamento ) {
		return (LancamentoBonus)cadastro.buscar(BRANCO + numeroCaixaDeBonus + dataHoraLancamento);
	}
	
	public boolean incluir(LancamentoBonus lancamentoBonus) {
		LancamentoBonus lancamentoBonusBusca = buscar(lancamentoBonus.getNumeroCaixaDeBonus(),lancamentoBonus.getDataHoraLancamento());
		if (lancamentoBonusBusca != null) { 
			return false;
		} else {
			cadastro.incluir(lancamentoBonus, BRANCO + lancamentoBonus.getNumeroCaixaDeBonus() + lancamentoBonus.getDataHoraLancamento());
			return true;
		}		 
	}
	
	public boolean excluir(LancamentoBonus lancamentoBonus) {
		LancamentoBonus lancamentoBonusBusca = buscar(lancamentoBonus.getNumeroCaixaDeBonus(),lancamentoBonus.getDataHoraLancamento());
		if (lancamentoBonusBusca == null) { 
			return false;
		} else {
			cadastro.excluir(BRANCO + lancamentoBonus.getNumeroCaixaDeBonus() + lancamentoBonus.getDataHoraLancamento());
			return true;
		}		 
	}
	
	
	public boolean alterar(LancamentoBonus lancamentoBonus) {
		LancamentoBonus lancamentoBonusBusca = buscar(lancamentoBonus.getNumeroCaixaDeBonus(),lancamentoBonus.getDataHoraLancamento());
		if (lancamentoBonusBusca == null) {
			return false;
		} else {
			cadastro.alterar(lancamentoBonus, BRANCO + lancamentoBonus.getNumeroCaixaDeBonus() + lancamentoBonus.getDataHoraLancamento());
			return true;
		}		
	}
	
	public LancamentoBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(LancamentoBonus.class);
		LancamentoBonus[] lancamentosBonus = new LancamentoBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			lancamentosBonus[i] = (LancamentoBonus)rets[i];
		}
		return lancamentosBonus;
	} 
}