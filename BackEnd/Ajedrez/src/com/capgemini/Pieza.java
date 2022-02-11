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

	public void Mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento == null || tablero == null)
			throw new NullPointerException();
		tablero.Mover(movimiento);
	}

	protected abstract boolean EsValido(Movimiento movimiento, Tablero tablero);
}
