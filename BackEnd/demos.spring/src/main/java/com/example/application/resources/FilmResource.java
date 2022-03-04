package com.example.application.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.dtos.FilmShortDTO;
import com.example.domains.contracts.services.FilmService;
import com.example.domains.entities.Film;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@RestController
@RequestMapping("/api/peliculas")
public class FilmResource {
	@Autowired
	private FilmService srv;

	@GetMapping
	public List<FilmShortDTO> getAll() {
		return srv.getByProjection(FilmShortDTO.class);
	}
	
	@GetMapping(params = "page")
	public Page<FilmShortDTO> getAll(Pageable page) {
		return srv.getByProjection(page, FilmShortDTO.class);
	}

	@GetMapping(path = "/{id}")
	//aqui iria un FilmDetailsDTO con todos los datos de la peli
	public FilmShortDTO getOne(@PathVariable int id) throws NotFoundException {
		return FilmShortDTO.from(srv.getOne(id));
	}

//	@PostMapping
//	public ResponseEntity<Object> create(@Valid @RequestBody FilmShortDTO item)
//			throws InvalidDataException, DuplicateKeyException {
//		Film entity = FilmShortDTO.from(item);
//		if (entity.isInvalid())
//			throw new InvalidDataException(entity.getErrorsMessage());
//		entity = srv.add(entity);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(entity.getFilmId()).toUri();
//		return ResponseEntity.created(location).build();
//	}
//
//	@PutMapping("/{id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public void update(@PathVariable int id, @Valid @RequestBody FilmShortDTO item)
//			throws InvalidDataException, NotFoundException {
//		if (id != item.getFilmId())
//			throw new InvalidDataException("No coinciden los identificadore");
//		Film entity = FilmShortDTO.from(item);
//		if (entity.isInvalid())
//			throw new InvalidDataException(entity.getErrorsMessage());
//		srv.change(entity);
//	}
//
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable int id) {
//		srv.deleteById(id);
//	}
}
