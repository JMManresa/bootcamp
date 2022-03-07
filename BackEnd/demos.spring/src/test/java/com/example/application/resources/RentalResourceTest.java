package com.example.application.resources;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import com.example.application.dtos.RentalDetailsDTO;
import com.example.application.dtos.RentalShortDTO;
import com.example.domains.contracts.services.RentalService;
import com.example.domains.entities.Rental;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@SpringBootTest
//@AutoConfigureMockMvc
class RentalResourceTest {
	List<RentalShortDTO> listado;
	List<Rental> listadoDetails;

	@BeforeEach
	void setUp() throws Exception {
		listado = new ArrayList<>();
		listado.add(new RentalShortDTO(1, "el planeta de los simios", "manolo"));
		listado.add(new RentalShortDTO(2, "harry potter", "lucia"));
		
		listadoDetails = new ArrayList<>();
		listadoDetails.add(new Rental());
	}

	public static class IoCTestConfig {
		@Bean
		RentalService getServicio() {
			return mock(RentalService.class);
		}
		@Bean
		RentalResource getRest() {
			return new RentalResource();
		}
	}

	@Nested
	//@ContextConfiguration(classes = IoCTestConfig.class)
	@MockBean(RentalService.class)
	class PruebasUnitarias {
		@Autowired
		RentalService srv;
		
		@Autowired
		RentalResource rest;
		
		@Test
		void testMock() {
			assertNotNull(srv);
			assertNotNull(rest);
		}
		@Test
		void testGetAll() {
			when(srv.getByProjection(RentalShortDTO.class)).thenReturn(listado);

			var rslt = rest.getAll();

			assertNotNull(rslt);
			assertEquals(2, rslt.size());
		}

//		@Test
//		void testGetOne() throws NotFoundException {
//			when(srv.getOne(1)).thenReturn(RentalDetailsDTO.from(listadoDetails.get(0)));
//
//			var rslt = rest.getOne(1);
//			assertNotNull(rslt);
//			assertEquals(1, rslt.getRentalId());
//		}
//
//		@Test
//		void testGetOneNotFound() throws NotFoundException {
//			when(srv.getOne(1)).thenThrow(NotFoundException.class);
//			
//			assertThrows(NotFoundException.class, () -> rest.getOne(1));
//		}
//
//		@Test
//		void testCreate() throws NotFoundException, DuplicateKeyException, InvalidDataException {
//			when(srv.add(any())).thenReturn(RentalDTO.from(listado.get(0)));
//
//			var rslt = rest.create(listado.get(0));
//			assertNotNull(rslt);
//			assertEquals(HttpStatus.CREATED, rslt.getStatusCode());
//		}
//		@Test
//		void testCreateDuplicateKey() throws NotFoundException, DuplicateKeyException, InvalidDataException {
//			when(srv.add(any())).thenThrow(DuplicateKeyException.class);
//			
//			assertThrows(DuplicateKeyException.class, () -> rest.create(listado.get(0)));
//		}
//		@Test
//		void testCreateInvalidData() throws NotFoundException, DuplicateKeyException, InvalidDataException {
//			when(srv.add(any())).thenThrow(InvalidDataException.class);
//			
//			assertThrows(InvalidDataException.class, () -> rest.create(listado.get(0)));
//		}

//		@Test
//		void testUpdate() throws NotFoundException, InvalidDataException {
//			when(srv.change(any())).thenReturn(RentalDTO.from(listado.get(0)));
//
//			rest.update(1, listado.get(0));
//			verify(srv).change(RentalDTO.from(listado.get(0)));
//		}

//		@Test
//		void testUpdateInvalidId() throws NotFoundException, InvalidDataException {
//			assertThrows(InvalidDataException.class, () -> rest.update(0, listado.get(0)));
//		}
//		@Test
//		void testUpdateNotFound() throws NotFoundException, InvalidDataException {
//			when(srv.change(any())).thenThrow(NotFoundException.class);
//
//			assertThrows(NotFoundException.class, () -> rest.update(1, listado.get(0)));
//		}
//		@Test
//		void testUpdateInvalidData() throws NotFoundException, InvalidDataException {
//			assertThrows(InvalidDataException.class, () -> rest.update(1, new RentalDTO()));
//		}

		@Test
		void testDelete() throws NotFoundException, InvalidDataException {
			doNothing().when(srv).deleteById(any());

			rest.delete(1);
			verify(srv).deleteById(1);
		}
	}
}
