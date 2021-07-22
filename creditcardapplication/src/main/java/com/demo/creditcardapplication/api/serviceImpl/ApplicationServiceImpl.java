package com.demo.creditcardapplication.api.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.creditcardapplication.api.service.ApplicationService;
import com.demo.creditcardapplication.api.vo.CreditScore;
import com.demo.creditcardapplication.api.dto.ApplicationDto;
import com.demo.creditcardapplication.api.entity.Application;
import com.demo.creditcardapplication.api.exception.ApplicationNumberNotPresent;
import com.demo.creditcardapplication.api.exception.UserNotEligibleForCreditCard;
import com.demo.creditcardapplication.api.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	ApplicationRepository applicationrepository;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String applyforcreadit(ApplicationDto applicationdto) {
		
		Period diff=Period.between(applicationdto.getDob(), LocalDate.now());
		if(diff.getYears()<18) {
			throw new UserNotEligibleForCreditCard("User is not eligible to apply for credit card.");
		}
		
		Optional<Application> checkPanNumber=applicationrepository.findByPanNumber(applicationdto.getPanNumber());
		if(checkPanNumber.isPresent()) {
			Period diff2=Period.between(checkPanNumber.get().getAppliedDate(), LocalDate.now());
			if(diff2.getMonths()<6) {
				throw new UserNotEligibleForCreditCard("You have already applied within six months. You are not eligible.");
			}
		}
		long creditLimit=50000;
		if(applicationdto.getAnnualSalary()>200000 && applicationdto.getAnnualSalary()<300000) {
			creditLimit=75000;
		}else if(applicationdto.getAnnualSalary()>300000 && applicationdto.getAnnualSalary()<500000) {
			creditLimit=100000;
		}
		Application applyUser=new Application();
		BeanUtils.copyProperties(applicationdto, applyUser);
		applyUser.setCreditLimit(creditLimit);
		//int creditScore=900;
		Boolean checkPan = restTemplate.getForObject("http://localhost:9999/creditscore/checkpan/"+applicationdto.getPanNumber(), Boolean.class);
		Optional<CreditScore> creditScore = Optional.of(restTemplate.getForObject("http://localhost:9999/creditscore/"+applicationdto.getPanNumber(), CreditScore.class));

		if(!checkPan) {
		   throw new UserNotEligibleForCreditCard("Pan Number is not present.");
		}
		
		if(creditScore.get().getCreditScore()<800) {
			applyUser.setStatus("Rejected");
			applicationrepository.save(applyUser);
			throw new UserNotEligibleForCreditCard("Your credit score is less. You are not eligible.");
		}
		
		
		applyUser.setStatus("Approved");
		applicationrepository.save(applyUser);
		
		return "Application is Saved Successfully";
	}

	@Override
	public String getStatus(long applicationNumber) {
		
		Optional<Application> application=applicationrepository.findById(applicationNumber);
		if(!application.isPresent()) {
			throw new ApplicationNumberNotPresent("Application number is not present.");
		}
		return application.get().getStatus();
	}

}
