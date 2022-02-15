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
	 * @param columna Valor entero entre 1 y 8.
	 * @param fila Valor entero entre 1 y 8.
	 * @return Devuelve la pieza en la posición indicada si la hubiera.
	 * @throws JuegoException Si no hay pieza en la posición indicada.
	 */
	public Pieza GetEscaque(int columna, int fila) throws JuegoException {
		
		Posicion posicion = new Posicion(columna, fila);
		return GetEscaque(posicion);
	}

	/**
	 * 
	 * @param posicion Objeto de tipo Posicion.
	 * @return Devuelve la pieza en la posición indicada si la hubiera.
	 * @throws JuegoException Si no hay pieza en la posición indicada.
	 */
	public Pieza GetEscaque(Posicion posicion) throws JuegoException {
		if (posicion == null)
			throw new IllegalArgumentException("La posicion es null o no hay pieza en esa posicion");
		
		if(!HayPieza(posicion))
			throw new JuegoException("No hay pieza en este escaque.");

		int columna = posicion.GetColumna(), fila = posicion.GetFila();
		return tablero[columna - 1][fila - 1];
	}

	/**
	 * 
	 * @param columna Valor entero entre 1 y 8.
	 * @param fila Valor entero entre 1 y 8.
	 * @param pieza Objeto de tipo Pieza.
	 * @throws JuegoException Si se intenta colocar una pieza en el lugar donde ya hay otra del mismo color.
	 */
	public void SetEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		if (pieza == null)
			throw new IllegalArgumentException("Pieza null");

			tablero[columna - 1][fila - 1] = pieza;
	}

	/**
	 * 
	 * @param posicion Objeto de tipo Posicion.
	 * @param pieza Objeto de tipo Pieza.
	 * @throws JuegoException Si se intenta colocar una pieza en el lugar donde ya hay otra del mismo color.
	 */
	public void SetEscaque(Posicion posicion, Pieza pieza) throws JuegoException {
		if (pieza == null || posicion == null)
			throw new IllegalArgumentException("Pieza y/o posicion null");

		SetEscaque(posicion.GetColumna(), posicion.GetFila(), pieza);
	}

	/**
	 * 
	 * @param columna Valor entero entre 1 y 8.
	 * @param fila Valor entero entre 1 y 8.
	 * @return True si hay pieza en la posicion indicada, false en caso contrario.
	 */
	public boolean HayPieza(int columna, int fila) {
		Validacion(columna, fila);

		return tablero[columna - 1][fila - 1] != null;
	}

	/**
	 * 
	 * @param posicion Objeto de tipo Posicion.
	 * @return True si hay pieza en la posicion indicada, false en caso contrario.
	 */
	public boolean HayPieza(Posicion posicion) {
		if (posicion == null)
			throw new IllegalArgumentException("Posicion null");

		return HayPieza(posicion.GetColumna(), posicion.GetFila());
	}

	/**
	 * 
	 * @param columna Valor entero entre 1 y 8.
	 * @param fila Valor entero entre 1 y 8.
	 */
	public void QuitaPieza(int columna, int fila) {

		if (!HayPieza(columna, fila))
			throw new IllegalArgumentException("El escaque ya estaba vacío.");
		else
			tablero[columna - 1][fila - 1] = null;
	}

	/**
	 * 
	 * @param posicion Objeto de tipo Posicion.
	 */
	public void QuitaPieza(Posicion posicion) {
		if (posicion == null)
			throw new IllegalArgumentException("Posicion null");

		QuitaPieza(posicion.GetColumna(), posicion.GetFila());
	}

	/**
	 * 
	 * @param movimiento Objeto de tipo Movimiento.
	 * @throws JuegoException Si no hay una pieza que mover para ese movimiento o si es propagada por el método SetEscaque.
	 */
	public void Mover(Movimiento movimiento) throws JuegoException {
		if (movimiento == null)
			throw new IllegalArgumentException("Movimiento null");

		if (tablero[movimiento.GetPosicionInicial().GetColumna()][movimiento.GetPosicionInicial().GetFila()] == null)
			throw new JuegoException("No hay pieza para mover");

//							posicion								pieza
		SetEscaque(movimiento.GetPosicionFinal(), GetEscaque(movimiento.GetPosicionInicial()));
		QuitaPieza(movimiento.GetPosicionInicial());
	}

	/**
	 * 
	 * @return Devuelve una copia del tablero.
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
	 * @param columna Valor entero entre 1 y 8.
	 * @param fila Valor entero entre 1 y 8.
	 * @return Devuelve el color del escaque indicado.
	 */
	public Color GetColorEscaque(int columna, int fila) {
		if((columna % 2) == (fila % 2))
			return Color.BLANCO;
		else
			return Color.NEGRO;
	}

	/**
	 * 
	 * @param movimiento Objeto de tipo Movimiento.
	 * @return Verdadero si hay una pieza entre la casilla inicial y la final del movimiento excluyendo a ambas, falso en caso contrario.
	 * @throws JuegoException Si el movimiento no es vertical, horizontal o diagonal.
	 */
	public boolean HayPiezasEntre(Movimiento movimiento) throws JuegoException {
		if (movimiento == null)
			throw new IllegalArgumentException("Movimiento null");

		if (!(movimiento.EsHorizontal() || movimiento.EsVertical()
				|| (movimiento.EsDiagonal() && movimiento.SaltoHorizontal() == movimiento.SaltoVertical())))
			throw new JuegoException("El movimiento debe ser horizontal, vertical o diagonal");

		int columnaIni = movimiento.GetPosicionInicial().GetColumna(), filaIni = movimiento.GetPosicionInicial().GetFila(),
			columnaFin = movimiento.GetPosicionFinal().GetColumna(), filaFin = movimiento.GetPosicionFinal().GetFila(),
			siguienteColumna = columnaIni, siguienteFila = filaIni;

		while (columnaFin - 1 != siguienteColumna && filaFin - 1 != siguienteFila) { //los -1 son para no incluir la ultima posicion
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
	 * @param columna Valor entero entre 1 y 8.
	 * @param fila Valor entero entre 1 y 8.
	 */
	private void Validacion(int columna, int fila) {
		if (columna < 1 || columna > 8 || fila < 1 || fila > 8)
			throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
	}
}
