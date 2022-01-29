package com.capgemini;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import enums.Comparacion;

public class EjerciciosJava {

	public static void main(String[] args) {

		EjerciciosJava e = new EjerciciosJava();
		// e.Adivina();
		e.AdivinaConInterfaz();
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

		JOptionPane.showMessageDialog(null, "Bienvenido, pulsa OK para comenzar");

		out: while (j.getIntentos() > 0) {
			mensaje = j.getUltimaJugada() < 0 ? "Introduce un numero entre 0 y 100: "
					: "Tu ultima jugada fue " + j.getUltimaJugada() + " y te quedan " + j.getIntentos()+ " intentos. Introduce un numero entre 0 y 100: ";

			numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje)); // esta linea da error si se pincha en
																				// Cancelar
			Comparacion c = j.jugada(numero);

			switch (c) {
			case INVALIDA:
				JOptionPane.showMessageDialog(null, "El numero introducido no es valido");
				break;

			case MAYOR:
				JOptionPane.showMessageDialog(null, "Prueba con un numero MAYOR");
				break;

			case MENOR:
				JOptionPane.showMessageDialog(null, "Prueba con un numero MENOR");
				break;

			case IGUAL:
				JOptionPane.showMessageDialog(null, "¡Has acertado! El numero secreto es: " + j.getSolucion());
				break out;
			}
			JOptionPane.showMessageDialog(null, "Te quedan " + j.getIntentos() + " intentos");
		}
	}
}
