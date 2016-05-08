package com.uwm.projektz.ticket.service.impl;

import com.uwm.projektz.attachment.converter.AttachmentConverter;
import com.uwm.projektz.attachment.dto.AttachmentDTO;
import com.uwm.projektz.attachment.ob.AttachmentOB;
import com.uwm.projektz.attachment.repository.IAttachmentRepository;
import com.uwm.projektz.enums.TicketType;
import com.uwm.projektz.enums.Type;
import com.uwm.projektz.history.converter.HistoryConverter;
import com.uwm.projektz.history.dto.HistoryDTO;
import com.uwm.projektz.history.ob.HistoryOB;
import com.uwm.projektz.priority.converter.PriorityConverter;
import com.uwm.projektz.priority.dto.PriorityDTO;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.ticket.converter.TicketConverter;
import com.uwm.projektz.ticket.dto.TicketDTO;
import com.uwm.projektz.ticket.ob.TicketOB;
import com.uwm.projektz.ticket.repository.ITicketRepository;
import com.uwm.projektz.ticket.service.ITicketService;
import com.uwm.projektz.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@Service
@Transactional
public class ITicketServiceImpl implements ITicketService {

    @Autowired
    ITicketRepository ticketRepository;

    @Override
    public TicketDTO saveTicket(TicketDTO aTicketDTO) {
        ticketRepository.save(TicketConverter.converterTicketDTOtoOB(aTicketDTO));
        return aTicketDTO;
    }

    @Override
    public TicketDTO findTicketById(Long aId) {
        return TicketConverter.converterTicketOBtoDTO(ticketRepository.findOne(aId));
    }

    @Override
    public List<TicketDTO> findByTicketsType(TicketType aTicketType) {
        List<TicketOB> ticket = ticketRepository.findByTicketType(aTicketType);
        return TicketConverter.converterTicketListOBtoDTO(ticket);
    }

    @Override
    public List<TicketDTO> findByType(Type aType) {
        List<TicketOB> tickets = ticketRepository.findByType(aType);
        return TicketConverter.converterTicketListOBtoDTO(tickets);

    }

    @Override
    public List<TicketDTO> findTicketsByUser(UserDTO aUserDTO) {
        List<TicketOB> tickets = ticketRepository.findByUser(aUserDTO.getId());
        return TicketConverter.converterTicketListOBtoDTO(tickets);
    }

    @Override
    public List<TicketDTO> findTicketsByPriority(PriorityDTO aPriorityDTO) {
        List<TicketOB> tickets = ticketRepository.findByPriority(PriorityConverter.converterPriorityDTOtoOB(aPriorityDTO));
        return TicketConverter.converterTicketListOBtoDTO(tickets);
    }

    @Override
    public List<TicketDTO> findTicketsByProjects(ProjectDTO aProjectDTO) {
        List<TicketOB> tickets = ticketRepository.findByProject(aProjectDTO.getId());
        return TicketConverter.converterTicketListOBtoDTO(tickets);
    }

    @Override
    public TicketDTO updateDescriptionForTicket(Long aId, String aDescription) {
        TicketOB ticket = ticketRepository.findOne(aId);
        ticket.setDescription(aDescription);
        ticketRepository.save(ticket);
        return TicketConverter.converterTicketOBtoDTO(ticket);
    }

    @Override
    public TicketDTO updateHistoryTicket(Long aId, HistoryDTO aHistoryDTO) {
        TicketOB ticket = ticketRepository.findOne(aId);
        List<HistoryOB> histories = ticket.getHistories();
        histories.add(HistoryConverter.converterHistoryDTOtoOB(aHistoryDTO));
        ticket.setHistories(histories);
        ticketRepository.save(ticket);
        return TicketConverter.converterTicketOBtoDTO(ticket);
    }

    @Override
    public TicketDTO updateAttachemntForTicket(Long aId, AttachmentDTO aAtachmentDTO) {
        TicketOB ticket = ticketRepository.findOne(aId);
        List<AttachmentOB> attachments = ticket.getAttachments();
        attachments.add(AttachmentConverter.converterAttachmentDTOtoOB(aAtachmentDTO));
        ticket.setAttachments(attachments);
        ticketRepository.save(ticket);
        return TicketConverter.converterTicketOBtoDTO(ticket);
    }

    @Override
    public TicketDTO updateTicketTypeAndKind(Long aId, TicketType aTicketType, Type aKind) {
        TicketOB ticket = ticketRepository.findOne(aId);
        ticket.setKind(aTicketType);
        ticket.setType(aKind);
        ticketRepository.save(ticket);
        return TicketConverter.converterTicketOBtoDTO(ticket);
    }

    @Override
    public void deletTicketById(Long aId) {
        ticketRepository.delete(aId);
    }

    @Override
    public List<TicketDTO> findAll() {
        List<TicketOB> tickets = ticketRepository.findAll();
        return TicketConverter.converterTicketListOBtoDTO(tickets);
    }
}
