package br.java.erickbruno.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigInteger CPF;
	private List<Tapete> produtos = new ArrayList<>();

	public Pedido(BigInteger CPF, List<Tapete> produtos) {
		this.CPF = CPF;
		this.produtos = produtos;
	}

	public List<Tapete> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Tapete> produtos) {
		this.produtos = produtos;
	}

	public BigInteger getCPF() {
		return CPF;
	}

	public void setCPF(BigInteger CPF) {
		this.CPF = CPF;
	}
	
	public Double totalPedido() {
		double total = 0d;
		for (Tapete t : produtos) {
			total += t.precoTapete();
		}	
		return total;
	}

	@Override
	public String toString() {
		String aux = CPF.toString();
		for (Tapete t : produtos) {
			aux += " ";
			aux += t.toString();
		}
		return aux;
	}

}
