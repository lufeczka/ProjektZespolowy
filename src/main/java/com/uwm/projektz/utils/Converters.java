package com.uwm.projektz.utils;

import com.uwm.projektz.history.dto.HistoryDTO;
import com.uwm.projektz.history.ob.HistoryOB;
import com.uwm.projektz.permission.dto.PermissionDTO;
import com.uwm.projektz.permission.ob.PermissionOB;
import com.uwm.projektz.priority.dto.PriorityDTO;
import com.uwm.projektz.priority.ob.PriorityOB;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.project.ob.ProjectOB;
import com.uwm.projektz.role.dto.RoleDTO;
import com.uwm.projektz.role.ob.RoleOB;
import com.uwm.projektz.ticket.dto.TicketDTO;
import com.uwm.projektz.ticket.ob.TicketOB;
import com.uwm.projektz.user.ob.UserOB;
import com.uwm.projektz.user.dto.UserDTO;

import com.uwm.projektz.attachment.ob.AttachmentOB;
import com.uwm.projektz.attachment.dto.AttachmentDTO;

import com.uwm.projektz.binary.ob.BinaryOB;
import com.uwm.projektz.binary.dto.BinaryDTO;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;


public class Converters {
//Binary
    public static BinaryDTO converterBinaryOBtoDTO(BinaryOB aBinaryOB)
    {
        if (aBinaryOB == null) return null;

        return new BinaryDTO(aBinaryOB.getId(),aBinaryOB.getTechDate(),aBinaryOB.getBinary());
    }

    public static BinaryOB converterBinaryDTOtoOB(BinaryDTO aBinaryDTO)
    {
        if (aBinaryDTO == null) return null;

        return new BinaryOB(aBinaryDTO.getId(),aBinaryDTO.getTechDate(),aBinaryDTO.getBinary());
    }
//BinaryLists
    public static List<BinaryDTO> converterBinaryListOBtoDTO(List<BinaryOB> aBinaryListOB){
        if (aBinaryListOB == null) return null;
        List<BinaryDTO> temp = new ArrayList<BinaryDTO>();
        for (BinaryOB element : aBinaryListOB){
            temp.add(converterBinaryOBtoDTO(element));
        }
        return temp;
    }
    public static List<BinaryOB> converterBinaryListDTOtoOB(List<BinaryDTO> aBinaryListDTO){
        if (aBinaryListDTO == null) return null;
        List<BinaryOB> temp = new ArrayList<BinaryOB>();
        for (BinaryDTO element : aBinaryListDTO){
            temp.add(converterBinaryDTOtoOB(element));
        }
        return temp;
    }

//User
    public static UserDTO converterUserOBtoDTO(UserOB aUserOB)
    {
        if (aUserOB == null) return null;

        return new UserDTO(aUserOB.getId(),aUserOB.getTechDate(),aUserOB.getName(),aUserOB.getSurname(),aUserOB.getEmail(),aUserOB.getLogin(),aUserOB.getMd5pass(),aUserOB.getActive(),converterRoleOBtoDTO(aUserOB.getRole()),converterProjectListOBtoDTO(aUserOB.getProjects()),converterPermissionListOBtoDTO(aUserOB.getPermissions()));
    }

    public static UserOB converterUserDTOtoOB(UserDTO aUserDTO){
        if (aUserDTO == null) return null;

        return new UserOB(aUserDTO.getId(),aUserDTO.getTechDate(),aUserDTO.getName(),aUserDTO.getSurname(),aUserDTO.getEmail(),aUserDTO.getLogin(),aUserDTO.getMd5pass(),aUserDTO.getActive(),converterRoleDTOtoOB(aUserDTO.getRole()), converterProjectListDTOtoOB(aUserDTO.getProjects()),converterPermissionListDTOtoOB(aUserDTO.getPermissions()));

    }

//Role
    public static RoleDTO converterRoleOBtoDTO(RoleOB aRoleOb)
    {
        if (aRoleOb == null) return null;
        return new RoleDTO(aRoleOb.getId(),aRoleOb.getTechDate(),aRoleOb.getName(),converterPermissionListOBtoDTO(aRoleOb.getPermissions()));
    }

    public static RoleOB converterRoleDTOtoOB(RoleDTO aRoleDTO)
    {
        if (aRoleDTO == null) return null;
        return new RoleOB(aRoleDTO.getId(),aRoleDTO.getTechDate(),aRoleDTO.getName(),converterPermissionListDTOtoOB(aRoleDTO.getPermissions()));
    }
//RoleLists
    public static List<RoleDTO> converterRoleListOBtoDTO (List<RoleOB> aRoleListOB){
        if (aRoleListOB == null) return null;
        List<RoleDTO> temp = new ArrayList<RoleDTO>();

        for (RoleOB element : aRoleListOB){
            temp.add(converterRoleOBtoDTO(element));
        }
        return temp;
    }

    public static List<RoleOB> converterRoleListDTOtoOB (List<RoleDTO> aRoleListDTO){
        if (aRoleListDTO == null) return null;
        List<RoleOB> temp = new ArrayList<RoleOB>();

        for (RoleDTO element : aRoleListDTO){
            temp.add(converterRoleDTOtoOB(element));
        }
        return temp;
    }

//Permission
    public static PermissionDTO converterPermissionOBtoDTO(PermissionOB aPermissionOB)
    {
        if (aPermissionOB == null) return null;
        return new PermissionDTO(aPermissionOB.getId(),aPermissionOB.getTechDate(),aPermissionOB.getName());
    }
    public static PermissionOB converterPermissionDTOtoOB(PermissionDTO aPermissionDTO)
    {
        if (aPermissionDTO == null) return null;
        return new PermissionOB(aPermissionDTO.getId(),aPermissionDTO.getTechDate(),aPermissionDTO.getName());
    }
    //Permission Listy
    public static List<PermissionOB> converterPermissionListDTOtoOB(List<PermissionDTO> aPermissionList)
    {
        if (aPermissionList == null) return null;
        List<PermissionOB> temp = new ArrayList<PermissionOB>();

        for(PermissionDTO element : aPermissionList)
        {
            temp.add(converterPermissionDTOtoOB(element));
        }
        return temp;
    }
    public static List<PermissionDTO> converterPermissionListOBtoDTO(List<PermissionOB> aPermissionList)
    {
        if (aPermissionList == null) return null;
        List<PermissionDTO> temp = new ArrayList<PermissionDTO>();

        for(PermissionOB element : aPermissionList)
        {
            temp.add(converterPermissionOBtoDTO(element));
        }
        return temp;
    }

//Projects
    public static ProjectDTO converterProjectOBtoDTO (ProjectOB aProjectOB){
        if (aProjectOB == null) return null;
        return new ProjectDTO(aProjectOB.getId(),aProjectOB.getTechDate(),aProjectOB.getName(),aProjectOB.getDescritpion(),aProjectOB.getVersion(),converterPriorityOBtoDTO(aProjectOB.getPriority()));
    }

    public static ProjectOB converterProjectDTOtoOB(ProjectDTO aProjectDTO){
        if (aProjectDTO == null) return null;
        return new ProjectOB(aProjectDTO.getId(),aProjectDTO.getTechDate(),aProjectDTO.getName(),aProjectDTO.getDescritpion(),aProjectDTO.getVersion(),converterPriorityDTOtoOB(aProjectDTO.getPriority()));
    }
    //ProjectsLists
    public static List<ProjectDTO> converterProjectListOBtoDTO (List<ProjectOB> aProjectList){
        if (aProjectList == null) return null;
        List<ProjectDTO> temp = new ArrayList<ProjectDTO>();

        for(ProjectOB element : aProjectList)
        {
            temp.add(converterProjectOBtoDTO(element));
        }
        return temp;
    }

    public static List<ProjectOB> converterProjectListDTOtoOB (List<ProjectDTO> aProjectList){
        if (aProjectList == null) return null;
        List<ProjectOB> temp = new ArrayList<ProjectOB>();

        for(ProjectDTO element : aProjectList)
        {
            temp.add(converterProjectDTOtoOB(element));
        }
        return temp;
    }

//Priority
    public static PriorityDTO converterPriorityOBtoDTO(PriorityOB aPriorityOB){
        if (aPriorityOB == null) return null;
        return new PriorityDTO(aPriorityOB.getId(),aPriorityOB.getTechDate(),aPriorityOB.getName(),aPriorityOB.getResponseTime());
    }
    public static PriorityOB converterPriorityDTOtoOB(PriorityDTO aPriorityDTO){
        if (aPriorityDTO == null) return null;
        return new PriorityOB(aPriorityDTO.getId(),aPriorityDTO.getTechDate(),aPriorityDTO.getName(),aPriorityDTO.getResponseTime());
    }
//PriorityLists
    public static List<PriorityDTO> converterPriorityListOBtoDTO(List<PriorityOB> aPriorityListOB){
        if (aPriorityListOB == null) return null;
        List<PriorityDTO> temp = new ArrayList<PriorityDTO>();

        for (PriorityOB element : aPriorityListOB){
            temp.add(converterPriorityOBtoDTO(element));
        }
        return temp;
    }

    public static List<PriorityOB> converterPriorityListDTOtoOB(List<PriorityDTO> aPriorityListDTO){
        if (aPriorityListDTO == null) return null;
        List<PriorityOB> temp = new ArrayList<PriorityOB>();

        for (PriorityDTO element : aPriorityListDTO){
            temp.add(converterPriorityDTOtoOB(element));
        }
        return temp;
    }

//Attachment
    public static AttachmentDTO converterAttachmentOBtoDTO(AttachmentOB aAttachmentOB) {
        if (aAttachmentOB == null) return null;
        return new AttachmentDTO(aAttachmentOB.getId(),aAttachmentOB.getTechDate(),aAttachmentOB.getType(),aAttachmentOB.getName(),aAttachmentOB.getFile_name(),aAttachmentOB.getMine_type(),converterBinaryOBtoDTO((aAttachmentOB.getBinary())),converterUserOBtoDTO(aAttachmentOB.getUser()));
    }

    public static AttachmentOB converterAttachmentDTOtoOB(AttachmentDTO aAttachmentDTO){
        if (aAttachmentDTO == null) return null;
        return new AttachmentOB(aAttachmentDTO.getId(),aAttachmentDTO.getTechDate(),aAttachmentDTO.getType(),aAttachmentDTO.getName(),aAttachmentDTO.getFile_name(),aAttachmentDTO.getMine_type(),converterBinaryDTOtoOB(aAttachmentDTO.getBinary()),converterUserDTOtoOB(aAttachmentDTO.getUser()));
    }
//AttachmentLists
    public static List<AttachmentDTO> converterAttachmentListOBtoDTO(List<AttachmentOB> aAttachmentOBList){
        if (aAttachmentOBList == null) return null;
        List<AttachmentDTO> temp = new ArrayList<AttachmentDTO>();

        for (AttachmentOB element : aAttachmentOBList)
        {
            temp.add(converterAttachmentOBtoDTO(element));
        }

        return temp;
    }

    public static List<AttachmentOB> converterAttachmentListDTOtoOB(List<AttachmentDTO> aAttachmentDTOList){
        if (aAttachmentDTOList == null) return null;
        List<AttachmentOB> temp = new ArrayList<AttachmentOB>();

        for (AttachmentDTO element : aAttachmentDTOList)
        {
            temp.add(converterAttachmentDTOtoOB(element));
        }
        return temp;
    }

//History
    public static HistoryDTO converterHistoryOBtoDTO(HistoryOB aHistoryOB){
        if (aHistoryOB == null) return null;
        return new HistoryDTO(aHistoryOB.getId(),aHistoryOB.getTechDate(),aHistoryOB.getType(),converterUserOBtoDTO(aHistoryOB.getUser()),aHistoryOB.getDescription(),aHistoryOB.getDate(),converterAttachmentListOBtoDTO(aHistoryOB.getAttachments()));
    }

    public static HistoryOB converterHistoryDTOtoOB(HistoryDTO aHistoryDTO){
        if (aHistoryDTO == null) return null;
        return new HistoryOB(aHistoryDTO.getId(),aHistoryDTO.getTechDate(),aHistoryDTO.getType(),converterUserDTOtoOB(aHistoryDTO.getUser()),aHistoryDTO.getDescription(),aHistoryDTO.getDate(),converterAttachmentListDTOtoOB(aHistoryDTO.getAttachments()));
    }
//HistoryList
    public static List<HistoryDTO> converterHistoryListOBtoDTO(List<HistoryOB> aHistoryOBList){
        if (aHistoryOBList == null) return null;
        List<HistoryDTO> temp = new ArrayList<HistoryDTO>();

        for (HistoryOB element : aHistoryOBList){
            temp.add(converterHistoryOBtoDTO(element));
        }
        return temp;
    }

    public static List<HistoryOB> converterHistoryListDTOtoOB(List<HistoryDTO> aHistoryDTOList){
        if (aHistoryDTOList == null) return null;
        List<HistoryOB> temp = new ArrayList<HistoryOB>();

        for (HistoryDTO element : aHistoryDTOList){
            temp.add(converterHistoryDTOtoOB(element));
        }
        return temp;
    }

//Ticket
    public static TicketDTO converterTicketOBtoDTO(TicketOB aTicketOB){
        if (aTicketOB == null) return null;
        return new TicketDTO(aTicketOB.getId(),aTicketOB.getTechDate(),aTicketOB.getKind(),aTicketOB.getType(),aTicketOB.getDescription(),converterUserOBtoDTO(aTicketOB.getUser()),converterPriorityOBtoDTO(aTicketOB.getPriority()),converterProjectOBtoDTO(aTicketOB.getProject()),converterHistoryListOBtoDTO(aTicketOB.getHistories()),converterAttachmentListOBtoDTO(aTicketOB.getAttachments()));
    }

    public static TicketOB converterTicketDTOtoOB(TicketDTO aTicketDTO) {
        if (aTicketDTO == null) return null;
        return new TicketOB(aTicketDTO.getId(), aTicketDTO.getTechDate(), aTicketDTO.getKind(), aTicketDTO.getType(), aTicketDTO.getDescription(), converterUserDTOtoOB(aTicketDTO.getUser()), converterPriorityDTOtoOB(aTicketDTO.getPriority()), converterProjectDTOtoOB(aTicketDTO.getProject()), converterHistoryListDTOtoOB(aTicketDTO.getHistories()), converterAttachmentListDTOtoOB(aTicketDTO.getAttachments()));
    }
//TicketLists
    public static List<TicketDTO> converterTicketListOBtoDTO (List<TicketOB> aTicketListOB){
        if (aTicketListOB == null) return null;
        List<TicketDTO> temp = new ArrayList<TicketDTO>();

        for (TicketOB element : aTicketListOB){
            temp.add(converterTicketOBtoDTO(element));
        }
        return temp;
    }

    public static List<TicketOB> converterTicketListDTOtoOB (List<TicketDTO> aTicketListDTO){
        if (aTicketListDTO == null) return null;
        List<TicketOB> temp = new ArrayList<TicketOB>();

        for (TicketDTO element : aTicketListDTO){
            temp.add(converterTicketDTOtoOB(element));
        }
        return temp;
    }

}