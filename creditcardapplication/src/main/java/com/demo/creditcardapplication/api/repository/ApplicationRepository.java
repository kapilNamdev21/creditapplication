package com.demo.creditcardapplication.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.creditcardapplication.api.entity.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	Optional<Application> findByPanNumber(String panNumber);

}
