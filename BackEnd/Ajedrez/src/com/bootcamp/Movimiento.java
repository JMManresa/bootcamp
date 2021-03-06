package com.capgemini;

public class Movimiento {
	private Posicion posIni, posFin;

	public Movimiento(String NotacionInternacional) throws JuegoException {
		if (NotacionInternacional == null || NotacionInternacional.length() > 4)
			throw new IllegalArgumentException("La cadena debe tener 4 d?gitos");

		char columnaIni = NotacionInternacional.charAt(0), columnaFin = NotacionInternacional.charAt(2),
				filaIni = NotacionInternacional.charAt(1), filaFin = NotacionInternacional.charAt(3);

		Posicion auxIni = new Posicion(columnaIni, filaIni);
		Posicion auxFin = new Posicion(columnaFin, filaFin);
		
		if(auxIni.Equals(auxFin))
			throw new JuegoException("La posicion inicial es igual a la final. No hay movimiento.");
		else {
			posIni = auxIni;
			posFin = auxFin;
		}
	}

	public boolean EsVertical() {
		return (posIni.GetColumna() == posFin.GetColumna());
	}

	public boolean EsHorizontal() {
		return (posIni.GetFila() == posFin.GetFila());
	}

	public boolean EsDiagonal() {
		return SaltoHorizontal() == SaltoVertical();
		//return ((posIni.GetFila() != posFin.GetFila()) && (posIni.GetColumna() != posFin.GetColumna()));
	}

	public int SaltoVertical() { // cantidad de filas entre posFin y posIni
		return Math.abs(posFin.GetFila() - posIni.GetFila());
	}

	public int SaltoHorizontal() { // cantidad de casillas entre posFin y posIni
		return Math.abs(posFin.GetColumna() - posIni.GetColumna());
	}

	public int DeltaFila() {
		if (posIni.GetFila() < posFin.GetFila())
			return 1;
		else if (posIni.GetFila() > posFin.GetFila())
			return -1;
		else
			return 0;
	}

	public int DeltaColumna() {
		if (posIni.GetColumna() < posFin.GetColumna())
			return 1;
		else if (posIni.GetColumna() > posFin.GetColumna())
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
