package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;


public abstract class LancamentoBonus {
	private int valor;
	private long numeroCaixaDeBonus;
	private LocalDateTime dataHoraLancamento = LocalDateTime.now();
	
	
	public LancamentoBonus(long numeroCaixaDeBonus, int valor, LocalDateTime dataHoraLancamento) {
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}

	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	public int getvalor() {
		return valor;
	}
	
	public long getnumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}
}