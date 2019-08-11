package br.java.erickbruno.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobreNome;
	private BigInteger cpf;
	
	public Cliente(String nome, String sobreNome, BigInteger CPF) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = CPF;
	}
	
	public Cliente() {};

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public BigInteger getCpf() {
		return cpf;
	}
	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}
	

}
