package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.UserStats;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Integer> {
	@Query(value = "SELECT s FROM UserStats s WHERE s.statId = ?1")
	UserStats findById(int statId);
}
