package lk.ijse.gdse.aad65.repository;

import lk.ijse.gdse.aad65.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketDAO extends JpaRepository<TicketEntity,String > {
    List<TicketEntity> findAllByUserId(String userId);

    List<TicketEntity> findAllByVehicleId(String vehicleId);
}
