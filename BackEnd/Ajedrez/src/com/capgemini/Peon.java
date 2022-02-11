package com.capgemini;

import com.capgemini.Enum.Color;

public class Peon extends Pieza{

	public Peon(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) {
		// TODO
		if(movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");
		
		if(PuedeComer(movimiento, tablero)) {
			
		}
		return false;
	}

	private boolean Avanza(Movimiento movimiento) {
		//TODO
		return false;
	}
	
	private boolean Inicia(Posicion posicion) {
		//TODO
		return false;
	}
	
	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) {
		//TODO
		if(movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");
		
		
		return false;
	}
	
	public void Mover(Movimiento movimiento, Tablero tablero) {
		
	}
	
	
	
	
}
