package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.Results;

@Repository
public interface ResultRepository  extends JpaRepository<Results,Integer>{
	@Query(value = "SELECT r FROM Results r WHERE r.resultId = ?1")
	Results findById(int resultId);
}
