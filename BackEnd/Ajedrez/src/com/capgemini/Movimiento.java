package com.capgemini;

public class Movimiento {
	private Posicion posIni, posFin;

	public Movimiento(String cadena) throws Exception {
		// TODO
		if(cadena.length() > 4)
			throw new Exception();
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
		return Math.abs(posFin.GetFila() - posIni.GetFila());
	}

	public int SaltoHorizontal() { // cantidad de casillas entre posFin y posIni
		return Math.abs(posFin.GetColumna() - posIni.GetColumna());
	}

	public int DeltaFila() {
		if(posIni.GetFila() < posFin.GetFila())
			return 1;
		else if(posIni.GetFila() > posFin.GetFila())
			return -1;
		else
			return 0;
	}

	public int DeltaColumna() {
		if(posIni.GetColumna() < posFin.GetColumna())
			return 1;
		else if(posIni.GetColumna() > posFin.GetColumna())
			return -1;
		else
			return 0;
	}
	
	public Posicion GetPosicionInicial() {
		return posIni;
	}

	public Posicion GetPosicionFinal() {
		return posFin;
	}
}
