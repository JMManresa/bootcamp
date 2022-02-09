package com.capgemini;

import com.capgemini.Enum.Color;

public abstract class Pieza {
	private Color color;
	
	public Pieza(Color color) {
		this.color = color;
	}
	
	public Color GetColor() {
		return color;
	}
	
	public void SetColor(Color color) {
		//TODO validacion
		this.color = color;
	}
	
	protected abstract boolean EsValido(Movimiento movimiento, Tablero tablero);
	
	public void Mover(Movimiento movimiento, Tablero tablero) {
		
	}
}
