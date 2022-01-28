package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.ChiMove;

@Repository
public interface ChiMoveRepository extends JpaRepository<ChiMove,Integer>{
	@Query(value = "SELECT c FROM ChiMove c WHERE c.cMove = ?1")
	ChiMove findByMove(String cMove);
}
