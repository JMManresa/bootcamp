package com.capgemini;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import enums.Comparacion;

public class Principal {

	public static void main(String[] args) {

		Principal p = new Principal();
		// p.Adivina();
		// p.AdivinaConInterfaz();
		// p.IniciarCalculadora();
		// p.CrearBarajaEsp();
		
		//EjercicioFactorial();

	}

	public static void EjercicioFactorial() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		int num = Integer.parseInt(teclado.nextLine());
		System.out.println(num);
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

	public void IniciarCalculadora() {
		Calculadora c = new Calculadora();

		String[] operaciones = c
				.decodificar(JOptionPane.showInputDialog("Introduce la cadena (debe terminar con el simbolo '='): "));
		JOptionPane.showMessageDialog(null, "Resultado: " + c.calcular(operaciones));
	}

	public void CrearBarajaEsp() {
		Baraja barajaEsp = new BarajaEsp();

		System.out.println("Lista de cartas:");
		System.out.println();

		barajaEsp.MostrarBaraja();
		barajaEsp.Barajar();

		System.out.println();
		System.out.println("==== Barajamos ====");
		System.out.println();

		System.out.println("Lista de cartas desordenada:");
		System.out.println();

		barajaEsp.MostrarBaraja();

		System.out.println();
		System.out.println("Retiramos las dos primeras cartas de la baraja: ");
		System.out.println();

		Naipe aux = barajaEsp.Repartir();
		System.out.println(aux.getValor() + " de " + aux.getPalo());

		aux = barajaEsp.Repartir();
		System.out.println(aux.getValor() + " de " + aux.getPalo());
	}
}
