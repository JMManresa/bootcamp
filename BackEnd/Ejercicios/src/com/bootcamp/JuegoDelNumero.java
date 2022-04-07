package com.capgemini;

import java.util.Random;

import enums.Comparacion;

public class JuegoDelNumero {

	int intentos, ultimaJugada, random;

	public JuegoDelNumero() {
		inicializar();
	}

	public void inicializar() {
		intentos = 10;
		ultimaJugada = -1;
		random = new Random().nextInt(101);
	}

	/**
	 * 
	 * @param num --> Numero que introduce el usuario
	 * @return --> El metodo devuelve un Enum en funcion del resultado
	 * de la jugada para dar informacion al usuario
	 * 
	 */
	public Comparacion jugada(int num) {
		if (intentos <= 0 || num < 0 || num > 100)
			return Comparacion.INVALIDA;

		intentos--;
		ultimaJugada = num;
		if (num < random)
			return Comparacion.MAYOR;
		else if (num > random)
			return Comparacion.MENOR;
		else
			return Comparacion.IGUAL;
	}
	
	public int getIntentos() {
		return intentos;
	}

	public int getUltimaJugada() {
		return ultimaJugada;
	}

	public int getSolucion() {
		return random;
	}
}
