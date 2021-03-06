package com.capgemini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
		for (int i = 0; i < decodificada.length; i++) {
			System.out.println(decodificada[i]);
		}
		return decodificada;
	}

	public String ObtenerCalculo() throws Exception {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea = null;

		try {
			archivo = new File("C:\\Repositorio Bootcamp\\BackEnd\\Ejercicios\\calcular.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			linea = br.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return linea;
	}
	
	public void EscribeResultado() {
		
	}
}
