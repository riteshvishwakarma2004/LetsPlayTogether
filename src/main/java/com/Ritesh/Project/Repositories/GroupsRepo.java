package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Entity.PlayersGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepo extends JpaRepository<PlayersGroups, String> {
}
