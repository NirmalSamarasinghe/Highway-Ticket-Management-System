package lk.ijse.gdse.aad65.vehicle_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String vehicleCode;
    private String registrationNumber;
    private String ownerName;
    private String model;
    private String color;
    private String userId;
}
