package com.demo.creditcardapplication.api.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ApplicationDto {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	private LocalDate dob;
	@NotBlank
	private String panNumber;
	private String mobileNumber;
	@NotBlank
	private double annualSalary;

}
