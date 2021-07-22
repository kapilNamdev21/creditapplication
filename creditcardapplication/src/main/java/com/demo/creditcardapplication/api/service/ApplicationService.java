package com.demo.creditcardapplication.api.service;

import com.demo.creditcardapplication.api.dto.ApplicationDto;

public interface ApplicationService {

	String applyforcreadit(ApplicationDto applicationdto);

	String getStatus(long applicationNumber);

}
