/**
 * 
 */
package com.example;

/**
 * @author jmanresa
 *
 */
public class Principal {

	public static void main(String[] args) {
		String s = "Hola";
		s += " mundo";
		System.out.println(s);
		
		
		Calculadora c = new Calculadora();
		
		System.out.println(c.media());
		System.out.println(c.media(3));
		System.out.println(c.media(8, 2));
		System.out.println(c.media(3, 2));
		
		CalculadoraCientifica cc = new CalculadoraCientifica();
		
		System.out.println(cc.dividir(3.1, 5));
		System.out.println(cc.suma(2, 2));
		
	}

}
