package br.java.erickbruno.teste;

import java.util.ArrayList;
import java.util.List;

import br.java.erickbruno.model.Circulo;
import br.java.erickbruno.model.Forma;
import br.java.erickbruno.model.Material;
import br.java.erickbruno.model.Quadrado;
import br.java.erickbruno.model.Tapete;
import br.java.erickbruno.model.Triangulo;

public class TesteTapete {

	public static void main(String[] args) {
		List<Tapete> tapetes = new ArrayList<Tapete>();
		List<Double> tamanhos = new ArrayList<Double>();
		
		tamanhos.add(2d);
		tamanhos.add(5d);
		Forma forma = new Triangulo(tamanhos);		
		Material material = new Material();
		material.setMaterial(0);
		material.setPreco(150d);
		Tapete tapete = new Tapete(forma, material);
		System.out.println(tapete.precoTapete());
		System.out.println(tapete.toString());
		
		Forma forma1 = new Circulo(tamanhos);		
		Material material1 = new Material(1,350d);
		Tapete tapete1 = new Tapete(forma1, material1);
		System.out.println(tapete1.precoTapete());
		System.out.println(tapete1.toString());
		
		Forma forma2 = new Quadrado(tamanhos);		
		Material material2 = new Material("LUXO");
		material2.setPreco(850d);
		Tapete tapete2 = new Tapete(forma2, material2);
		System.out.println(tapete2.precoTapete());
		System.out.println(tapete2.toString());
	}

}
