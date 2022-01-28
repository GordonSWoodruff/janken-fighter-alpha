package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.Arms;
import com.jankenfighteralpha.entity.Avatar;
import com.jankenfighteralpha.entity.Head;
import com.jankenfighteralpha.entity.Legs;
import com.jankenfighteralpha.entity.Torso;
import com.jankenfighteralpha.entity.Waist;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Integer> {
	@Query(value = "SELECT a FROM Avatar a WHERE a.avatarId = ?1")
	Avatar findById(int avatarId);
	@Modifying
	@Query(value = "UPDATE Avatar a SET a.armsPart = :armsPart WHERE a.avatarId = :avatarId")
	Avatar chooseArms(Arms armsPart);
	@Modifying
	@Query(value = "UPDATE Avatar a SET a.headPart = :headPart WHERE a.avatarId = :avatarId")
	Avatar chooseHead(Head headPart);
	@Modifying
	@Query(value = "UPDATE Avatar a SET a.legsPart = :legsPart WHERE a.avatarId = :avatarId")
	Avatar chooseLegs(Legs legsPart);
	@Modifying
	@Query(value = "UPDATE Avatar a SET a.torsoPart = :torsoPart WHERE a.avatarId = :avatarId")
	Avatar chooseTorso(Torso torsoPart);
	@Modifying
	@Query(value = "UPDATE Avatar a SET a.waistPart = :waistPart WHERE a.avatarId = :avatarId")
	Avatar chooseWaist(Waist waistPart);
}
