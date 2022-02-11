package com.capgemini;

import com.capgemini.Enum.Color;

public class Caballo extends Pieza {

	public Caballo(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");

		return ((movimiento.SaltoVertical() == 2 && movimiento.SaltoHorizontal() == 1)
				|| (movimiento.SaltoVertical() == 1 && movimiento.SaltoHorizontal() == 2));
	}

}
