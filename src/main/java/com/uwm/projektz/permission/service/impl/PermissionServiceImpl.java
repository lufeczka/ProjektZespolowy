package com.uwm.projektz.permission.service.impl;

import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.permission.ob.PermissionOB;
import com.uwm.projektz.permission.repository.IPermissionRepository;
import com.uwm.projektz.permission.service.IPermissionService;
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
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    IPermissionRepository permissionRepository;

    @Override
    public PermissionDTO savePermission(PermissionDTO aPermissionDTO) {
        permissionRepository.save(Converters.converterPermissionDTOtoOB(aPermissionDTO));
        return aPermissionDTO;
    }

    @Override
    public PermissionDTO findPermissionById(Long aId) {
        PermissionOB temp = permissionRepository.findOne(aId);
        return Converters.converterPermissionOBtoDTO(temp);
    }

    @Override
    public List<PermissionDTO> findAllPermission() {
        List<PermissionOB> temp = permissionRepository.findAll();
        return Converters.converterPermissionListOBtoDTO(temp);
    }

    @Override
    public PermissionDTO findByName(String aName) {
        List<PermissionOB> temp = permissionRepository.findAll();

        for (PermissionOB element : temp){
            String name = element.getName();
            if (name == aName) return Converters.converterPermissionOBtoDTO(element);
        }
        return null;
    }

    @Override
    public void deletePermissionById(Long aId) {
        permissionRepository.delete(aId);
    }
}
