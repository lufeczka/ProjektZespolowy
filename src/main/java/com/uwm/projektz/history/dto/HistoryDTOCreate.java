package com.uwm.projektz.history.dto;

import com.uwm.projektz.attachment.dto.AttachmentDTO;
import com.uwm.projektz.enums.Type;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.dto.UserDTOId;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-05-12.
 */

@ApiModel
public class HistoryDTOCreate implements Serializable {
    Long id;
    Type type;
    UserDTOId user;
    String description;
    Date date;
    List<AttachmentDTO> attachments;
}
