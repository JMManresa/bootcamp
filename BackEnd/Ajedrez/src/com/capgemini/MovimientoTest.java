package com.capgemini;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void constructor() throws JuegoException {
		assertNotNull(new Movimiento("A1A5"));
	}

}
