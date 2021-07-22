package com.creditscore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.creditscore.api.entity.CreditScore;
import com.creditscore.api.service.CreditScoreService;


@RestController
public class CreditScoreController {
	@Autowired
	CreditScoreService creditScoreService;
	
	@GetMapping("/creditscore/{panCard}")
	private CreditScore getCreditScore(@PathVariable("panCard") String panCard) {
		return creditScoreService.getCreditScore(panCard);	
	}
	
	@GetMapping("/creditscore/checkpan/{panCard}")
	public Boolean checkPanCard(@PathVariable("panCard") String panCard){
	   return creditScoreService.checkPanCard(panCard);
	}
}
