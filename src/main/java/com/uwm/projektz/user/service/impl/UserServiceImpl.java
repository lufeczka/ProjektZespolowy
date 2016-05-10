package com.uwm.projektz.user.service.impl;

import com.uwm.projektz.permission.converter.PermissionConverter;
import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.permission.ob.PermissionOB;
import com.uwm.projektz.project.converter.ProjectConverter;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.project.ob.ProjectOB;
import com.uwm.projektz.role.converter.RoleConverter;
import com.uwm.projektz.role.dto.RoleDTO;
import com.uwm.projektz.user.converter.UserConverter;
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
        UserOB user = userRepository.findOne(aId);
        user.setActive(aActive);
        userRepository.save(user);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public UserDTO findUserById(Long aId) {
        return UserConverter.converterUserOBtoDTO(userRepository.findOne(aId));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return UserConverter.converterUserListOBtoDTO(userRepository.findAll());
    }

    @Override
    public List<UserDTO> findUsersByActivity(Boolean aActive) {
        List<UserOB> users = userRepository.findUserByActivity(aActive);
        return UserConverter.converterUserListOBtoDTO(users);
    }

    @Override
    public UserDTO findUserByLogin(String aLogin) {
        UserOB user = userRepository.findUserByLogin(aLogin);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public UserDTO findUserByEmail(String aEmail) {
        UserOB user = userRepository.findUserByEmail(aEmail);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public List<UserDTO> findUsersByName(String aName) {
        List<UserOB> user = userRepository.findUserByName(aName);
        return UserConverter.converterUserListOBtoDTO(user);
    }

    @Override
    public List<UserDTO> findUsersBySurname(String aSurname) {
        List<UserOB> user = userRepository.findUserBySurname(aSurname);
        return UserConverter.converterUserListOBtoDTO(user);
    }

    @Override
    public List<UserDTO> findUsersByNameAndSurname(String aName, String aSurname) {
        List<UserOB> users = userRepository.findUserByNameAndSurname(aName,aSurname);
        return UserConverter.converterUserListOBtoDTO(users);
    }

    @Override
    public List<UserDTO> findUsersByRole(RoleDTO aRoleDTO) {
        List<UserOB> users = userRepository.findUserByRole(RoleConverter.converterRoleDTOtoOB(aRoleDTO));
        return UserConverter.converterUserListOBtoDTO(users);
    }

    @Override
    public UserDTO saveUser(UserDTO aUserDTO) {
        userRepository.save(UserConverter.converterUserDTOtoOB(aUserDTO));
        return aUserDTO;
    }


    @Override
    public UserDTO updateUserLogin(Long aId, String aLogin) {
        UserOB user = userRepository.findOne(aId);
        user.setLogin(aLogin);
        userRepository.save(user);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public UserDTO updateUserEmail(Long aId, String aEmail){
        UserOB user = userRepository.findOne(aId);
        user.setEmail(aEmail);
        userRepository.save(user);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public UserDTO updatePermissionsListForUser(Long aId, PermissionDTO aPermissionDTO) {
        UserOB user = userRepository.findOne(aId);
        List<PermissionOB> permissions = user.getPermissions();
        permissions.add(PermissionConverter.converterPermissionDTOtoOB(aPermissionDTO));
        user.setPermissions(permissions);
        userRepository.save(user);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public UserDTO updateProjectListForUser(Long aId, ProjectDTO aProjectDTO) {
        UserOB user = userRepository.findOne(aId);
        List<ProjectOB> projects = user.getProjects();
        projects.add(ProjectConverter.converterProjectDTOtoOB(aProjectDTO));
        user.setProjects(projects);
        userRepository.save(user);
        return UserConverter.converterUserOBtoDTO(user);
    }

    @Override
    public void deletUser(Long aId) {
        userRepository.delete(aId);
    }
}
