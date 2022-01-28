package com.capgemini;

import java.util.Random;
import java.util.Scanner;

public class EjerciciosJava {

	public static void main(String[] args) {
		EjerciciosJava e = new EjerciciosJava();
		//e.Adivina();
		e.Decodificar();
	}
	
	public void Adivina()
	{
		/*
		 * Juego de “Adivina el número que estoy pensando”, un número del 0 al 100, ya
		 * te diré si es mayor o menor que el mío, pero tienes 10 intentos como mucho.
		 */

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
	
	public void Decodificar() {
		//System.out.println("Introduce el string que quieras decodificar: ");
		String s = "  3+4+3,4-7*1=";
		String[] separado = s.split("");
		
		for(int i = 0; i < separado.length; System.out.println(separado[i++]));
	}
}
