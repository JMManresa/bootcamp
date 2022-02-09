package com.capgemini;

import enums.PalosBarajaEsp;

public class Naipe {

	private int valor;
	private PalosBarajaEsp palo;

	public Naipe(int valor, PalosBarajaEsp palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public int getValor() {
		return valor;
	}

	public PalosBarajaEsp getPalo() {
		return palo;
	}
	
	public void cosa(int i) {
		System.out.println(PalosBarajaEsp.getEnum(i));
	}
}
