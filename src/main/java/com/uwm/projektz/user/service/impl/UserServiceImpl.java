package com.uwm.projektz.user.service.impl;

import com.uwm.projektz.MyServerException;
import com.uwm.projektz.permission.converter.PermissionConverter;
import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.permission.ob.PermissionOB;
import com.uwm.projektz.permission.repository.IPermissionRepository;
import com.uwm.projektz.project.converter.ProjectConverter;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.project.ob.ProjectOB;
import com.uwm.projektz.project.repository.IProjectRepository;
import com.uwm.projektz.role.ob.RoleOB;
import com.uwm.projektz.role.repository.IRoleRepository;
import com.uwm.projektz.user.converter.UserConverter;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.dto.UserDTOCreate;
import com.uwm.projektz.user.ob.UserOB;
import com.uwm.projektz.user.repository.IUserRepository;
import com.uwm.projektz.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@Service
@Transactional(noRollbackFor = MyServerException.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public void updateUserActivity(Long aId,Boolean aActive) throws MyServerException {
        UserOB user = userRepository.findOne(aId);
        if(user == null) throw new MyServerException("User not found",HttpStatus.NOT_FOUND);
        user.setActive(aActive);
        userRepository.save(user);
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
    public List<UserDTO> findUsersByRole(String aRole) {
        List<UserOB> users = userRepository.findUserByRole(aRole);
        return UserConverter.converterUserListOBtoDTO(users);
    }

    @Override
    public UserDTO saveUser(UserDTOCreate aUserDTO) {
        UserOB userOB = aUserDTO.getLogin() == null ? null : userRepository.findUserByLogin(aUserDTO.getLogin());
        if(userOB == null){
            //zapisz nowego usera
            userOB = new UserOB(aUserDTO.getName(),aUserDTO.getSurname(),aUserDTO.getEmail(),aUserDTO.getLogin(),aUserDTO.getMd5pass());
            userOB.setRole(roleRepository.findRoleByName("USER"));
            userOB.setPermissions(null);
            userOB.setProjects(null);

            return UserConverter.converterUserOBtoDTO(userRepository.save(userOB));
        }
        //w przeciwnym wypadku zmien edycja

            userOB.setName(aUserDTO.getName());
            userOB.setSurname(aUserDTO.getSurname());
           return UserConverter.converterUserOBtoDTO(userRepository.save(userOB));


    }


    @Override
    public void updateUserLogin(Long aId, String aLogin) throws MyServerException {
        UserOB user = userRepository.findOne(aId);
        if(user == null) throw new MyServerException("User not found",HttpStatus.NOT_FOUND);
        UserOB userLogin = userRepository.findUserByLogin(aLogin);
        if(userLogin != null) throw  new MyServerException("User with that login exists", HttpStatus.METHOD_NOT_ALLOWED); //nie moze byc uzytkownika o takim samym loginie
        user.setLogin(aLogin);
        userRepository.save(user);
    }

    @Override
    public void updateUserEmail(Long aId, String aEmail) throws MyServerException{
        UserOB user = userRepository.findOne(aId);
        if(user == null) throw new MyServerException("User not found",HttpStatus.NOT_FOUND);
        UserOB userEmail = userRepository.findUserByEmail(aEmail);
        if(userEmail != null) throw new MyServerException("User with that email exists",HttpStatus.METHOD_NOT_ALLOWED);//nie może być drugi taki sam;
        user.setEmail(aEmail);
    }

    @Override
    public void updatePermissionsListForUser(Long aId,List<PermissionDTO> aPermissionDTO) throws MyServerException {
        UserOB user = userRepository.findOne(aId);
        if(user == null) throw new MyServerException("User not found",HttpStatus.NOT_FOUND);
        List<PermissionOB> permissions = PermissionConverter.converterPermissionListDTOtoOB(aPermissionDTO);
        user.setPermissions(permissions);
        userRepository.save(user);

    }

    @Override
    public void updateProjectListForUser(Long aId, List<ProjectDTO> aProjectDTO) throws MyServerException {
        UserOB user = userRepository.findOne(aId);
        if(user == null) throw new MyServerException("User not found",HttpStatus.NOT_FOUND);
        List<ProjectOB> projects = ProjectConverter.converterProjectListDTOtoOB(aProjectDTO);
        user.setProjects(projects);
        userRepository.save(user);
    }

    @Override
    public void updateUserRole(Long aId, String aName) throws MyServerException {
        UserOB user = userRepository.findOne(aId);
        if(user == null) throw new MyServerException("User not found",HttpStatus.NOT_FOUND);
        RoleOB roleOB = roleRepository.findRoleByName(aName);
        if(roleOB == null) throw new MyServerException("Role not found",HttpStatus.NOT_FOUND);
        user.setRole(roleOB);
        userRepository.save(user);
    }

    @Override
    public void deletUser(Long aId) {
        userRepository.delete(aId);
    }
}
