package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.Moveset;

@Repository
public interface MoveRepository extends JpaRepository<Moveset,Integer>{
	@Query(value = "SELECT m FROM Moveset m WHERE m.movesetId = ?1")
	Moveset findById(int movesetId);
//	@Modifying
//	@Query(value = "UPDATE Moveset m SET m.chiMove = :chiMove WHERE m.cMoveId = :cMoveId")
//	Moveset chooseChi(ChiMove chiMove);
//	@Modifying
//	@Query(value = "UPDATE Moveset m SET m.kenMove = :kenMove WHERE m.kMoveId = :kMoveId")
//	Moveset chooseKen(KenMove kenMove);
//	@Modifying
//	@Query(value = "UPDATE Moveset m SET m.seiMove = :seiMove WHERE m.sMoveId = :sMoveId")
//	Moveset chooseSei(SeiMove seiMove);
//	@Modifying
//	@Query(value = "UPDATE Moveset m SET m.surpriseMove = :surpriseMove WHERE m.pMoveId = :pMoveId")
//	Moveset chooseSurprise(SurpriseMove surpriseMove);
}
