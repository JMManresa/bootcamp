package com.capgemini;

import com.capgemini.Enum.Color;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("Movimiento o tablero null");
		
		return movimiento.EsDiagonal() && !tablero.HayPiezasEntre(movimiento);
	}

}
