package br.java.erickbruno.model;

import java.io.Serializable;

public class Material implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int material;
	private Double preco;

	public Material() {
	};

	public Material(int material, Double preco) {
		this.material = material;
		this.preco = preco;
	}

	public Material(String material) {
		if (material.toUpperCase().trim().equals("NORMAL")) {
			this.material = 0;
		} else if (material.toUpperCase().trim().equals("PREMIUM")) {
			this.material = 1;
		} else {
			this.material = 2;
		}
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	public String getMaterialName() {
		if (this.material == 0) {
			return "NORMAL";
		} else if (this.material == 1) {
			return "PREMIUM";
		} else if (this.material == 2) {
			return "LUXO";
		}
		return "MATERIAL INEXISTENTE";
	}

}
