package com.capgemini;

import com.capgemini.Enum.Color;

public class Caballo extends Pieza{

	public Caballo(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) {
		// TODO Auto-generated method stub
		return false;
	}

}
