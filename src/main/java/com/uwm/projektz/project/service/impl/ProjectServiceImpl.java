package com.uwm.projektz.project.service.impl;

import com.uwm.projektz.priority.converter.PriorityConverter;
import com.uwm.projektz.priority.dto.PriorityDTO;
import com.uwm.projektz.priority.ob.PriorityOB;
import com.uwm.projektz.project.converter.ProjectConverter;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.project.ob.ProjectOB;
import com.uwm.projektz.project.repository.IProjectRepository;
import com.uwm.projektz.project.service.IProjectService;
import com.uwm.projektz.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    IProjectRepository projectRepository;

    @Override
    public ProjectDTO deleteProjectById(Long aId) {
        projectRepository.delete(aId);
        return null;
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO aProjectDTO) {
        projectRepository.save(ProjectConverter.converterProjectDTOtoOB(aProjectDTO));
        return null;
    }

    @Override
    public ProjectDTO findProjectById(Long aId) {
        ProjectOB temp = projectRepository.findOne(aId);
        return ProjectConverter.converterProjectOBtoDTO(temp);
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        List<ProjectDTO> temp = ProjectConverter.converterProjectListOBtoDTO(projectRepository.findAll());
        return temp;
    }

    @Override
    public ProjectDTO findProjectByName(String aName) {
        ProjectOB project = projectRepository.findProjectByName(aName);
        return ProjectConverter.converterProjectOBtoDTO(project);

    }

    @Override
    public List<ProjectDTO> findProjectsByPriority(PriorityDTO aPriorityDTO) {
        List<ProjectOB> projects = projectRepository.findProjectByPriority(aPriorityDTO.getId());
        return ProjectConverter.converterProjectListOBtoDTO(projects);
    }

    @Override
    public List<ProjectDTO> findUserProjects(UserDTO aUserDTO) {
        List<ProjectOB> projects = projectRepository.findUserProjects(aUserDTO.getId());
        return ProjectConverter.converterProjectListOBtoDTO(projects);
    }

    @Override
    public ProjectDTO updatePriorityForProject(Long aId, PriorityDTO aPrority) {
        ProjectOB temp = projectRepository.findOne(aId);
        temp.setPriority(PriorityConverter.converterPriorityDTOtoOB(aPrority));
        projectRepository.save(temp);
        return ProjectConverter.converterProjectOBtoDTO(temp);
    }
}
