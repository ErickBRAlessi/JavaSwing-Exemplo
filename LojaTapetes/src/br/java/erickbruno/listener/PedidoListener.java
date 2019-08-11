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
import br.java.erickbruno.model.Forma;
import br.java.erickbruno.model.Pedido;
import br.java.erickbruno.model.Tapete;

public class PedidoListener implements Serializable {

	private static final long serialVersionUID = 1L;

	static List<Pedido> pedidosDAO = new ArrayList<Pedido>();

	public boolean salvarPedido(List<Tapete> tapetes, BigInteger CPF) {
		recuperarPersistencia();
		if (tapetes == null || CPF == null) {
			return false;
		}
		try {
			for (int i = 0; i < pedidosDAO.size(); i++) {
				if (pedidosDAO.get(i).getCPF().equals(CPF)) {
					pedidosDAO.get(i).getProdutos().addAll(tapetes);
					atualizarPersistencia();
					return true;
				}
			}
			pedidosDAO.add(new Pedido(CPF, tapetes));
			atualizarPersistencia();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void imprimirPedidosDAO() {
		recuperarPersistencia();
		System.out.println("Imprimindo");
		for (Pedido p : pedidosDAO) {
			System.out.println(p);
		}
	}

	public List<Pedido> getPedidosDAO() {
		recuperarPersistencia();
		return pedidosDAO;
	}

	private void atualizarPersistencia() {
		try {
			FileOutputStream fout = new FileOutputStream("pedidosDAO.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(pedidosDAO);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void recuperarPersistencia() {
		try {
			FileInputStream fin = new FileInputStream("pedidosDAO.bin");
			ObjectInputStream ois = new ObjectInputStream(fin);
			pedidosDAO = (List<Pedido>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			atualizarPersistencia();
			recuperarPersistencia();
			System.out.println(e.getMessage());

		}

	}

	public boolean removerPedido(BigInteger CPF, int row) {
		try {
			recuperarPersistencia();
			for (int i = 0; i < pedidosDAO.size(); i++) {
				System.out.println("Encontrou cpf");
				if (pedidosDAO.get(i).getCPF().equals(CPF)) {
					System.out.println("Removeu");
					pedidosDAO.get(i).getProdutos().remove(row);
					atualizarPersistencia();
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	

	public Pedido consultarPedidos(BigInteger CPF) {
		recuperarPersistencia();
		for (int i = 0; i < pedidosDAO.size(); i++) {
			System.out.println(pedidosDAO.get(i).getCPF());
			if (pedidosDAO.get(i).getCPF().equals(CPF)) {
				return pedidosDAO.get(i);
			}
		}
		return null;
	}

	
	public Forma criarForma(List<Double> medidas) {
		return new Forma(medidas);
	}

}
