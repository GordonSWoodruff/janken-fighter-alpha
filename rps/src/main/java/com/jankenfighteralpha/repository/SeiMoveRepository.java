package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.SeiMove;

@Repository
public interface SeiMoveRepository extends JpaRepository<SeiMove,Integer>{
	@Query(value = "SELECT s FROM SeiMove s WHERE s.sMove = ?1")
	SeiMove findByMove(String sMove);
}
