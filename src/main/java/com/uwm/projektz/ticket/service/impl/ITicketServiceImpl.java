package com.uwm.projektz.ticket.service.impl;

import com.uwm.projektz.attachment.dto.AttachmentDTO;
import com.uwm.projektz.attachment.repository.IAttachmentRepository;
import com.uwm.projektz.enums.TicketType;
import com.uwm.projektz.enums.Type;
import com.uwm.projektz.history.dto.HistoryDTO;
import com.uwm.projektz.priority.dto.PriorityDTO;
import com.uwm.projektz.project.dto.ProjectDTO;
import com.uwm.projektz.ticket.dto.TicketDTO;
import com.uwm.projektz.ticket.ob.TicketOB;
import com.uwm.projektz.ticket.repository.ITicketRepository;
import com.uwm.projektz.ticket.service.ITicketService;
import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.utils.Converters;
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
        ticketRepository.save(Converters.converterTicketDTOtoOB(aTicketDTO));
        return aTicketDTO;
    }

    @Override
    public TicketDTO findTicketById(Long aId) {
        return Converters.converterTicketOBtoDTO(ticketRepository.findOne(aId));
    }

    @Override
    public List<TicketDTO> findByTicketsType(TicketType aTicketType) {
        List<TicketOB> ticket = ticketRepository.findByTicketType(aTicketType);
        return Converters.converterTicketListOBtoDTO(ticket);
    }

    @Override
    public List<TicketDTO> findByType(Type aType) {
        List<TicketOB> tickets = ticketRepository.findByType(aType);
        return Converters.converterTicketListOBtoDTO(tickets);

    }

    @Override
    public List<TicketDTO> findTicketsByUser(UserDTO aUserDTO) {
        return null;
    }

    @Override
    public List<TicketDTO> findTicketsByPriority(PriorityDTO aPriorityDTO) {
        return null;
    }

    @Override
    public List<TicketDTO> findTicketsByProjects(ProjectDTO aProjectDTO) {
        return null;
    }

    @Override
    public TicketDTO updateDescriptionForTicket(Long aId, String aDescription) {
        return null;
    }

    @Override
    public TicketDTO updateHistoryTicket(Long aId, HistoryDTO aHistoryDTO) {
        return null;
    }

    @Override
    public TicketDTO updateAttachemntForTicket(Long aId, AttachmentDTO aAtachmentDTO) {
        return null;
    }

    @Override
    public TicketDTO updateTicketTypeAndKind(Long aId, TicketType aTicketType, Type aKind) {
        return null;
    }

    @Override
    public void deletTicketById(Long aId) {

    }

    @Override
    public List<TicketDTO> findAll() {
        return null;
    }
}
