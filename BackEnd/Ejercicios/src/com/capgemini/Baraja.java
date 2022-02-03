package com.capgemini;

import java.util.Collections;
import java.util.Stack;

public abstract class Baraja {

	protected Stack<Naipe> naipes;

	public Baraja() {

	}

	public void Barajar() {
		Collections.shuffle(naipes);
	}

	public Naipe Repartir() {
		return naipes.pop();
	}

	public void MostrarBaraja() {
		for (int i = 0; i < naipes.size(); i++) {
			System.out.println(naipes.elementAt(i).getValor() + " de " + naipes.elementAt(i).getPalo());
		}
	}

	public abstract Naipe Comparar(Naipe a, Naipe b);
}
