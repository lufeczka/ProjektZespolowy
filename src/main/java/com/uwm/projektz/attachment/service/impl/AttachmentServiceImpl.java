package com.uwm.projektz.attachment.service.impl;

import com.uwm.projektz.attachment.dto.AttachmentDTO;
import com.uwm.projektz.attachment.service.IAttachmentSerivce;
import com.uwm.projektz.enums.Type;
import com.uwm.projektz.user.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@Service
@Transactional
public class AttachmentServiceImpl implements IAttachmentSerivce {

    @Override
    public AttachmentDTO findAttachmentById(Long aId) {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAllAttachment() {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAllAttachmentsForUser(UserDTO aUserDTO) {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAttachmentByName(String aName) {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAAtachmentsByFileName(String aFile_Name) {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAttachmentByMineType(String aMineType) {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAAtachemntByMineTypeAndName(String aMineType, String aName) {
        return null;
    }

    @Override
    public List<AttachmentDTO> findAttachmentByType(Type aType) {
        return null;
    }

    @Override
    public void deleteAttachmentById(Long aId) {

    }

    @Override
    public AttachmentDTO saveAttachment(AttachmentDTO aAttachmentDTO) {
        return null;
    }
}
