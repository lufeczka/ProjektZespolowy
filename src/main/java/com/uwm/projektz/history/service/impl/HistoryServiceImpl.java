package com.uwm.projektz.history.service.impl;

import com.uwm.projektz.history.converter.HistoryConverter;
import com.uwm.projektz.history.dto.HistoryDTO;
import com.uwm.projektz.history.ob.HistoryOB;
import com.uwm.projektz.history.repository.IHistoryRepository;
import com.uwm.projektz.history.service.IHistoryService;
import com.uwm.projektz.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@Service
@Transactional
public class HistoryServiceImpl implements IHistoryService{

    @Autowired
    IHistoryRepository historyRepository;

    @Override
    public List<HistoryDTO> findHistoryByDateAndUser(Date aDate, UserDTO aUserDTO) {
        List<HistoryOB> histories = historyRepository.findHistoryByDateAndUser(aDate,aUserDTO.getId());
        return HistoryConverter.converterHistoryListOBtoDTO(histories);
    }

    @Override
    public HistoryDTO saveHistory(HistoryDTO aHistoryDTO) {
        historyRepository.save(HistoryConverter.converterHistoryDTOtoOB(aHistoryDTO));
        return aHistoryDTO;
    }

    @Override
    public List<HistoryDTO> findHistoryByDate(Date aDate) {
        List<HistoryOB> histories = historyRepository.findHistoryByDate(aDate);
        return HistoryConverter.converterHistoryListOBtoDTO(histories);
    }

    @Override
    public List<HistoryDTO> findHistoryByUser(UserDTO aUserDTO) {
        List<HistoryOB> histories = historyRepository.findHistoryByUser(aUserDTO.getId());
        return HistoryConverter.converterHistoryListOBtoDTO(histories);
    }

    @Override
    public HistoryDTO findHistoryById(Long aId) {
        HistoryOB temp = historyRepository.findOne(aId);
        return HistoryConverter.converterHistoryOBtoDTO(temp);
    }

    @Override
    public List<HistoryDTO> findAllHistory() {
        List<HistoryOB> histories = historyRepository.findAll();
        return HistoryConverter.converterHistoryListOBtoDTO(histories);
    }


    @Override
    public void deleteHistoryById(Long aId) {
        historyRepository.delete(aId);
    }
}
