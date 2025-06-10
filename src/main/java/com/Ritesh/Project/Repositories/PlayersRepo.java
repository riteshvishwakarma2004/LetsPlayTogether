package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Configuration.AppUser;
import com.Ritesh.Project.Entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepo extends JpaRepository<Players,String> {

    Players findByplayerId(String id);
}
