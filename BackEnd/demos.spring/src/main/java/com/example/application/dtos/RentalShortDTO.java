package com.example.application.dtos;

import java.util.Date;

import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentalShortDTO {
	@JsonProperty("id")
	private int rentalId;

	@JsonProperty("fecha")
	private Date rentalDate;

	@JsonProperty("cliente")
	private String Customer;

	public static RentalShortDTO from(Rental source) {
		return new RentalShortDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName());
	}
}
