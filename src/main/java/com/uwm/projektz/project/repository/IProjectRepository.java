package com.uwm.projektz.project.repository;

import com.uwm.projektz.project.ob.ProjectOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Repository
public interface IProjectRepository extends JpaRepository<ProjectOB,Long> {
    @Query("SELECT p FROM ProjectOB WHERE p.name = ?1")
    ProjectOB findProjectByName (String aName);
    @Query("SELECT p FROM ProjectOB WHERE p.priority.id = ?1")
    List<ProjectOB> findProjectByPriority (Long aId);
    @Query("SELECT u.projects FROM UserOB WHERE u.id = ?1")
    List<ProjectOB> findUserProjects (Long aId);
}
