package com.capgemini;

import com.capgemini.Enum.*;

/**
 * 
 * @author jmanresa
 *
 */
public class Tablero {
	private final int TAMAÑO_FILA = 8;
	private final int TAMAÑO_COLUMNA = 8;
	private Pieza[][] tablero = new Pieza[TAMAÑO_COLUMNA][TAMAÑO_FILA];

	/**
	 * 
	 * @param columna
	 * @param fila
	 * @return
	 */
	public Pieza GetEscaque(int columna, int fila) {

		if (!HayPieza(columna, fila))
			throw new NullPointerException("No hay pieza en este escaque.");
		else
			return tablero[columna - 1][fila - 1];
	}

	/**
	 * 
	 * @param posicion
	 * @return
	 */
	public Pieza GetEscaque(Posicion posicion) {
		if (posicion == null || !HayPieza(posicion))
			throw new NullPointerException("La posicion es null o no hay pieza en esa posicion");

		int columna = posicion.GetColumna(), fila = posicion.GetFila();
		return tablero[columna - 1][fila - 1];
	}

	/**
	 * 
	 * @param columna
	 * @param fila
	 * @param pieza
	 * @throws JuegoException
	 */
	public void SetEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		if (pieza == null)
			throw new NullPointerException("Pieza null");

		if (HayPieza(columna, fila)) {
			if (GetEscaque(columna, fila).GetColor() != pieza.GetColor()) { // Hay pieza enemiga, comer pieza
				QuitaPieza(columna, fila);
				tablero[columna - 1][fila - 1] = pieza;
			} else { // ya hay una pieza del mismo color
				throw new JuegoException("Ya tienes una pieza en esa posicion");
			}
		} else { // la casilla está libre
			tablero[columna - 1][fila - 1] = pieza;
		}
	}

	/**
	 * 
	 * @param posicion
	 * @param pieza
	 * @throws JuegoException
	 */
	public void SetEscaque(Posicion posicion, Pieza pieza) throws JuegoException {
		if (pieza == null || posicion == null)
			throw new NullPointerException("Pieza y/o posicion null");

		SetEscaque(posicion.GetColumna(), posicion.GetFila(), pieza);
	}

	/**
	 * 
	 * @param columna
	 * @param fila
	 * @return
	 */
	public boolean HayPieza(int columna, int fila) {
		Validacion(columna, fila);

		return tablero[columna - 1][fila - 1] != null;
	}

	/**
	 * 
	 * @param posicion
	 * @return
	 */
	public boolean HayPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

		return HayPieza(posicion.GetColumna(), posicion.GetFila());
	}

	/**
	 * 
	 * @param columna
	 * @param fila
	 */
	public void QuitaPieza(int columna, int fila) {

		if (!HayPieza(columna, fila))
			throw new NullPointerException("El escaque ya estaba vacío.");
		else
			tablero[columna - 1][fila - 1] = null;
	}

	/**
	 * 
	 * @param posicion
	 */
	public void QuitaPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

		QuitaPieza(posicion.GetColumna(), posicion.GetFila());
	}

	/**
	 * 
	 * @param movimiento
	 * @throws JuegoException
	 */
	public void Mover(Movimiento movimiento) throws JuegoException {
		if (movimiento == null)
			throw new NullPointerException("Movimiento null");

		if (tablero[movimiento.GetPosicionInicial().GetColumna()][movimiento.GetPosicionInicial().GetFila()] == null)
			throw new NullPointerException("No hay pieza para mover");

//							posicion								pieza
		SetEscaque(movimiento.GetPosicionFinal(), GetEscaque(movimiento.GetPosicionInicial()));
		QuitaPieza(movimiento.GetPosicionInicial());
	}

	/**
	 * 
	 * @return
	 */
	public Object Clone() {
		Pieza[][] tableroClon = new Pieza[TAMAÑO_FILA][TAMAÑO_COLUMNA];

		for (int i = 0; i < TAMAÑO_COLUMNA; i++)
			for (int j = 0; j < TAMAÑO_FILA; j++) {
				if (tablero[i][j] != null)
					tableroClon[i][j] = tablero[i][j];
			}
		return tableroClon;
//		return tablero.clone();
	}

	/**
	 * 
	 * @param columna
	 * @param fila
	 * @return
	 */
	public Color GetColorEscaque(int columna, int fila) {
		if((columna % 2) == (fila % 2))
			return Color.BLANCO;
		else
			return Color.NEGRO;
	}

	/**
	 * 
	 * @param movimiento
	 * @return
	 * @throws JuegoException
	 */
	public boolean HayPiezasEntre(Movimiento movimiento) throws JuegoException {
		if (movimiento == null)
			throw new NullPointerException("Movimiento null");

		if (!(movimiento.EsHorizontal() || movimiento.EsVertical()
				|| (movimiento.EsDiagonal() && movimiento.SaltoHorizontal() == movimiento.SaltoVertical())))
			throw new JuegoException("El movimiento debe ser horizontal, vertical o diagonal");

		int columnaIni = movimiento.GetPosicionInicial().GetColumna(), filaIni = movimiento.GetPosicionInicial().GetFila(),
			columnaFin = movimiento.GetPosicionFinal().GetColumna(), filaFin = movimiento.GetPosicionFinal().GetFila(),
			siguienteColumna = columnaIni, siguienteFila = filaIni;

		while (columnaFin - 1 != siguienteColumna && filaFin - 1 != siguienteFila) {
			siguienteColumna += movimiento.DeltaColumna();
			siguienteFila += movimiento.DeltaFila();
			if (HayPieza(siguienteColumna, siguienteFila)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param columna
	 * @param fila
	 */
	private void Validacion(int columna, int fila) {
		if (columna < 1 || columna > 8 || fila < 1 || fila > 8)
			throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
	}
}
