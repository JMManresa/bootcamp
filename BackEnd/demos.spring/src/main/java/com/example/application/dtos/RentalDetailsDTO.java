package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentalDetailsDTO {

	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del alquiler")
	private int rentalId;
	
	@JsonProperty("fechaAlquiler")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha del alquiler")
	private Date rentalDate;
	
	@JsonProperty("idPelicula")
	@NotBlank
	@ApiModelProperty(value = "Nombre de la pelicula")
	private String inventory;
	
	@JsonProperty("cliente")
	@NotBlank
	@ApiModelProperty(value = "Nombre del cliente")
	private String customer;
	
	@JsonProperty("fechaDevolucion")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de la devolucion")
	private Date returnDate;
	
	@JsonProperty("empleado")
	@NotBlank
	@ApiModelProperty(value = "Nombre del empleado")
	private String staff;
	
	@ApiModelProperty(value = "Lista de pagos")
	private List<PaymentDetailsDTO> payments;
	
	public static RentalDetailsDTO from(Rental source) {
		return new RentalDetailsDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getInventory().getFilm().getTitle(),
				source.getCustomer().getFirstName()+ " " +source.getCustomer().getLastName(),
				source.getReturnDate(),
				source.getStaff().getFirstName()+ " " +source.getStaff().getLastName(),
				source.getPayments().stream().map(PaymentDetailsDTO::from).toList()
				);
	}
}
