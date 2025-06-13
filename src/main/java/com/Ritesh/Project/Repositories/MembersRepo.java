package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface MembersRepo extends JpaRepository<Members, Long> {

    @Query("SELECT m.groupId FROM Members as m WHERE m.playerId =:playerId")
    List<String> findAllGroupIds(@Param("playerId") String playerId);

    @Query("SELECT m.playerId FROM Members as m WHERE groupId=:groupId")
    List<String> getAllPlayersId(@Param("groupId")String groupId);
}
