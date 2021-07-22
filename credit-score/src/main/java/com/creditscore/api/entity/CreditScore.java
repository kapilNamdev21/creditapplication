package com.creditscore.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditScore {
	@Id
	private String panNumber;

	private Long creditScore;

	public CreditScore(String panNumber, Long creditScore) {
		super();
		this.panNumber = panNumber;
		this.creditScore = creditScore;
	}

	public CreditScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Long getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Long creditScore) {
		this.creditScore = creditScore;
	}
}
