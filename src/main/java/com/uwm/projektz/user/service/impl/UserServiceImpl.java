package com.uwm.projektz.user.service.impl;

import com.uwm.projektz.permission.converter.PermissionConverter;
import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.permission.ob.PermissionOB;
import com.uwm.projektz.project.converter.ProjectConverter;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.project.ob.ProjectOB;
import com.uwm.projektz.role.dto.RoleDTO;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.ob.UserOB;
import com.uwm.projektz.user.repository.IUserRepository;
import com.uwm.projektz.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void deletProjectFromUser(Long aId, ProjectDTO aPojectDTO) {
        UserOB user = userRepository.findOne(aId);
        List<ProjectOB> userProjects = user.getProjects();
        userProjects.remove(ProjectConverter.converterProjectDTOtoOB(aPojectDTO));
        user.setProjects(userProjects);
        userRepository.save(user);
    }

    @Override
    public void deletPermissionFromUser(Long aId, PermissionDTO aPermsissionDTO) {
        UserOB user = userRepository.findOne(aId);
        List<PermissionOB> userPermissions = user.getPermissions();
        userPermissions.remove(PermissionConverter.converterPermissionDTOtoOB(aPermsissionDTO));
        user.setPermissions(userPermissions);
        userRepository.save(user);
    }

    @Override
    public UserDTO updateUserActivity(Long aId,Boolean aActive) {
        return null;
    }

    @Override
    public UserDTO findUserById(Long aId) {
        return null;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }

    @Override
    public List<UserDTO> findUsersByActivity(Boolean aActive) {
        return null;
    }

    @Override
    public UserDTO findUserByLogin(String aLogin) {
        return null;
    }

    @Override
    public UserDTO findUserByEmail(String aEmail) {
        return null;
    }

    @Override
    public List<UserDTO> findUsersByName(String aName) {
        return null;
    }

    @Override
    public List<UserDTO> findUsersBySurname(String aSurname) {
        return null;
    }

    @Override
    public List<UserDTO> findUsersByNameAndSurname(String aName, String aSurname) {
        return null;
    }

    @Override
    public List<UserDTO> findUsersByRole(RoleDTO aRoleDTO) {
        return null;
    }

    @Override
    public List<UserDTO> findUsersByProject(ProjectDTO aProjectDTO) {
        return null;
    }

    @Override
    public UserDTO saveUser(UserDTO aUserDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO aUserDTO) {
        return null;
    }

    @Override
    public UserDTO updateUserLogin(Long aId, String aLogin) {
        return null;
    }

    @Override
    public UserDTO updateUserEmail(Long aId, String aName) {
        return null;
    }

    @Override
    public UserDTO updatePermissionsListForUser(Long aId, PermissionDTO aPermissionDTO) {
        return null;
    }

    @Override
    public UserDTO updateProjectListForUser(Long aId, ProjectDTO aProjectDTO) {
        return null;
    }

    @Override
    public void deletUser(Long aId) {

    }
}
