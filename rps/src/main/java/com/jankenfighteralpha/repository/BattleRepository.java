package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.Battle;

@Repository
public interface BattleRepository extends JpaRepository<Battle,Integer> {

}
