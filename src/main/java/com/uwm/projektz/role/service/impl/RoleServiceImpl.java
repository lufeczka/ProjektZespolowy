package com.uwm.projektz.role.service.impl;

import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.role.dto.RoleDTO;
import com.uwm.projektz.role.ob.RoleOB;
import com.uwm.projektz.role.repository.IRoleRepository;
import com.uwm.projektz.role.service.IRoleService;
import com.uwm.projektz.utils.Converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {


    @Autowired
    IRoleRepository roleRepository;

    @Override
    public RoleDTO saveRole(RoleDTO aRoleDTO) {
        roleRepository.save(Converters.converterRoleDTOtoOB(aRoleDTO));
        return aRoleDTO;
    }



    @Override
    public RoleDTO findPRoleById(Long aId) {
        return Converters.converterRoleOBtoDTO(roleRepository.findOne(aId));
    }

    @Override
    public List<RoleDTO> findAllRole() {
        return Converters.converterRoleListOBtoDTO(roleRepository.findAll());
    }

    @Override
    public RoleDTO findByName(String aName) {
        List<RoleDTO> roles = Converters.converterRoleListOBtoDTO(roleRepository.findAll());

        for (RoleDTO element : roles){
            String name = element.getName();
            if (name == aName) return element;
        }
        return null;
    }

    @Override
    public void deleteRoleById(Long aId) {
        roleRepository.delete(aId);

    }
}
