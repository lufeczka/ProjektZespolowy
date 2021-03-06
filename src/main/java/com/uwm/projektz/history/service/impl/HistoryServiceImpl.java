package com.uwm.projektz.history.service.impl;

import com.uwm.projektz.MyServerException;
import com.uwm.projektz.attachment.ob.AttachmentOB;
import com.uwm.projektz.attachment.repository.IAttachmentRepository;
import com.uwm.projektz.attachment.service.IAttachmentSerivce;
import com.uwm.projektz.history.converter.HistoryConverter;
import com.uwm.projektz.history.dto.HistoryDTO;
import com.uwm.projektz.history.dto.HistoryDTOAttachments;
import com.uwm.projektz.history.dto.HistoryDTOWithoutAttachment;
import com.uwm.projektz.history.ob.HistoryOB;
import com.uwm.projektz.history.repository.IHistoryRepository;
import com.uwm.projektz.history.service.IHistoryService;
import com.uwm.projektz.user.ob.UserOB;
import com.uwm.projektz.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IAttachmentRepository attachmentRepository;

    @Override
    public List<HistoryDTO> findHistoryByDateAndUser(Date aDate, Long aId) {
        List<HistoryOB> histories = historyRepository.findHistoryByDateAndUser(aDate,aId);
        return HistoryConverter.converterHistoryListOBtoDTO(histories);
    }

    @Override
    public HistoryDTO saveHistory(HistoryDTOWithoutAttachment aHistoryDTO)  throws MyServerException{
        UserOB userOB = aHistoryDTO.getUser() == null ? null : userRepository.findUserByLogin(aHistoryDTO.getUser());
        if(userOB == null) throw new MyServerException("User not found", HttpStatus.NOT_FOUND);
        HistoryOB historyOB = aHistoryDTO.getId() == null ? null : historyRepository.findOne(aHistoryDTO.getId());
        if(historyOB == null) {
            historyOB = HistoryConverter.converterHistoryDTOWithoutAttachmentToHistoryOB(aHistoryDTO);
            historyOB.setUser(userOB);
            return HistoryConverter.converterHistoryOBtoDTO(historyRepository.save(historyOB));
        }
        //jezeli istnieje
        historyOB.setDescription(aHistoryDTO.getDescription());
        historyOB.setType(aHistoryDTO.getType());
        historyOB.setTechDate(new Date());
        return HistoryConverter.converterHistoryOBtoDTO(historyRepository.save(historyOB));
    }

    @Override
    public HistoryDTO saveHistoryWithAttachments(HistoryDTOAttachments aHistoryDTO) throws MyServerException {
        UserOB userOB = aHistoryDTO.getUser() == null ? null : userRepository.findUserByLogin(aHistoryDTO.getUser());
        if(userOB == null) throw new MyServerException("User not found", HttpStatus.NOT_FOUND);
        List<AttachmentOB> attachmentOBList = new ArrayList<>();
        if(aHistoryDTO.getAttachments() == null) throw  new MyServerException("Attachments field not found",HttpStatus.NOT_FOUND);
        for(Long attachment : aHistoryDTO.getAttachments()){
            AttachmentOB attachmentOB = attachmentRepository.findOne(attachment);
            if(attachmentOB == null) throw new MyServerException("Attachment not found",HttpStatus.NOT_FOUND);
            attachmentOBList.add(attachmentOB);
        }

        HistoryOB historyOB = aHistoryDTO.getId() == null ? null : historyRepository.findOne(aHistoryDTO.getId());
        if(historyOB == null) {
            historyOB = HistoryConverter.converterHistoryDTOAttachmentsToHistoryOB(aHistoryDTO);
            historyOB.setUser(userOB);
            historyOB.setAttachments(attachmentOBList);
            return HistoryConverter.converterHistoryOBtoDTO(historyRepository.save(historyOB));
        }
        //jezeli istnieje
        historyOB.setAttachments(attachmentOBList);
        historyOB.setDescription(aHistoryDTO.getDescription());
        historyOB.setType(aHistoryDTO.getType());
        historyOB.setTechDate(new Date());
        return HistoryConverter.converterHistoryOBtoDTO(historyRepository.save(historyOB));
    }


    @Override
    public List<HistoryDTO> findHistoryByDate(Date aDate) {
        List<HistoryOB> histories = historyRepository.findHistoryByDate(aDate);
        return HistoryConverter.converterHistoryListOBtoDTO(histories);
    }

    @Override
    public List<HistoryDTO> findHistoryByUser(Long aId) {
        List<HistoryOB> histories = historyRepository.findHistoryByUser(aId);
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
