package com.example.application.resources;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.application.dtos.LanguageDTO;
import com.example.domains.contracts.services.LanguageService;
import com.example.domains.entities.Language;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/idiomas")
public class LanguageResource {
    @Autowired
    private LanguageService srv;
    @GetMapping
    public List<LanguageDTO> getAll() {
        return srv.getByProjection(LanguageDTO.class);
    }
    @GetMapping(path = "/{id}")
    public LanguageDTO getOne(@PathVariable int id) throws NotFoundException {
        return LanguageDTO.from(srv.getOne(id));
    }
    
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody LanguageDTO item) throws InvalidDataException, DuplicateKeyException {
        Language entity = LanguageDTO.from(item);
        if(entity.isInvalid())
            throw new InvalidDataException(entity.getErrorsMessage());
        entity = srv.add(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(entity.getLanguageId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable int id, @Valid @RequestBody LanguageDTO item) throws InvalidDataException, NotFoundException {
        if(id != item.getLanguageId())
            throw new InvalidDataException("No coinciden los identificadore");
        Language entity = LanguageDTO.from(item);
        if(entity.isInvalid())
            throw new InvalidDataException(entity.getErrorsMessage());
        srv.change(entity);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        srv.deleteById(id);
    }
}