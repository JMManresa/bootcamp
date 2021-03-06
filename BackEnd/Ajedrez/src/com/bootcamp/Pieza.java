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
			throw new IllegalArgumentException();

		if (!EsValido(movimiento, tablero))
			throw new JuegoException("Movimiento no v?lido para esta pieza");
		
		tablero.Mover(movimiento);

	}

	protected abstract boolean EsValido(Movimiento movimiento, Tablero tablero) throws JuegoException;
}
