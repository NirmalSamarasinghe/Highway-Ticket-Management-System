package lk.ijse.gdse.aad65.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad65.convertionData.Conversion;
import lk.ijse.gdse.aad65.dto.TicketDTO;
import lk.ijse.gdse.aad65.entity.TicketEntity;
import lk.ijse.gdse.aad65.repository.TicketDAO;
import lk.ijse.gdse.aad65.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Transactional
@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketDAO ticketDao;
    private final Conversion mapping;
    @Override
    public void saveTicket(TicketDTO ticketDTO) {
        ticketDao.save(mapping.toTicketEntity(ticketDTO));
    }

    @Override
    public Object getTicket(String ticketId) {
        return mapping.toTicketDTO(ticketDao.findById(ticketId));
    }

    @Override
    public Object getAllTickets() {
        return mapping.toTicketDTOList(ticketDao.findAll());
    }

    @Override
    public void updateTicket(TicketDTO ticketDTO) {
        if (!ticketDao.existsById(ticketDTO.getTicketId())){
            return;
        }
        ticketDao.save(mapping.toTicketEntity(ticketDTO));
    }

    @Override
    public void deleteTicket(String ticketId) {
        ticketDao.deleteById(ticketId);
    }

    @Override
    public List<TicketDTO> getTicketsByUserId(String userId) {
        List<TicketDTO> tickeDTOs = new ArrayList<>();
        List<TicketEntity> tickets = ticketDao.findAllByUserId(userId);
        for (TicketEntity ticket : tickets) {
            tickeDTOs.add(mapping.toTicketDTO(Optional.ofNullable(ticket)));
        }
        return tickeDTOs;
    }

    @Override
    public Object getTicketsByVehicleId(String vehicleId) {
        List<TicketDTO> tickeDTOs = new ArrayList<>();
        List<TicketEntity> tickets = ticketDao.findAllByVehicleId(vehicleId);
        for (TicketEntity ticket : tickets) {
            tickeDTOs.add(mapping.toTicketDTO(Optional.ofNullable(ticket)));
        }
        return tickeDTOs;
    }

    @Override
    public boolean isTicketExists(String ticketId) {
        return ticketDao.existsById(ticketId);
    }
}
