package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDate;
import java.time.Period;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

public class Vendedor {

    private String cpf;
    private String nomeCompleto;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private double renda;
    private Endereco endereco;

    public Vendedor(String cpf, String nomeCompleto, Sexo sexo, LocalDate dataNascimento, double renda, Endereco endereco) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public double getRenda() {
        return renda;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setRenda(double renda) {
        this.renda = renda;
        
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, dataAtual);
        return periodo.getYears();
    }
    
    public String toString(){
        return "Vendedor{" + 
        "cpf='"+ cpf +'\'' + 
        ", nomeCompleto='" + nomeCompleto +'\'' +  
        ", sexo=" + sexo + 
        ", dataNascimento=" + dataNascimento + 
        ", renda=" + endereco + 
        '}';
    }
    
}