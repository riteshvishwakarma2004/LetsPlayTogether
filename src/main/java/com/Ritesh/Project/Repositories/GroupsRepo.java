package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Entity.PlayersGroups;
import com.Ritesh.Project.Model.GroupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupsRepo extends JpaRepository<PlayersGroups, String> {

    @Query("select g.name from PlayersGroups as g where g.groupId =:myGroupId")
    String getName(@Param("myGroupId") String myGroupId);



}
