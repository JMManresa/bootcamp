package com.capgemini;

import static org.hamcrest.CoreMatchers.instanceOf;

import com.capgemini.Enum.Color;

public class Peon extends Pieza {

	public Peon(Color color) {
		super(color);
	}

	@Override
	protected boolean EsValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");

		if (PuedeComer(movimiento, tablero)) {
			return ((movimiento.SaltoHorizontal() == 1 && movimiento.SaltoVertical() == 1)
					|| movimiento.SaltoVertical() == 1 && movimiento.SaltoHorizontal() == 0);
		}
		return (movimiento.SaltoVertical() == 1 && movimiento.SaltoHorizontal() == 0);
	}

	private boolean Inicia(Posicion posicion) {
		// TODO
		return false;
	}

	private boolean PuedeComer(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");

		if(movimiento.SaltoHorizontal() != 1 || movimiento.SaltoVertical() != 1)
			throw new JuegoException("Movimiento no valido");
		
		Posicion posicionInicial = movimiento.GetPosicionInicial();
		Posicion posicionFinal = movimiento.GetPosicionFinal();
		Pieza peon = tablero.GetEscaque(posicionInicial);
		Pieza pieza = tablero.GetEscaque(posicionFinal);

		if (peon instanceof Peon && pieza.GetColor() != peon.GetColor()) 
			return true;
		else return false;

	}

	public void Mover(Movimiento movimiento, Tablero tablero) {

	}

}
