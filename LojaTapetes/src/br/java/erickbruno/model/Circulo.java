package br.java.erickbruno.model;

import java.io.Serializable;
import java.util.List;

public class Circulo extends Forma implements Serializable {

	private static final long serialVersionUID = 1L;

	public Circulo(List<Double> medidas) {
		super(medidas);
	}
	
	public Circulo(){};

	public double area(List<Double> medidas) {
		if (medidas.size() >= 2 && medidas != null) {
			return (Math.PI * medidas.get(0) * medidas.get(0));
		}
		System.out.println("Nenhuma medida setada para " + getClass().getSimpleName());
		return 0d;
	}

	public double area() {
		if (super.getMedidas().size() >= 2 && super.getMedidas() != null) {
			return (Math.PI * super.getMedidas().get(0) * super.getMedidas().get(0));
		}
		System.out.println("Nenhuma medida setada para " + getClass().getSimpleName());
		return 0d;
	}
}
