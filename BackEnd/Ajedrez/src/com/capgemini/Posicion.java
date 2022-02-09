package com.capgemini;

public class Posicion {
	private int fila, columna;
	private static int DESPLAZAMIENTO_CHAR = 9;

	public Posicion(int fila, int columna) {
		CreaPosicion(fila, columna);
	}

	public Posicion(char fila, char columna) {
		int numFila = Character.getNumericValue(fila) - DESPLAZAMIENTO_CHAR,
			numColumna = Character.getNumericValue(columna);

		CreaPosicion(numFila, numColumna);
	}

	private void CreaPosicion(int fila, int columna) {
		if (!Validacion(fila, columna))
			throw new IllegalArgumentException("La fila y la columna deben ser valores entre 1 y 8");

		this.fila = fila;
		this.columna = columna;
	}

	public int GetFila() {
		return fila;
	}

	public int GetColumna() {
		return columna;
	}

	public boolean Equals(Posicion pos) {
		return this == pos;
	}

	private boolean Validacion(int fila, int columna) {
		return (fila >= 1 && fila <= 8 && columna >= 1 && columna <= 8);
	}
}
