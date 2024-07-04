package lk.ijse.gdse.aad65.vehicle_service.service;

import lk.ijse.gdse.aad65.vehicle_service.dto.VehicleDTO;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    Object getVehicle(String id);

    Object getAllVehicles();

    void deleteVehicle(String id);

    void updateVehicle(String id, VehicleDTO vehicleDTO);

    Object getVehicleByUserId(String userId);

    boolean isVehicleExists(String vehicleId);
}
