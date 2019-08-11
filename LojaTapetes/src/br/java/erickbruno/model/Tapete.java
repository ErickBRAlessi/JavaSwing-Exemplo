package br.java.erickbruno.model;

import java.io.Serializable;

public class Tapete implements Serializable {

	private static final long serialVersionUID = 1L;
	private Forma forma;
	private Material material;

	public Tapete(Forma forma, Material material) {
		this.forma = forma;
		this.material = material;
	}

	public Forma getForma() {
		return forma;
	}

	public void setForma(Forma forma) {
		this.forma = forma;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double precoTapete() {
		try {
			if (forma.getClass().getSimpleName().toUpperCase().trim().equals("QUADRADO")) {
				return (material.getPreco() * ((Quadrado) forma).area());
			} else if (forma.getClass().getSimpleName().toUpperCase().trim().equals("CIRCULO")) {
				return (material.getPreco() * ((Circulo) forma).area());
			} else if (forma.getClass().getSimpleName().toUpperCase().trim().equals("TRIANGULO")) {
				return (material.getPreco() * ((Triangulo) forma).area());
			} else {
				System.out.println("Não pode ser calculado");
				return 0d;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Erro desconhecido no metodo precoTapete()");
		return 0;

	}

	public double area() {
		try {
			if (forma.getClass().getSimpleName().toUpperCase().trim().equals("QUADRADO")) {
				return (((Quadrado) forma).area());
			} else if (forma.getClass().getSimpleName().toUpperCase().trim().equals("CIRCULO")) {
				return (((Circulo) forma).area());
			} else if (forma.getClass().getSimpleName().toUpperCase().trim().equals("TRIANGULO")) {
				return (((Triangulo) forma).area());
			} else {
				System.out.println("Não pode ser calculado");
				return 0d;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Erro desconhecido no metodo precoTapete()");
		return 0;

	}

	@Override
	public String toString() {
		return forma.getClass().getSimpleName() + " " + precoTapete() + " " + area() + " "+ material.getMaterialName();
	}

}
