package com.demo.creditcardapplication.api.vo;

import com.demo.creditcardapplication.api.entity.Application;

public class ResponseTemplateVO {
	
	private CreditScore creditScore;
	private Application application;
	
	
	public ResponseTemplateVO(CreditScore creditScore, Application application) {
		super();
		this.creditScore = creditScore;
		this.application = application;
	}
	
	
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CreditScore getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(CreditScore creditScore) {
		this.creditScore = creditScore;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	
}
