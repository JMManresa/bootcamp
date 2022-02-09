package com.capgemini;

import com.capgemini.Enum.Color;

public class Torre extends Pieza{

	public Torre(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) {
		// TODO Auto-generated method stub
		return false;
	}

}
