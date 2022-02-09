package com.capgemini;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PosicionTest {
	Posicion posicion, posicion2;

	@Nested
	class Constructores {
		@Test
		void int_int() {
			assertAll("Posiciones validas",
					() -> assertEquals(1, new Posicion(1, 1).GetFila()),
					() -> assertEquals(1, new Posicion(1, 1).GetColumna()),
					() -> assertEquals(8, new Posicion(8, 8).GetFila()),
					() -> assertEquals(8, new Posicion(8, 8).GetColumna()),
					() -> assertEquals(3, new Posicion(3, 5).GetFila()),
					() -> assertEquals(5, new Posicion(3, 5).GetColumna())
					);
		}

		@Test
		void char_char() {
			assertAll("Posiciones validas",
					() -> assertEquals(1, new Posicion('A', '2').GetFila()),
					() -> assertEquals(1, new Posicion('a', '2').GetFila()),
					() -> assertEquals(2, new Posicion('A', '2').GetColumna()),
					() -> assertEquals(8, new Posicion('H', '8').GetFila()),
					() -> assertEquals(3, new Posicion('D', '3').GetColumna())
					);
		}
		
		@Test
		void int_int_Fallo() {
			assertAll("Posiciones invalidas",
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(0, 4)),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(4, 0)),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(9, 6)),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion(5, 9))
					);
		}
		
		@Test
		void char_char_Fallo() {
			assertAll("Posiciones invalidas",
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion('A', '9')),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion('K', '4')),
					() -> assertThrows(IllegalArgumentException.class, () -> new Posicion('K', '0'))
					);
		}
	}
	

	@Test
	void testEquals() {
		posicion = new Posicion(2, 5);
		posicion2 = new Posicion('B', '5');
		
		assertAll("Comparacion",
				() -> assertFalse(posicion.equals(posicion2)),
				() -> assertFalse(posicion2.equals(posicion)),
				() -> assertTrue(posicion.equals(posicion))
				);
	}

}
