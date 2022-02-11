package com.capgemini;

import com.capgemini.Enum.Color;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("Movimiento o tablero null");

		return ((movimiento.SaltoHorizontal() == 1 && movimiento.SaltoVertical() == 1) // diagonal
				|| (movimiento.SaltoHorizontal() == 1 && movimiento.SaltoVertical() == 0) // horizontal
				|| (movimiento.SaltoHorizontal() == 0 && movimiento.SaltoVertical() == 1)); // vertical
	}

}
