package com.uwm.projektz.user.converter;

import com.uwm.projektz.permission.converter.PermissionConverter;
import com.uwm.projektz.project.converter.ProjectConverter;
import com.uwm.projektz.role.converter.RoleConverter;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.ob.UserOB;

import java.util.ArrayList;
import java.util.List;


public class UserConverter {

//User
    public static UserDTO converterUserOBtoDTO(UserOB aUserOB)
    {
        if (aUserOB == null) return null;

        return new UserDTO(aUserOB.getId(),aUserOB.getTechDate(),aUserOB.getName(),aUserOB.getSurname(),aUserOB.getEmail(),aUserOB.getLogin(),aUserOB.getMd5pass(),aUserOB.getActive(),
                RoleConverter.converterRoleOBtoDTO(aUserOB.getRole()),
                ProjectConverter.converterProjectListOBtoDTO(aUserOB.getProjects()),
                PermissionConverter.converterPermissionListOBtoDTO(aUserOB.getPermissions()));
    }

    public static UserOB converterUserDTOtoOB(UserDTO aUserDTO){
        if (aUserDTO == null) return null;

        return new UserOB(aUserDTO.getId(),aUserDTO.getTechDate(),aUserDTO.getName(),aUserDTO.getSurname(),aUserDTO.getEmail(),aUserDTO.getLogin(),aUserDTO.getMd5pass(),aUserDTO.getActive(),RoleConverter.converterRoleDTOtoOB(aUserDTO.getRole()), ProjectConverter.converterProjectListDTOtoOB(aUserDTO.getProjects()),PermissionConverter.converterPermissionListDTOtoOB(aUserDTO.getPermissions()));

    }

//Lists
    public static List<UserDTO> converterUserListOBtoDTO (List<UserOB> aUserListOB){
        if (aUserListOB == null) return null;

        List<UserDTO> temp = new ArrayList<UserDTO>();

        for (UserOB element : aUserListOB){
            temp.add(converterUserOBtoDTO(element));
        }
        return temp;
    }
    public static List<UserOB> converterUserListDTOtoOB (List<UserDTO> aUserListDTO){
        if (aUserListDTO == null) return null;

        List<UserOB> temp = new ArrayList<UserOB>();

        for (UserDTO element : aUserListDTO){
            temp.add(converterUserDTOtoOB(element));
        }
        return temp;
    }


}