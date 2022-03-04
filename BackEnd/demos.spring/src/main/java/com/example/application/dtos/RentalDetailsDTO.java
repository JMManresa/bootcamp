package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentalDetailsDTO {

	private int rentalId;
	private Date rentalDate;
	private String inventory;
	private String customer;
	private Date returnDate;
	private String staff;
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
