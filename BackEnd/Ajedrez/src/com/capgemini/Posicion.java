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
		Validacion(fila, columna);

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
		return (this.GetFila() == pos.GetFila() && this.GetColumna() == pos.GetColumna());
	}

	private void Validacion(int fila, int columna) {
		if (fila < 1 || fila > 8 || columna < 1 || columna > 8)
			throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
	}
}
