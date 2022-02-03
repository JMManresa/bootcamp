package com.capgemini;

import java.util.Stack;

import enums.PalosBarajaEsp;

public class BarajaEsp extends Baraja {

	public BarajaEsp() {
		Inicializar();
	}

	private void Inicializar() {
		naipes = new Stack<>();

		int cont = 0;
		for (int i = 1; i <= 48; i++) {
			if (i == 13 || i == 25 || i == 37)
				cont++;

			switch (cont) {
				case 0: {
					naipes.push(new Naipe(i, PalosBarajaEsp.BASTOS));
					break;
				}
				case 1: {
					naipes.push(new Naipe(i - (cont * 12), PalosBarajaEsp.COPAS));
					break;
				}
				case 2: {
					naipes.push(new Naipe(i - (cont * 12), PalosBarajaEsp.ESPADAS));
					break;
				}
				case 3: {
					naipes.push(new Naipe(i - (cont * 12), PalosBarajaEsp.OROS));
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
