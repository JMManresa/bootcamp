package com.example.application.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentalShortDTO {
	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del alquiler")
	private int rentalId;

	@JsonProperty("idPelicula")
	@NotBlank
	@ApiModelProperty(value = "Nombre de la pelicula")
	private String title;

	@JsonProperty("cliente")
	@NotBlank
	@ApiModelProperty(value = "Nombre del cliente")
	private String Customer;

	public static RentalShortDTO from(Rental source) {
		return new RentalShortDTO(
				source.getRentalId(),
				source.getInventory().getFilm().getTitle(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName());
	}
}
