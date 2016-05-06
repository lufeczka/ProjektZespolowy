package com.uwm.projektz.attachment.service.impl;

import com.uwm.projektz.attachment.dto.AttachmentDTO;
import com.uwm.projektz.attachment.ob.AttachmentOB;
import com.uwm.projektz.attachment.repository.IAttachmentRepository;
import com.uwm.projektz.attachment.service.IAttachmentSerivce;
import com.uwm.projektz.enums.Type;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.utils.Converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Service
@Transactional
public class AttachmentServiceImpl implements IAttachmentSerivce {

    @Autowired
    IAttachmentRepository attachmentRepository;

    @Override
    public AttachmentDTO findAttachmentById(Long aId) {
        return Converters.converterAttachmentOBtoDTO(attachmentRepository.findOne(aId));
    }

    @Override
    public List<AttachmentDTO> findAllAttachment() {
        return Converters.converterAttachmentListOBtoDTO(attachmentRepository.findAll());
    }

    @Override
    public List<AttachmentDTO> findAllAttachmentsForUser(UserDTO aUserDTO) {
        List<AttachmentOB> attachemnts = attachmentRepository.attachments(aUserDTO.getId());
        return Converters.converterAttachmentListOBtoDTO(attachemnts);
    }

    @Override
    public List<AttachmentDTO> findAttachmentByName(String aName) {
        List<AttachmentOB> attachments = attachmentRepository.findAll();
        List<AttachmentDTO> temp = new ArrayList<AttachmentDTO>();
        for (AttachmentOB element : attachments){
            String name = element.getName();
            if (name == aName) temp.add(Converters.converterAttachmentOBtoDTO(element));
        }
        return temp;
    }

    @Override
    public List<AttachmentDTO> findAAtachmentsByFileName(String aFile_Name) {
        List<AttachmentOB> attachments = attachmentRepository.findAll();
        List<AttachmentDTO> temp = new ArrayList<AttachmentDTO>();
        for (AttachmentOB element : attachments){
            String file_name = element.getFile_name();
            if (file_name == aFile_Name) temp.add(Converters.converterAttachmentOBtoDTO(element));
        }
        return temp;
    }

    @Override
    public List<AttachmentDTO> findAttachmentByMineType(String aMineType) {
        List<AttachmentOB> attachments = attachmentRepository.findAll();
        List<AttachmentDTO> temp = new ArrayList<AttachmentDTO>();
        for (AttachmentOB element : attachments){
            String mine_type = element.getMine_type();
            if (mine_type == aMineType) temp.add(Converters.converterAttachmentOBtoDTO(element));
        }
        return temp;
    }

    @Override
    public List<AttachmentDTO> findAAtachemntByMineTypeAndName(String aMineType, String aName) {
        List<AttachmentOB> attachments = attachmentRepository.findAll();
        List<AttachmentDTO> temp = new ArrayList<AttachmentDTO>();
        for (AttachmentOB element : attachments){
            String name = element.getName();
            String mine_type = element.getMine_type();

            if ((mine_type == aMineType) && (name == aName)) temp.add(Converters.converterAttachmentOBtoDTO(element));
        }
        return temp;
    }

    @Override
    public List<AttachmentDTO> findAttachmentByType(Type aType) {
        List<AttachmentOB> attachments = attachmentRepository.findAll();
        List<AttachmentDTO> temp = new ArrayList<AttachmentDTO>();
        for (AttachmentOB element : attachments){
            Type type = element.getType();
            if (type == aType) temp.add(Converters.converterAttachmentOBtoDTO(element));
        }
        return temp;
    }

    @Override
    public void deleteAttachmentById(Long aId) {
        attachmentRepository.delete(aId);
    }

    @Override
    public AttachmentDTO saveAttachment(AttachmentDTO aAttachmentDTO) {
        attachmentRepository.save(Converters.converterAttachmentDTOtoOB(aAttachmentDTO));
        return aAttachmentDTO;
    }
}
