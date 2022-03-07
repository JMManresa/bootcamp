package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentalEditDTO {

	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del alquiler")
	private int rentalId;
	
	@JsonProperty("fechaAlquiler")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha del alquiler")
	private Date rentalDate;
	
	@JsonProperty("idPelicula")
	@Positive
	@ApiModelProperty(value = "Identificador de la pelicula")
	private int inventory;
	
	@JsonProperty("idCliente")
	@Positive
	@ApiModelProperty(value = "Identificador del cliente")
	private int customer;
	
	@JsonProperty("fechaDevolucion")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty(value = "Fecha de la devolucion")
	private Date returnDate;
	
	@JsonProperty("idEmpleado")
	@Positive
	@ApiModelProperty(value = "Identificador del empleado")
	private int staff;
	
	@ApiModelProperty(value = "Lista de pagos")
	private List<PaymentEditDTO> payments;
	
	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(),
				source.getRentalDate() == null ? null: source.getRentalDate(),
				source.getInventory().getInventoryId(),
				source.getCustomer().getCustomerId(),
				source.getReturnDate(),
				source.getStaff().getStaffId(),
				source.getPayments().stream().map(PaymentEditDTO::from).toList()
				);
	}
	
	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				new Inventory (source.getInventory()),
				new Customer (source.getCustomer()),
				source.getReturnDate(),
				new Staff (source.getStaff())
				);
	}
	
	
	public Rental update(Rental target) {
		target.setRentalDate(rentalDate);
		target.setReturnDate(returnDate);
		target.setCustomer(new Customer(customer));
		target.setInventory(new Inventory(inventory));
		target.setStaff(new Staff(staff));
		
		//Borra alquileres que sobran
		var deleteAlquiladas = target.getPayments().stream()
				.filter(item -> payments.stream().noneMatch(pago -> pago.getPaymentId() == item.getPaymentId()))
				.toList();
		deleteAlquiladas.forEach(item -> target.removePayment(item));
		
		//Modifico los que han quedado
		target.getPayments().forEach(item -> {
			var nuevoPago = payments.stream().filter(pago -> pago.getPaymentId() == item.getPaymentId()).findFirst().get();
			if(item.getAmount() != nuevoPago.getAmount()) {
				item.setAmount(nuevoPago.getAmount());
			}
			if(item.getPaymentDate() != nuevoPago.getPaymentDate()) {
				item.setPaymentDate(nuevoPago.getPaymentDate());
			}
			if(item.getStaff().getStaffId() != nuevoPago.getStaff()) { 
				item.setStaff(new Staff(nuevoPago.getStaff()));
			}
		});
		
		//Añado los que faltan
		payments.stream()
		.filter(dto -> target.getPayments().stream().noneMatch(entity -> entity.getPaymentId() == dto.getPaymentId()))
		.forEach(dto -> target.addPayment(PaymentEditDTO.from(dto, target)));

		return target;
	}
}
