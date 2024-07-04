package lk.ijse.gdse.aad65.service.impl;

import lk.ijse.gdse.aad65.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class VehicleServiceIIMPL implements VehicleService {
    private static final Logger logger = LoggerFactory.getLogger(UserClientServiceIMPL.class);
    private final RestTemplate restTemplate;

    @Override
    public boolean isExitsVehicle(String vehicleId) {
        try {
            String url = "http://vehicle-service/api/v1/vehicle/vehicleExists/" + vehicleId;
            Boolean vehicleExists = restTemplate.getForObject(url, Boolean.class);
            logger.info("Vehicle Exists: {}", vehicleExists);
            return vehicleExists != null && vehicleExists;
        } catch (Exception e) {
            logger.error("Error checking if vehicle exists", e);
        }
        return false;
    }
}
