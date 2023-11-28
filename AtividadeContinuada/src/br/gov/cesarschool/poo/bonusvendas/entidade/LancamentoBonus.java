package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDate;
import java.io.Serializable;

public class LancamentoBonus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numeroCaixaDeBonus;
	private double valor;
	private java.time.LocalDate dataHoraLancamento;
	
	public LancamentoBonus(long numeroDeCaixasDeBonus, double valor, LocalDate dataHoraLancamento) {
		super();
		this.numeroCaixaDeBonus = numeroDeCaixasDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}

	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public double getValor() {
		return valor;
	}
	
	public java.time.LocalDate getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	
	
	
}