package org.acme.example;

import java.util.Objects;

import org.acme.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Laptop extends BaseEntity {

	@NotNull
	@NotBlank
	@Size(min = 2, max = 20)
	private String company;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 50)
	private String model;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 20)
	private String manufacturer;
	
	@Min(10)
	private double price;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(company, manufacturer);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Objects.equals(company, other.company) && Objects.equals(manufacturer, other.manufacturer)
				&& super.equals(obj);
	}
}
