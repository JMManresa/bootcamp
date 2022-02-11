package com.capgemini;

import com.capgemini.Enum.Color;

public class Principal {

	public static void main(String[] args) throws JuegoException {
		
//		System.out.println(Character.getNumericValue('A'));
//		System.out.println(Character.getNumericValue('B'));
//		System.out.println(Character.getNumericValue('C'));
		
		Tablero tablero = new Tablero();
		Pieza dama = new Dama(Color.BLANCO);
		
		Movimiento movimientoDiagonal = new Movimiento("A1E5");
		Movimiento movimientoHorizontal = new Movimiento("A1F1");
		Movimiento movimientoVertical = new Movimiento("A1A6");
		Movimiento movimientoL = new Movimiento("D1E3");
		
		
		System.out.println(dama.EsValido(movimientoDiagonal, tablero));
		System.out.println(dama.EsValido(movimientoHorizontal, tablero));
		System.out.println(dama.EsValido(movimientoVertical, tablero));
		System.out.println(dama.EsValido(movimientoL, tablero));
	
		
	}

	
}
