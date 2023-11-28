package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.io.Serializable;

public class CaixaDeBonus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numero;
	private double saldo;
	private java.time.LocalDateTime dataHoraAtualizacao;
	
	public CaixaDeBonus(long numero) {
		this.numero = numero;
		this.dataHoraAtualizacao = LocalDateTime.now();
	}
	
	public long getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public java.time.LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	
	public void creditar(double valor) {
		saldo += valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}
	
	public void debitar(double valor) {
		saldo -= valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}

}