package com.capgemini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.capgemini.Enum.Color;

class TorreTest {

	Tablero tablero;
	Pieza torre;
	
	@BeforeEach
	void setUp() throws Exception {
		tablero = new Tablero();
		torre = new Torre(Color.BLANCO);
	}

	@Nested
	class Movimientos {
		
		@ParameterizedTest
		@CsvSource(value = {"F2A2", "A1A8", "A1H1", "C4F4"})
		void Validos(String movimiento) throws JuegoException {
//			System.out.println(Character.getNumericValue(movimiento.charAt(0)) - 9);
			assertTrue(torre.EsValido(new Movimiento(movimiento), tablero)); 
			
		}
		
	}
}
