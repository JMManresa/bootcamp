package com.capgemini;

public class Posicion {
	private int columna, fila;
	private final int DESPLAZAMIENTO_CHAR = 9;

	public Posicion(int columna, int fila) {
		CreaPosicion(columna, fila);
	}

	public Posicion(char columna, char fila) {
		int numColumna = Character.getNumericValue(columna) - DESPLAZAMIENTO_CHAR,
				numFila = Character.getNumericValue(fila);

		CreaPosicion(numColumna, numFila);
	}

	private void CreaPosicion(int columna, int fila) {
		Validacion(columna, fila);

		this.columna = columna;
		this.fila = fila;
	}

	public int GetColumna() {
		return columna;
	}

	public int GetFila() {
		return fila;
	}

	public boolean Equals(Posicion pos) {
		return (this.GetColumna() == pos.GetColumna() && this.GetFila() == pos.GetFila());
	}

	private void Validacion(int columna, int fila) {
		if (columna < 1 || columna > 8 || fila < 1 || fila > 8)
			throw new IllegalArgumentException("La fila y la columna deben estar entre 0 y 8");
	}
}
