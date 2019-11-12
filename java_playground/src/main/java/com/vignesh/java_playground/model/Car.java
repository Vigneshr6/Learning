package com.vignesh.java_playground.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String maker;
	private String model;
	private String licenseNo;
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinTable(
//			name = "person_cars",
//			inverseJoinColumns = @JoinColumn(name = "person_id"),
//			joinColumns = @JoinColumn(name = "car_id"))
	@JoinColumn(name = "owner_id")
	private Person owner;
	public Car(String maker, String model, String licenseNo, Person owner) {
		super();
		this.maker = maker;
		this.model = model;
		this.licenseNo = licenseNo;
		this.owner = owner;
	}
	public Car() {}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", maker=" + maker + ", model=" + model + ", licenseNo=" + licenseNo + ", owner="
				+ owner + "]";
	}
	
}
