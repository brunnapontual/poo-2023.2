package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);
	
	public Vendedor buscar(String cpf) {
		return (Vendedor)cadastro.buscar(BRANCO + cpf);
	}
	
	public boolean incluir(Vendedor vendedor) {
		Vendedor vendedorBusca = buscar(vendedor.getCpf());
		if (vendedorBusca != null) { 
			return false;
		} else {
			cadastro.incluir(vendedor, BRANCO + vendedor.getCpf());
			return true;
		}		 
	}
	
	public boolean excluir(Vendedor vendedor) {
		Vendedor vendedorBusca = buscar(vendedor.getCpf());
		if (vendedorBusca == null) { 
			return false;
		} else {
			cadastro.excluir(BRANCO + vendedor.getCpf());
			return true;
		}		 
	}
	
	
	public boolean alterar(Vendedor vendedor) {
		Vendedor vendedorBusca = buscar(vendedor.getCpf());
		if (vendedorBusca == null) {
			return false;
		} else {
			cadastro.alterar(vendedor, BRANCO + vendedor.getCpf());
			return true;
		}		
	}
	
	public Vendedor[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Vendedor.class);
		Vendedor[] vendedores = new Vendedor[rets.length];
		for(int i=0; i<rets.length; i++) {
			vendedores[i] = (Vendedor)rets[i];
		}
		return vendedores;
	} 
}