package com.capgemini;

public class Movimiento {
	private Posicion posIni, posFin;

	public Movimiento(String cadena) {
		// TODO
	}

	public Posicion GetPosicionInicial() {
		return posIni;
	}

	public Posicion GetPosicionFinal() {
		return posFin;
	}

	public boolean EsVertical() {
		return (posIni.GetColumna() == posFin.GetColumna());
	}

	public boolean EsHorizontal() {
		return (posIni.GetFila() == posFin.GetFila());
	}

	public boolean EsDiagonal() {
		return ((posIni.GetFila() != posFin.GetFila()) && (posIni.GetColumna() != posFin.GetColumna()));
	}

	public int SaltoVertical() { // cantidad de filas entre posFin y posIni
		return posFin.GetFila() - posIni.GetFila();
	}

	public int SaltoHorizontal() { // cantidad de casillas entre posFin y posIni
		return posFin.GetColumna() - posIni.GetColumna();
	}

	public int DeltaFila() { // lo que hay que sumar o restar para llegar a la posicion
		//TODO
		return 0;
	}

	public int DeltaColumna() {
		// TODO
		return 0;
	}
}
