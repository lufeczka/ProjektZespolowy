package com.uwm.projektz.user.service;

import com.uwm.projektz.MyServerException;
import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.dto.UserDTOCreate;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

public interface IUserService {

    //CREATE & EDIT
    UserDTO saveUser(UserDTOCreate aUserDTO);

    //READ
    UserDTO findUserById(Long aId);
    List<UserDTO> findAllUsers();
    List<UserDTO> findUsersByActivity(Boolean aActive);
    UserDTO findUserByLogin(String aLogin);
    UserDTO findUserByEmail(String aEmail);
    List<UserDTO> findUsersByName(String aName);
    List<UserDTO> findUsersBySurname(String aSurname);
    List<UserDTO> findUsersByNameAndSurname(String aName,String aSurname);
    List<UserDTO> findUsersByRole(String aRole);

    //UPDATE
    void updateUserActivity(Long aId,Boolean aActive) throws MyServerException;
    void updateUserLogin(Long aId, String aLogin) throws MyServerException;
    void updateUserEmail(Long aId,String aName) throws MyServerException;
    void updateUserRole(Long aId,String aName) throws MyServerException;
    void updatePermissionsListForUser(Long aId, List<PermissionDTO> aPermissionDTO) throws MyServerException;
    void updateProjectListForUser(Long aId, List<ProjectDTO> aProjectDTO) throws MyServerException;

    //DELETE
    void deletUser(Long aId) throws  MyServerException;
}
