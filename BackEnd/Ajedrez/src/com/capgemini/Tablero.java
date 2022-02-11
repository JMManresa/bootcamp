package com.capgemini;

import com.capgemini.Enum.*;

public class Tablero {
	private final int TAMA�O_FILA = 8;
	private final int TAMA�O_COLUMNA = 8;
	private Pieza[][] tablero = new Pieza[TAMA�O_FILA][TAMA�O_COLUMNA];

	public Pieza GetEscaque(int fila, int columna) {

		if (!HayPieza(fila, columna))
			throw new NullPointerException("No hay pieza en este escaque.");
		else
			return tablero[fila][columna];
	}

	public Pieza GetEscaque(Posicion posicion) {
		if (posicion == null || !HayPieza(posicion))
			throw new NullPointerException("La posicion es null o no hay pieza en esa posicion");

		int fila = posicion.GetFila(), columna = posicion.GetColumna();
		return tablero[fila][columna];
	}

	public void SetEscaque(int fila, int columna, Pieza pieza) throws JuegoException {
		if (pieza == null)
			throw new NullPointerException("Pieza null");

		if (HayPieza(fila, columna)) {
			if (GetColorEscaque(fila, columna) != pieza.GetColor()) { // Hay pieza enemiga, comer pieza
				QuitaPieza(fila, columna);
				tablero[fila][columna] = pieza;
			} else { // ya hay una pieza del mismo color
				throw new JuegoException("Ya tienes una pieza en esa posicion");
			}
		} else { // la casilla est� libre
			tablero[fila][columna] = pieza;
		}
	}

	public void SetEscaque(Pieza pieza, Posicion posicion) throws JuegoException {
		if (pieza == null || posicion == null)
			throw new NullPointerException("Pieza y/o posicion null");

		SetEscaque(posicion.GetFila(), posicion.GetColumna(), pieza);
	}

	public boolean HayPieza(int fila, int columna) {
		Validacion(fila, columna);

		return tablero[fila][columna] != null;
	}

	public boolean HayPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

		return HayPieza(posicion.GetFila(), posicion.GetColumna());
	}

	public void QuitaPieza(int fila, int columna) {

		if (!HayPieza(fila, columna))
			throw new NullPointerException("El escaque ya estaba vac�o.");
		else
			tablero[fila][columna] = null;
	}

	public void QuitaPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

		QuitaPieza(posicion.GetFila(), posicion.GetColumna());
	}

	public void Mover(Movimiento movimiento) { // comprobar que en la posicion inicial haya una pieza
		// TODO
		if(movimiento == null)
			throw new NullPointerException("Movimiento null");
		
		int filaIni = movimiento.GetPosicionInicial().GetFila(), columnaIni = movimiento.GetPosicionInicial().GetColumna();
		
		if(tablero[filaIni][columnaIni] == null)
			throw new NullPointerException("No hay pieza para mover");
		
		
	}
	
	
	public Object Clone() {
		Pieza[][] tableroClon = new Pieza[TAMA�O_FILA][TAMA�O_COLUMNA];
		
		
		for(int i = 0; i < TAMA�O_FILA; i++)
			for(int j = 0; j < TAMA�O_COLUMNA; j++) {
				if(tablero[i][j] != null)
					tableroClon[i][j] = tablero[i][j];
			}
		return tableroClon;
		
		//return tablero.clone();
	}

	public Color GetColorEscaque(int fila, int columna) {
		if (!HayPieza(fila, columna))
			throw new NullPointerException("Casilla vac�a");
		else
			return tablero[fila][columna].GetColor();
	}

	public boolean HayPiezasEntre(Movimiento movimiento) throws JuegoException {
		if (movimiento == null)
			throw new NullPointerException("Movimiento null");
		
		if(!(movimiento.EsHorizontal() || movimiento.EsVertical()
				|| (movimiento.EsDiagonal() && movimiento.SaltoHorizontal() == movimiento.SaltoVertical())))
			throw new JuegoException("El movimiento debe ser horizontal, vertical o diagonal");
		
		int filaIni = movimiento.GetPosicionInicial().GetFila(), columnaIni = movimiento.GetPosicionInicial().GetColumna(),
			filaFin = movimiento.GetPosicionFinal().GetFila(), columnaFin = movimiento.GetPosicionFinal().GetColumna(),
			siguienteFila = filaIni, siguienteColumna = columnaIni;

		while (filaFin != siguienteFila && columnaFin != siguienteColumna) {
			siguienteFila += movimiento.DeltaFila();
			siguienteColumna += movimiento.DeltaColumna();
			if (tablero[siguienteFila][siguienteColumna] != null) {
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
