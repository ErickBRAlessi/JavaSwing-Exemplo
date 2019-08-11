package br.java.erickbruno.model;

import java.io.Serializable;
import java.util.List;

public class Quadrado extends Forma implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Quadrado(List<Double> medidas) {
		super(medidas);
	}

	public Quadrado() {};

	public double area(List<Double> medidas) {
		if (medidas.size() >= 2 && medidas != null) {
			return (medidas.get(0) * medidas.get(1));
		}
		System.out.println("Nenhuma medida setada para " + getClass().getSimpleName());
		return 0d;
	}

	public double area() {
		if (super.getMedidas().size() >= 2 && super.getMedidas() != null) {
			return (super.getMedidas().get(0) * super.getMedidas().get(1));
		}
		System.out.println("Nenhuma medida setada para " + getClass().getSimpleName());
		return 0d;
	}
}
