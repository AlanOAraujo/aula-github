package br.com.alura.horas.modelos;

import java.util.Calendar;


public class HoraPorDia {

	private Calendar data;
	
	private double horasNormais;
	
	private double horasExtras;
	
	public HoraPorDia(double horasNormais, double horasExtras, Calendar data) {

		this.horasExtras = horasExtras;
		this.horasNormais = horasNormais;
		this.data = data;
	}
	
	public HoraPorDia() {}

	public double getHorasNormais() {
		return horasNormais;
	}

	public void setHorasNormais(double horasNormais) {
		this.horasNormais = horasNormais;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}

