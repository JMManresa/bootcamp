package com.capgemini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import enums.Comparacion;

class JuegoDelNumeroTest {
	JuegoDelNumero j;

	@BeforeEach
	void setUp() throws Exception {
		 j = new JuegoDelNumero();
		 j.random = 50;
	}

	@Test
	void testInicializar() {
		j.random = -1;
		j.inicializar();
		assertAll("Inicializar",
				() -> assertEquals(10, j.getIntentos()),
				() -> assertEquals(-1, j.getUltimaJugada()),
				() -> assertTrue(j.getSolucion() >= 0 && j.getSolucion() <= 100, "Rango entre 0 y 100")
				);
	}
	
	@Test
	void testJuegoDelNumero() {
		assertNotNull(new JuegoDelNumero());
	}

	@Nested
	class Jugadas {
		@Test
		void esMayor() {
			Comparacion c = j.jugada(49);
			assertAll("Jugada",
					() -> assertEquals(Comparacion.MAYOR, c),
					() -> assertEquals(9, j.getIntentos())
					);
		}
		
		@Test
		void esMenor() {
			Comparacion c = j.jugada(51);
			assertAll("Jugada",
					() -> assertEquals(Comparacion.MENOR, c),
					() -> assertEquals(9, j.getIntentos())
					);
		}
		
		@Test
		void esIgual() {
			Comparacion c = j.jugada(50);
			assertAll("Jugada",
					() -> assertEquals(Comparacion.IGUAL, c),
					() -> assertEquals(9, j.getIntentos())
					);
		}
		
		@Test
		void mayorQueRango() {
			Comparacion c = j.jugada(101);
			assertAll("Jugada",
					() -> assertEquals(Comparacion.INVALIDA, c),
					() -> assertEquals(10, j.getIntentos())
					);
		}
		
		@Test
		void maxJugadas() {
			Comparacion c;
			for(int i = 0; i < 10; i++) {
				j.jugada(5);
			}
			c = j.jugada(5);
			
			assertAll("Jugada",
					() -> assertEquals(Comparacion.INVALIDA, c),
					() -> assertEquals(0, j.getIntentos())
					);
		}
	}
}
