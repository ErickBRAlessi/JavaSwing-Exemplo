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
import br.java.erickbruno.model.Material;

public class PrecoListener implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Material> materialDAO = new ArrayList<Material>();	

	public boolean salvarMaterial(int numMaterial, double precoMaterial) {
		if (numMaterial < 0 || numMaterial > 2){
			return false;
		}
		try {
			recuperarPersistencia();			
			for (int i = 0; i < materialDAO.size(); i++) {
				if (numMaterial == materialDAO.get(i).getMaterial()) {
					materialDAO.remove(i);
				}
			}
			materialDAO.add(new Material(numMaterial, precoMaterial));
			System.out.println("Salvo Material " + numMaterial + " " + precoMaterial);
			atualizarPersistencia();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

//	public void imprimirClienteDAO() {
//		recuperarPersistencia();
//		System.out.println("Imprimindo");
//		for (Cliente c : clienteDAO) {
//			System.out.println(c.getNome());
//		}
//	}
//
//	public List<Cliente> getClienteDAO() {
//		recuperarPersistencia();
//		return clienteDAO;
//	}
//
	private void atualizarPersistencia() {
		try {
			FileOutputStream fout = new FileOutputStream("materialDAO.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(materialDAO);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void recuperarPersistencia() {
		try {
			FileInputStream fin = new FileInputStream("materialDAO.bin");
			ObjectInputStream ois = new ObjectInputStream(fin);
			materialDAO = (List<Material>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			atualizarPersistencia();
			recuperarPersistencia();
			System.out.println(e.getMessage());

		}

	}

	public Material consultarMaterial(int tipoMaterial) {
		recuperarPersistencia();
		for (int i = 0; i < materialDAO.size(); i++) {
			if (materialDAO.get(i).getMaterial() == tipoMaterial){
				return materialDAO.get(i);
			}
		}
		return null;
	}
}
