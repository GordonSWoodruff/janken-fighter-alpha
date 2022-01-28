package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.KenMove;

@Repository
public interface KenMoveRepository extends JpaRepository<KenMove,Integer>{
	@Query(value = "SELECT k FROM KenMove k WHERE k.kMove = ?1")
	KenMove findByMove(String kMove);
}
