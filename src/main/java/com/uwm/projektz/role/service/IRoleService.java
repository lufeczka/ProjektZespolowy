package com.uwm.projektz.role.service;

import com.uwm.projektz.MyServerException;
import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.role.dto.RoleDTO;
import com.uwm.projektz.role.dto.RoleDTOCreate;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
public interface IRoleService {
    //CREATE & UPDATE
    RoleDTO saveRole(RoleDTOCreate aRoleDTO) throws MyServerException;
    //READ
    RoleDTO findPRoleById(Long aId);
    List<RoleDTO> findAllRole();
    RoleDTO findByName(String aName);

    //DELETE
    //usuwanie permission z listy
    void deleteRoleById(Long aId);
}
