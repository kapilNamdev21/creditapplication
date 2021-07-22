package com.creditscore.api.service;

import com.creditscore.api.entity.CreditScore;

public interface CreditScoreService {
	
	public CreditScore getCreditScore(String panCard);
	
	public Boolean checkPanCard(String panCard);

}
