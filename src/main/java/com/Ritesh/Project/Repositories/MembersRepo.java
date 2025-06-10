package com.Ritesh.Project.Repositories;

import com.Ritesh.Project.Entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepo extends JpaRepository<Members, Long> {
}
