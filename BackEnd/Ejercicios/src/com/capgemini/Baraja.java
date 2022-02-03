package com.capgemini;

import java.util.Collections;
import java.util.Stack;

public abstract class Baraja {
	
	private Stack<Naipe> naipes;
	
	public Baraja(Stack<Naipe> naipes)
	{
		this.naipes = naipes;
	}
	
	public void Barajar() {
		Collections.shuffle(naipes);
	}
	
	public Naipe Repartir() {
		return naipes.pop();
	}
	
	public Naipe Comparar(Naipe a, Naipe b) {
		return null;
	}
	
	public void MostrarBaraja() {
		for(int i = 0; i < naipes.size(); i++)
		{
			System.out.println(naipes.elementAt(i).getValor() + " de " + naipes.elementAt(i).getPalo());
		}
		
	}
}
