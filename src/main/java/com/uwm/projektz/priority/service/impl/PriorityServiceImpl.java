package com.uwm.projektz.priority.service.impl;

import com.uwm.projektz.priority.dto.PriorityDTO;
import com.uwm.projektz.priority.ob.PriorityOB;
import com.uwm.projektz.priority.repository.IPriorityRepository;
import com.uwm.projektz.priority.service.IPriorityService;
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
public class PriorityServiceImpl implements IPriorityService {

    @Autowired
    IPriorityRepository priorityRepository;

    @Override
    public PriorityDTO savePriority(PriorityDTO aProrityDTO) {
        priorityRepository.save(Converters.converterPriorityDTOtoOB(aProrityDTO));
        return null;
    }

    @Override
    public PriorityDTO findPriorityById(Long aId) {
        PriorityOB temp = priorityRepository.findOne(aId);
        return Converters.converterPriorityOBtoDTO(temp);
    }

    @Override
    public List<PriorityDTO> findAllPriorities() {
        List<PriorityOB> temp = priorityRepository.findAll();
        return Converters.converterPriorityListOBtoDTO(temp);
    }

    @Override
    public PriorityDTO findByName(String aName) {
        List<PriorityOB> temp = priorityRepository.findAll();

        for (PriorityOB element : temp){
            String name = element.getName();
            if (name == aName) return Converters.converterPriorityOBtoDTO(element);
        }
        return null;
    }

    @Override
    public void deletePriority(Long aId) {
        priorityRepository.delete(aId);
    }
}
