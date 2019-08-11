package br.java.erickbruno.listener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.java.erickbruno.model.Cliente;

public class ClienteListener implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Cliente> clienteDAO = new ArrayList<Cliente>();

	public boolean salvarCliente(String nome, String sobreNome, BigInteger CPF) {
		if (nome == null || nome.equals("") || sobreNome == null || sobreNome.equals("") || CPF == null) {
			return false;
		}
		try {
			recuperarPersistencia();
			for (int i = 0; i < clienteDAO.size(); i++) {
				if (clienteDAO.get(i).getCpf().equals(CPF)) {
					clienteDAO.remove(i);
				}
			}
			clienteDAO.add(new Cliente(nome.toUpperCase().trim(), sobreNome.toUpperCase().trim(), CPF));
			atualizarPersistencia();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void imprimirClienteDAO() {
		recuperarPersistencia();
		System.out.println("Imprimindo");
		for (Cliente c : clienteDAO) {
			System.out.println(c.getNome());
		}
	}

	public List<Cliente> getClienteDAO() {
		recuperarPersistencia();
		return clienteDAO;
	}

	private void atualizarPersistencia() {
		try {
			FileOutputStream fout = new FileOutputStream("clienteDAO.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(clienteDAO);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void recuperarPersistencia() {
		try {
			FileInputStream fin = new FileInputStream("clienteDAO.bin");
			ObjectInputStream ois = new ObjectInputStream(fin);
			clienteDAO = (List<Cliente>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			atualizarPersistencia();
			recuperarPersistencia();
			System.out.println(e.getMessage());

		}

	}

	public boolean removerCliente(BigInteger CPF) {
		if (CPF == null) {
			return false;
		}
		try {
			recuperarPersistencia();
			PedidoListener pedidoListener = new PedidoListener();
			boolean pedidosRemovidos = true;
			while (pedidosRemovidos) {
				pedidosRemovidos = pedidoListener.removerPedido(CPF, 0);
			}
			for (int i = 0; i < clienteDAO.size(); i++) {
				if (clienteDAO.get(i).getCpf().equals(CPF)) {
					clienteDAO.remove(i);
				}
			}
			atualizarPersistencia();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Cliente consultarCliente(BigInteger CPF) {
		recuperarPersistencia();
		for (int i = 0; i < clienteDAO.size(); i++) {
			if (clienteDAO.get(i).getCpf().equals(CPF)) {
				return clienteDAO.get(i);
			}
		}
		return null;
	}
}
