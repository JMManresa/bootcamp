package com.capgemini;

import java.util.Stack;

import enums.PalosBarajaEsp;

public class BarajaEsp extends Baraja {

	static final int NUM_CARTAS = 48;
	static final int CARTAS_POR_PALO = 12;
	static final int NUM_PALOS = 4;
	
	public BarajaEsp() {
		Inicializar();
	}

	private void Inicializar() {
		naipes = new Stack<>();

		int numPalo = 0;
		for (int i = 0; i < NUM_CARTAS; i++) {
			if (i == CARTAS_POR_PALO || i == CARTAS_POR_PALO * 2 || i == CARTAS_POR_PALO * 3)
				numPalo++;

			switch (numPalo) {
				case 0: {
					naipes.push(new Naipe(i+1, PalosBarajaEsp.BASTOS));
					break;
				}
				case 1: {
					naipes.push(new Naipe(i+1 - (numPalo * CARTAS_POR_PALO), PalosBarajaEsp.COPAS));
					break;
				}
				case 2: {
					naipes.push(new Naipe(i+1 - (numPalo * CARTAS_POR_PALO), PalosBarajaEsp.ESPADAS));
					break;
				}
				case 3: {
					naipes.push(new Naipe(i+1 - (numPalo * CARTAS_POR_PALO), PalosBarajaEsp.OROS));
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
