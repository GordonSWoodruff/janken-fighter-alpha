package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.SurpriseMove;

@Repository
public interface SurpriseMoveRepository extends JpaRepository<SurpriseMove,Integer>{
	@Query(value = "SELECT p FROM SurpriseMove p WHERE p.pMove = ?1")
	SurpriseMove findByMove(String pMove);
}
