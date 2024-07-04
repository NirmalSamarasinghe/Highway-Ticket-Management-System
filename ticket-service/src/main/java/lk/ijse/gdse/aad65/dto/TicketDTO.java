package lk.ijse.gdse.aad65.dto;

import lk.ijse.gdse.aad65.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDTO {
    private String ticketId;
    private LocalDate ticketIssueDate;
    private Status status;
    private String vehicleId;
    private String userId;
}
