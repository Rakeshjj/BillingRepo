package com.billing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "billing_model", uniqueConstraints = @UniqueConstraint(columnNames = { "product_name" }))
public class BillingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input: Product name only accept charcters")
	private String product_name;

	@Min(1)
	private int quantity;

	@NotNull
	@Min(1)
	private int mrp;

	@NotNull
	@Min(1)
	private int gst;

	public BillingModel() {
		super();
	}

	public BillingModel(long id, @NotBlank String product_name, @Min(1) int quantity, @NotNull @Min(1) int mrp,
			@NotNull @Min(1) int gst) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.mrp = mrp;
		this.gst = gst;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	@Override
	public String toString() {
		return "BillingModel [id=" + id + ", product_name=" + product_name + ", quantity=" + quantity + ", mrp=" + mrp
				+ ", gst=" + gst + "]";
	}

}
