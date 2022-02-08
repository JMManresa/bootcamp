package com.capgemini;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enums.PalosBarajaEsp;

class BarajaEspTest {
	Baraja baraja;

	@BeforeEach
	void setUp() throws Exception {
		baraja = new BarajaEsp();
	}

	@Test
	void testBarajaEsp() {
		assertNotNull(new BarajaEsp());
	}
	

	@Test
	void testBarajar() {
		ArrayList<Naipe> barajada = new ArrayList<>();
		ArrayList<Naipe> sinBarajar = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			sinBarajar.add(baraja.naipes.get(i));
		}
		
		baraja.Barajar();
		
		for(int i = 0; i < 5; i++) {
			barajada.add(baraja.naipes.get(i));
		}
		
		assertAll("Iguales",
				() -> assertFalse(Baraja.sonIguales(barajada.get(0), sinBarajar.get(0))),
				() -> assertFalse(Baraja.sonIguales(barajada.get(1), sinBarajar.get(1))),
				() -> assertFalse(Baraja.sonIguales(barajada.get(2), sinBarajar.get(2))),
				() -> assertFalse(Baraja.sonIguales(barajada.get(2), sinBarajar.get(3))),
				() -> assertFalse(Baraja.sonIguales(barajada.get(2), sinBarajar.get(4)))
				);
	}
	
	@Test
	void testNumCartas() {
		var numCartasBastos = baraja.naipes.stream().filter(item -> item.getPalo() == PalosBarajaEsp.BASTOS).count();
		var numCartasCopas = baraja.naipes.stream().filter(item -> item.getPalo() == PalosBarajaEsp.COPAS).count();
		var numCartasEspadas = baraja.naipes.stream().filter(item -> item.getPalo() == PalosBarajaEsp.ESPADAS).count();
		var numCartasOros = baraja.naipes.stream().filter(item -> item.getPalo() == PalosBarajaEsp.OROS).count();
		var numTotalCartas = baraja.naipes.stream().count();
		
		assertAll("Cartas por palo",
				() -> assertEquals(12, numCartasBastos),
				() -> assertEquals(12, numCartasCopas),
				() -> assertEquals(12, numCartasEspadas),
				() -> assertEquals(12, numCartasOros),
				() -> assertEquals(48, numTotalCartas)
				);
	}

	@Test
	void testRepartir() {		
		assertAll("Reparto",
				() -> assertThrows(IllegalArgumentException.class, () -> baraja.Repartir(49)),
				() -> assertThrows(IllegalArgumentException.class, () -> baraja.Repartir(0)),
				() -> assertEquals(5, baraja.Repartir(5).size()),
				() -> assertEquals(16, baraja.Repartir(16).size())
				);
	}
	
	@Test
	void testComparar() {
		fail("Not yet implemented");
	}

}
