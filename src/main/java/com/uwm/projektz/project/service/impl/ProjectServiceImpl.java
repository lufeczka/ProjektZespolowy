package com.uwm.projektz.project.service.impl;

import com.uwm.projektz.priority.dto.PriorityDTO;
import com.uwm.projektz.priority.ob.PriorityOB;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.project.ob.ProjectOB;
import com.uwm.projektz.project.repository.IProjectRepository;
import com.uwm.projektz.project.service.IProjectService;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.utils.Converters;
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
        projectRepository.save(Converters.converterProjectDTOtoOB(aProjectDTO));
        return null;
    }

    @Override
    public ProjectDTO findProjectById(Long aId) {
        ProjectOB temp = projectRepository.findOne(aId);
        return Converters.converterProjectOBtoDTO(temp);
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        List<ProjectDTO> temp = Converters.converterProjectListOBtoDTO(projectRepository.findAll());
        return temp;
    }

    @Override
    public ProjectDTO findProjectByName(String aName) {
        List<ProjectOB> projects = projectRepository.findAll();
        for (ProjectOB element : projects){
            String name = element.getName();
            if (name == aName) return Converters.converterProjectOBtoDTO(element);
        }
        return null;

    }

    @Override
    public List<ProjectDTO> findProjectsByPriority(PriorityDTO aPriorityDTO) {
        List<ProjectOB> projects = projectRepository.findAll();
        List<ProjectDTO> temp = new ArrayList<ProjectDTO>();
        for (ProjectOB element : projects){
            PriorityDTO priorytet = Converters.converterPriorityOBtoDTO(element.getPriority());
            if (priorytet == aPriorityDTO) temp.add(Converters.converterProjectOBtoDTO(element));
        }
        return temp;
    }

    @Override
    public List<ProjectDTO> findUserProjects(UserDTO aUserDTO) {
        UserDTO user = aUserDTO;
        return null;
    }

    @Override
    public ProjectDTO updatePriorityForProject(Long aId, PriorityDTO aPrority) {
        ProjectOB temp = projectRepository.findOne(aId);
        temp.setPriority(Converters.converterPriorityDTOtoOB(aPrority));
        projectRepository.save(temp);
        return Converters.converterProjectOBtoDTO(temp);
    }
}
