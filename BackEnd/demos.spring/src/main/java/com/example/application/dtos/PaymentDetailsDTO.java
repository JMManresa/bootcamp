package com.example.application.dtos;

import java.math.BigDecimal;

import java.util.Date;

import com.example.domains.entities.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Value;

@Value
public class PaymentDetailsDTO {


	private int paymentId;
	private String staff;
	private BigDecimal amount;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date paymentDate;
	
	public static PaymentDetailsDTO from(Payment source) {
		return new PaymentDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName()+ " " +source.getStaff().getLastName(),
				source.getAmount(),
				source.getPaymentDate()
				);
	}
}
