package com.capgemini;

import java.util.Stack;

import enums.PalosBarajaEsp;

public class BarajaEsp extends Baraja {

	static final int NUM_CARTAS = 48;
	static final int CARTAS_POR_PALO = 12;
	
	public BarajaEsp() {
		Inicializar();
	}

	private void Inicializar() {
		naipes = new Stack<>();

		int cont = 0;
		for (int i = 0; i < NUM_CARTAS; i++) {
			if (i == 12 || i == 24 || i == 36)
				cont++;

			switch (cont) {
				case 0: {
					naipes.push(new Naipe(i+1, PalosBarajaEsp.BASTOS));
					break;
				}
				case 1: {
					naipes.push(new Naipe(i+1 - (cont * 12), PalosBarajaEsp.COPAS));
					break;
				}
				case 2: {
					naipes.push(new Naipe(i+1 - (cont * 12), PalosBarajaEsp.ESPADAS));
					break;
				}
				case 3: {
					naipes.push(new Naipe(i+1 - (cont * 12), PalosBarajaEsp.OROS));
					break;
				}
			}
		}
	}

	@Override
	public Naipe Comparar(Naipe a, Naipe b) {
		// TODO Auto-generated method stub
		return null;
	}
}
