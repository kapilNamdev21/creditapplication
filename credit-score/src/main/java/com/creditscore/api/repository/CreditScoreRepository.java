package com.creditscore.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditscore.api.entity.CreditScore;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, String> {

	Optional<CreditScore> findByPanNumber(String panCard);

	

}
