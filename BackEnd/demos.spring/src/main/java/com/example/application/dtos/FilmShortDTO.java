package com.example.application.dtos;

import com.example.domains.entities.Film;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FilmShortDTO {
	
	@JsonProperty("id")
	private int filmId;
	
	@JsonProperty("titulo")
	private String title;
	
	public static FilmShortDTO from(Film source) {
		return new FilmShortDTO(
                source.getFilmId(),
                source.getTitle()
                );
	}
	
//	public static Film from(FilmShortDTO source) {
//		return new Film(
//                source.getFilmId(),
//                source.getTitle()
//                );
//	}
}
