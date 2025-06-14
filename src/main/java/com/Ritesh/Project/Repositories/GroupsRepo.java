package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Entity.PlayersGroups;
import com.Ritesh.Project.Model.GroupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupsRepo extends JpaRepository<PlayersGroups, String> {

    @Query("select g.name from PlayersGroups as g where g.groupId =:myGroupId")
    String getName(@Param("myGroupId") String myGroupId);

    @Query("SELECT new com.Ritesh.Project.Model.GroupDetails(p.groupId, p.name, p.sport, p.area, p.moto, p.notice, p.adminId) FROM PlayersGroups as p WHERE p.sport=:sport AND p.groupId NOT IN :playerIsInThem")
    List<GroupDetails> findAllRemainingGroups(@Param("playerIsInThem")List<String> playerIsInThem,@Param("sport") String sport);
}
