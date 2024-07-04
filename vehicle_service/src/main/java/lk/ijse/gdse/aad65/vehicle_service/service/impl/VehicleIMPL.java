package lk.ijse.gdse.aad65.vehicle_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad65.vehicle_service.convertion.ConversionData;
import lk.ijse.gdse.aad65.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse.aad65.vehicle_service.entity.VehicleEntity;
import lk.ijse.gdse.aad65.vehicle_service.repository.VehicleDAO;
import lk.ijse.gdse.aad65.vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public VehicleDTO getVehicle(String id) {
        return conversionData.mapTo(vehicleDAO.findById(id).get(), VehicleDTO.class);
    }

    @Override
    public Object getAllVehicles() {
        return conversionData.mapTo(vehicleDAO.findAll(), VehicleDTO.class);
    }
    @Override
    public void updateVehicle(String id, VehicleDTO vehicleDTO) {
        if (!vehicleDAO.existsById(vehicleDTO.getVehicleCode())) {
            return;
        }
        vehicleDAO.save(conversionData.mapTo(vehicleDTO, VehicleEntity.class));
    }

    @Override
    public void deleteVehicle(String id) {
        vehicleDAO.deleteById(id);
    }


    @Override
    public List<VehicleDTO> getVehicleByUserId(String userId) {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        List<VehicleEntity> vehicles = vehicleDAO.findByUserId(userId);
        for (VehicleEntity vehicle : vehicles) {
            vehicleDTOs.add(conversionData.mapTo(vehicle, VehicleDTO.class));
        }
        return vehicleDTOs;
    }

    @Override
    public boolean isVehicleExists(String vehicleId) {
        return vehicleDAO.existsById(vehicleId);
    }


}
