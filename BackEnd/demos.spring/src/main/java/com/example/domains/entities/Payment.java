package com.example.domains.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;
	
	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private Customer customer;
	
	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="staff_id")
	@JsonIgnore
	private Staff staff;
	
	//bi-directional many-to-one association to Rental
	@ManyToOne
	@JoinColumn(name="rental_id")
	@JsonIgnore
	private Rental rental;
	
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 3, fraction = 2)
	@NotNull
	private BigDecimal amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_date")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date paymentDate;
	
	@Column(name="last_update")
	private Timestamp lastUpdate;

	public Payment() {
	}
	
	

	public Payment(int paymentId, Staff staff, Rental rental,
			@DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 3, fraction = 2) @NotNull BigDecimal amount,
			Date paymentDate) {
		super();
		this.paymentId = paymentId;
		this.staff = staff;
		this.rental = rental;
		if(rental != null) this.customer = rental.getCustomer();
		this.amount = amount;
		this.paymentDate = paymentDate;
	}



	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Rental getRental() {
		return this.rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	

}