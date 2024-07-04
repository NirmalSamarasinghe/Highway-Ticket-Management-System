package lk.ijse.gdse.aad65.service;

import lk.ijse.gdse.aad65.dto.TicketDTO;

public interface TicketService {
    void saveTicket(TicketDTO ticketDTO);

    Object getTicket(String ticketId);

    Object getAllTickets();

    void updateTicket(TicketDTO ticketDTO);

    void deleteTicket(String ticketId);

    Object getTicketsByUserId(String userId);

    Object getTicketsByVehicleId(String vehicleId);

    boolean isTicketExists(String ticketId);
}
