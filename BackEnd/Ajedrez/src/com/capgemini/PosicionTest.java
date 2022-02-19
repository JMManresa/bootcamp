package com.capgemini;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


//CSV parametrizado o algo asi para no abusar del assertAll

class PosicionTest {
	Posicion posicion, posicion2, posicion3;

	@Nested
	class ConstructoresYGetters {
		
		@ParameterizedTest
		@CsvSource(value = {"3,1,1", "5,8,8", "3,5,5"})
		void int_int_getFila(int columna, int fila, int resultado) {
			assertEquals(resultado, new Posicion(columna, fila).GetFila());
		}
		
		@ParameterizedTest
		@CsvSource(value = {"3,1,3", "5,8,5", "3,5,3"})
		void int_int_getColumna(int columna, int fila, int resultado) {
			assertEquals(resultado, new Posicion(columna, fila).GetColumna());
		}

		@ParameterizedTest
		@CsvSource(value = {"A,2,2", "D,3,3", "F,1,1"})
		void char_char_getFila(char columna, char fila, int resultado) {
			assertEquals(resultado, new Posicion(columna, fila).GetFila());
		}
		
		@ParameterizedTest
		@CsvSource(value = {"A,2,1", "a,2,1", "H,7,8"})
		void char_char_getColumna(char columna, char fila, int resultado) {
			assertEquals(resultado, new Posicion(columna, fila).GetColumna());
		}
		
		@ParameterizedTest
		@CsvSource(value = {"0,4", "4,0", "9,6", "5,9"})
		void Fallo_int_int(int columna, int fila) { 
			assertThrows(IllegalArgumentException.class, () -> new Posicion(columna, fila));
		}
		
		@ParameterizedTest
		@CsvSource(value = {"A,9", "K,4", "K,0"})
		void Fallo_char_char(char columna, char fila) {
			assertThrows(IllegalArgumentException.class, () -> new Posicion(columna, fila));
		}
	}
	

	@Test
	void testEquals() {
		posicion = new Posicion(2, 5);
		posicion2 = new Posicion('B', '5');
		posicion3 = new Posicion(4,1);
		
		assertAll("Comparacion",
				() -> assertTrue(posicion.Equals(posicion2)),
				() -> assertTrue(posicion2.Equals(posicion)),
				() -> assertFalse(posicion3.Equals(posicion)),
				() -> assertFalse(posicion2.Equals(posicion3))
				);
	}

}
