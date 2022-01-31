package com.capgemini;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import enums.Comparacion;

public class EjerciciosJava {

	public static void main(String[] args) {

		EjerciciosJava e = new EjerciciosJava();
		// e.Adivina();
		// e.AdivinaConInterfaz();
		e.Decodificar();

	}

	public void Adivina() {

		int random = new Random().nextInt(101);
		int intentos = 10;
		Scanner teclado = new Scanner(System.in);

		String cad;
		int num;

		do {
			System.out.print("¿En qué número estoy pensando?: ");
			cad = teclado.nextLine();
			num = Integer.parseInt(cad);

			intentos--;

			if (num < random)
				System.out.println("Mi numero es mayor, tienes " + intentos + " intentos");
			else if (num > random)
				System.out.println("Mi numero es menor, tienes " + intentos + " intentos");
			else {
				System.out.println("Correcto!");
				break;
			}

		} while (intentos > 0);

		teclado.close();
		System.out.println("Fin del juego.");
	}

	public void AdivinaConInterfaz() {
		JuegoDelNumero j = new JuegoDelNumero();
		
		System.out.println("Solucion: " + j.getSolucion());
		int numero;
		String mensaje;
		Comparacion comparacion = null;

		JOptionPane.showMessageDialog(null, "Bienvenido, pulsa OK para comenzar");

		out: while (j.getIntentos() > 0) {
			// Si ultimaJugada < 0 significa que es la primera jugada
			mensaje = j.getUltimaJugada() < 0 ? "Introduce un numero entre 0 y 100: "
					: "Tu ultima jugada fue " + j.getUltimaJugada() + " y el numero es " + comparacion
							+ "\n Intentos restantes: " + j.getIntentos() + "\n Introduce un numero entre 0 y 100: ";

			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje)); // esta linea da error si se pincha en
																				// Cancelar

			comparacion = j.jugada(numero);

			switch (comparacion) {
			case INVALIDA:
				JOptionPane.showMessageDialog(null, "El numero introducido no es valido");
				break;

			case MAYOR:

			case MENOR:
				JOptionPane.showMessageDialog(null, "Incorrecto");
				break;

			case IGUAL:
				JOptionPane.showMessageDialog(null, "¡Has acertado! El numero secreto es: " + j.getSolucion());
				break out;
			}
		}
	}

	public void Decodificar() {
		String cadenaInicial = JOptionPane.showInputDialog("Introduce la cadena: ");
		//String cadenaInicial = "3+4+3,4-7*1=";
		cadenaInicial = cadenaInicial.replace(",", ".");
		String[] separado = cadenaInicial.split("(?<=[-+*/()])");
		
		Calculadora c = new Calculadora();
		double resultado = 0;
		
		for(int i = 0; i < separado.length; i++)
		{
			double operando = Double.parseDouble(separado[i].substring(0, separado[i].length() - 1));
			char operador = separado[i].charAt(separado[i].length() - 1);
			
			resultado = c.calcular(operando, operador);
		}
		System.out.println(resultado);
	}
}
