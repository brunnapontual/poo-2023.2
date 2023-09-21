/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

/**
 *
 * @author bspanudakis
 */
public class Endereco {

    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public static String getLogradouro() {
        return this.logradouro;
    }
    public static void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
