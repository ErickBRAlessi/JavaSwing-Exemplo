package br.java.erickbruno.teste;

import java.util.ArrayList;
import java.util.List;

import br.java.erickbruno.model.Circulo;
import br.java.erickbruno.model.Forma;
import br.java.erickbruno.model.Quadrado;
import br.java.erickbruno.model.Triangulo;

public class TesteForma {

	public static void main(String[] args) {
		List<Double> tamanhos = new ArrayList<Double>();

		tamanhos.add(2d);
		tamanhos.add(3d);
		System.out.println(tamanhos.size());
		Forma formaQ = new Quadrado();
		Forma formaC = new Circulo();
		Forma formaT = new Triangulo();

		formaQ.setMedidas(tamanhos);
		System.out.println(((Quadrado) formaQ).area());

		System.out.println(((Circulo) formaC).area());
		System.out.println(((Circulo) formaC).area(tamanhos));

		System.out.println(((Triangulo) formaT).area());
		System.out.println(((Triangulo)formaT).area(tamanhos));

	}

}
