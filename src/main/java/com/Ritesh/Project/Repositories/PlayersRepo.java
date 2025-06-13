package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Configuration.AppUser;
import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Model.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepo extends JpaRepository<Players,String> {

    Players findByplayerId(String id);

    @Query("SELECT p.playerId,p.name,p.phone,p.sport,p.area,p.description FROM Players as p WHERE p.playerId =:playerId")
    PlayerDto searchPlayer(@Param("playerId")String playerId);
}
