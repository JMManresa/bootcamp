package com.capgemini;

public class Calculadora {

	private double total = 0.0;
	private char pendiente = '+';

	public double calcular(String[] operaciones) {

		for (int i = 0; i < operaciones.length; i++) {
			double operando = Double.parseDouble(operaciones[i].substring(0, operaciones[i].length() - 1));
			char operador = operaciones[i].charAt(operaciones[i].length() - 1);

			switch (pendiente) {
				case '+':
					total += operando;
					break;
	
				case '-':
					total -= operando;
					break;
	
				case '*':
					total *= operando;
					break;
	
				case '/':
					total /= operando;
					break;
				case '=':
					total += operando;

			}
			pendiente = operador;

		}

		return total;
	}

	public String[] decodificar(String cadena) {
		cadena = cadena.replace(",", ".");
		String[] decodificada = cadena.split("(?<=[-+*/()])");
		return decodificada;
	}
}
