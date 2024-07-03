package lk.ijse.gdse.aad65.vehicle_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad65.vehicle_service.convertion.ConversionData;
import lk.ijse.gdse.aad65.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse.aad65.vehicle_service.entity.VehicleEntity;
import lk.ijse.gdse.aad65.vehicle_service.repository.VehicleDAO;
import lk.ijse.gdse.aad65.vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class VehicleIMPL implements VehicleService {
    private final VehicleDAO vehicleDAO;
    private ConversionData conversionData;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        VehicleEntity vehicle = conversionData.mapTo(vehicleDTO, VehicleEntity.class);
       vehicleDAO.save(vehicle);
        return vehicleDTO;
    }
}
