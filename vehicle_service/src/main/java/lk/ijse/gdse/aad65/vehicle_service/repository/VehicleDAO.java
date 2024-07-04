package lk.ijse.gdse.aad65.vehicle_service.repository;

import lk.ijse.gdse.aad65.vehicle_service.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDAO extends JpaRepository<VehicleEntity,String> {
    List<VehicleEntity>findByUserId(String userId);
}
