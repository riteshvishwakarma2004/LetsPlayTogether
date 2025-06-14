package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Entity.JoiningRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JoiningRequestRepo extends JpaRepository<JoiningRequest, Long> {
    @Query("SELECT j.playerId FROM JoiningRequest as j WHERE j.groupId =:playerId")
    List<String> getAllRequests(@Param("playerId")String playerId);

    @Modifying
    @Transactional
    @Query("DELETE FROM JoiningRequest as j where j.groupId=:myGroupId AND j.playerId=:playerId")
    void removeRequest(@Param("myGroupId")String myGroupId,@Param("playerId") String playerId);
}

