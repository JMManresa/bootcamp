package com.capgemini;

import java.util.Stack;

public class BarajaEsp extends Baraja {
	
	public BarajaEsp(Stack<Naipe> naipes) {
		super(naipes);
	}

	@Override
	public Naipe Comparar(Naipe a, Naipe b) {
		Naipe mayor = null;
		if (a.getValor() > b.getValor()) {
			mayor = new Naipe(a.getValor(), a.getPalo());
		} else if (a.getValor() < b.getValor()) {
			mayor = new Naipe(b.getValor(), b.getPalo());
		}

		return mayor;
	}
}
