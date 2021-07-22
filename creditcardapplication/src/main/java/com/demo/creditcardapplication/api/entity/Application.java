package com.demo.creditcardapplication.api.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long applicationNumber;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	private LocalDate dob;
	@NotBlank
	private String panNumber;
	private String mobileNumber;
	private double annualSalary;
	private String status;
	@CreationTimestamp
	private LocalDate appliedDate;
	private long creditLimit;

}
