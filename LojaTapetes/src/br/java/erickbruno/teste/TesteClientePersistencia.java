package br.java.erickbruno.teste;

import java.math.BigInteger;

import br.java.erickbruno.listener.ClienteListener;
import br.java.erickbruno.model.Cliente;

public class TesteClientePersistencia {

	public static void main(String[] args) {
		BigInteger cpf = new BigInteger("1");
		ClienteListener dao = new ClienteListener();
		dao.salvarCliente("Erick", "Alessi", cpf);
		System.out.println(dao.consultarCliente(cpf));		
	}
}
