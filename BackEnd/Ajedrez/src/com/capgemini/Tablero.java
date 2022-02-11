package com.capgemini;

import com.capgemini.Enum.*;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];

	public Pieza GetEscaque(int fila, int columna) {

		if (!HayPieza(fila, columna))
			throw new NullPointerException("No hay pieza en este escaque.");
		else
			return piezas[fila][columna];
	}

	public Pieza GetEscaque(Posicion posicion) {
		if (posicion == null || !HayPieza(posicion))
			throw new NullPointerException("La posicion es null o no hay pieza en esa posicion");

		int fila = posicion.GetFila(), columna = posicion.GetColumna();
		return piezas[fila][columna];
	}

	public void SetEscaque(Pieza pieza, int fila, int columna) throws JuegoException {
		if (pieza == null)
			throw new NullPointerException("Pieza null");

		if (HayPieza(fila, columna)) {
			if (GetColorEscaque(fila, columna) != pieza.GetColor()) { // Hay pieza enemiga, comer pieza
				QuitaPieza(fila, columna);
				piezas[fila][columna] = pieza;
			} else { // ya hay una pieza del mismo color
				throw new JuegoException("Ya tienes una pieza en esa posicion");
			}
		} else { // la casilla está libre
			piezas[fila][columna] = pieza;
		}
	}

	public void SetEscaque(Pieza pieza, Posicion posicion) throws JuegoException {
		if (pieza == null || posicion == null)
			throw new NullPointerException("Pieza y/o posicion null");

		SetEscaque(pieza, posicion.GetFila(), posicion.GetColumna());
	}

	private boolean EsValido(int i) {
		// TODO
		return false;
	}

	public boolean HayPieza(int fila, int columna) {
		Validacion(fila, columna);

		return piezas[fila][columna] != null;
	}

	public boolean HayPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

		return HayPieza(posicion.GetFila(), posicion.GetColumna());
	}

	public void QuitaPieza(int fila, int columna) {

		if (!HayPieza(fila, columna))
			throw new NullPointerException("El escaque ya estaba vacío.");
		else
			piezas[fila][columna] = null;
	}

	public void QuitaPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

		QuitaPieza(posicion.GetFila(), posicion.GetColumna());
	}

	public void Mover(Movimiento movimiento) { //debería pasar por parametro tambien una pieza??
		// TODO
		if(movimiento == null)
			throw new NullPointerException("Movimiento null");
		
		
	}

	public Object Clone() {
		// TODO
		return null;
	}

	public Color GetColorEscaque(int fila, int columna) {
		if (!HayPieza(fila, columna))
			throw new NullPointerException("Casilla vacía");
		else
			return piezas[fila][columna].GetColor();
	}

	public boolean HayPiezasEntre(Movimiento movimiento) {
		if (movimiento == null)
			throw new NullPointerException("Movimiento null");
		
		int filaIni = movimiento.GetPosicionInicial().GetFila(),
			columnaIni = movimiento.GetPosicionInicial().GetColumna(),
			filaFin = movimiento.GetPosicionFinal().GetFila(),
			columnaFin = movimiento.GetPosicionFinal().GetColumna(),
			siguienteFila = filaIni,
			siguienteColumna = columnaIni;

		while (filaFin != siguienteFila && columnaFin != siguienteColumna) {
			siguienteFila += movimiento.DeltaFila();
			siguienteColumna += movimiento.DeltaColumna();
			if (piezas[siguienteFila][siguienteColumna] != null) {
				return true;
			}
		}
		return false;
	}

	private void Validacion(int fila, int columna) {
		if (fila < 1 || fila > 8 || columna < 1 || columna > 8)
			throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
	}
}
