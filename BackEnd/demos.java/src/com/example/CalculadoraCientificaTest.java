package com.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CalculadoraCientificaTest {

	@Test
	void test() {
		assertEquals(1.5, CalculadoraCientifica.dividir(3.0, 2.0));
	}
	
	@Test
	void test2() {
		assertEquals(0, CalculadoraCientifica.dividir(3.0, 0.0));
	}

}
