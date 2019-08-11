package br.java.erickbruno.teste;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.java.erickbruno.listener.PedidoListener;
import br.java.erickbruno.model.Cliente;
import br.java.erickbruno.model.Forma;
import br.java.erickbruno.model.Material;
import br.java.erickbruno.model.Pedido;
import br.java.erickbruno.model.Quadrado;
import br.java.erickbruno.model.Tapete;
import br.java.erickbruno.model.Triangulo;

public class TestePedido {
	public static void main(String[] args) {
		BigInteger cpf = new BigInteger("1");
//		Cliente cliente = new Cliente("Erick", "Alessi", cpf);
//		List<Tapete> tapetes = new ArrayList<Tapete>();
//		List<Double> tamanhos = new ArrayList<Double>();
//		tamanhos.add(2d);
//		tamanhos.add(5d);
//		
//		// TESTANDO TAPETE QUADRADO COMUM
//		Forma formaQ = new Quadrado(tamanhos);
//		Material materialC = new Material(0, 150d);
//		tapetes.add(new Tapete(formaQ, materialC));
//
//		// TESTANDO TAPETE TRIANGULO PREMIUM
//		Forma formaT = new Triangulo(tamanhos);
//		Material materialP = new Material(1, 350d);
//		tapetes.add(new Tapete(formaT, materialP));
//		
//		// TESTANDO TAPETE CIRCULO LUXO
//		Forma formaC = new Triangulo(tamanhos);
//		Material materialL = new Material(2, 750d);
//		tapetes.add(new Tapete(formaC, materialL));
//		
//		//Gerando Pedido
//		Pedido pedido = new Pedido(cpf, tapetes);
//		System.out.println(pedido.toString());
		PedidoListener pedidoListener = new PedidoListener();
//		pedidoListener.salvarPedido(tapetes, cpf);
		System.out.println(pedidoListener.consultarPedidos(new BigInteger("1")));
	}

}
