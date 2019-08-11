package br.java.erickbruno.teste;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.java.erickbruno.listener.ClienteListener;
import br.java.erickbruno.listener.PedidoListener;
import br.java.erickbruno.model.Forma;
import br.java.erickbruno.model.Material;
import br.java.erickbruno.model.Quadrado;
import br.java.erickbruno.model.Tapete;
import br.java.erickbruno.model.Triangulo;

public class TestePedidosPersistencia {

	public static void main(String[] args) {
		BigInteger cpf = new BigInteger("2");
		ClienteListener dao = new ClienteListener();
		PedidoListener pedidoListener = new PedidoListener();

		dao.imprimirClienteDAO();

		List<Tapete> tapetes = new ArrayList<Tapete>();
		List<Double> tamanhos = new ArrayList<Double>();
		tamanhos.add(2d);
		tamanhos.add(5d);

		// TESTANDO TAPETE QUADRADO COMUM
		Forma formaQ = new Quadrado(tamanhos);
		Material materialC = new Material(0, 150d);
		tapetes.add(new Tapete(formaQ, materialC));

		// TESTANDO TAPETE TRIANGULO PREMIUM
		Forma formaT = new Triangulo(tamanhos);
		Material materialP = new Material(1, 350d);
		tapetes.add(new Tapete(formaT, materialP));

		// TESTANDO TAPETE CIRCULO LUXO
		Forma formaC = new Triangulo(tamanhos);
		Material materialL = new Material(2, 750d);
		tapetes.add(new Tapete(formaC, materialL));

		pedidoListener.salvarPedido(tapetes, cpf);
		pedidoListener.imprimirPedidosDAO();

	}
}
