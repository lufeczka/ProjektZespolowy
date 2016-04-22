package com.uwm.projektz.project.repository;

import com.uwm.projektz.project.ob.ProjectOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Repository
public interface IProjectRepository extends JpaRepository<ProjectOB,Long> {
    //@Query("SELECT p FROM UserOB u JOIN  ProjectOB p WHERE u.projects.")
}
