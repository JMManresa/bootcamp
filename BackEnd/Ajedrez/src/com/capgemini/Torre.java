package com.capgemini;

import com.capgemini.Enum.Color;

public class Torre extends Pieza{

	public Torre(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento == null || tablero == null)
			throw new JuegoException("Movimiento o tablero null");
		
		return !tablero.HayPiezasEntre(movimiento) && movimiento.EsHorizontal() || movimiento.EsVertical();
	}

}
