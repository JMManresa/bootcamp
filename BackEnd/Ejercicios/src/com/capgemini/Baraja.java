package com.capgemini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public abstract class Baraja {

	protected Stack<Naipe> naipes;

	public Baraja() {

	}

	public void Barajar() {
		Collections.shuffle(naipes);
	}

	public ArrayList<Naipe> Repartir(int numRepartos) {
		if(numRepartos > naipes.size() || numRepartos < 1)
			throw new IllegalArgumentException("Numero de repartos no permitido");
		ArrayList<Naipe> reparto = new ArrayList<>();
		for (int i = 0; i < numRepartos; i++) {
			reparto.add(naipes.pop());
		}
		return reparto;
	}
	
	public abstract Naipe Comparar(Naipe a, Naipe b);
	
//	public void MostrarBaraja() {
//	for (int i = 0; i < naipes.size(); i++) {
//		System.out.println(naipes.elementAt(i).getValor() + " de " + naipes.elementAt(i).getPalo());
//	}
//}
}
