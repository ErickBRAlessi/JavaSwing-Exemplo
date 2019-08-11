package br.java.erickbruno.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Forma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Double> medidas = new ArrayList<Double>();
	
	public Forma(List<Double> medidas){
		this.medidas = medidas;		
	}
	
	public Forma() {};

	public List<Double> getMedidas() {
		return medidas;
	}

	public void setMedidas(List<Double> medidas) {
		this.medidas = medidas;
	}
	
}
