package lk.ijse.gdse.aad65.vehicle_service.controller;

import lk.ijse.gdse.aad65.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse.aad65.vehicle_service.service.UserServiceClient;
import lk.ijse.gdse.aad65.vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
@Slf4j
public class VehicleController {

    private final VehicleService vehicleService;
    private final UserServiceClient userServiceClient;

    @GetMapping("/health")
    public String healthCheck(){
        return "Vehicle Service Health";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicleDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (!userServiceClient.isExitsUser(vehicleDTO.getUserId())) {
            return ResponseEntity.badRequest().body("User not found");
        }
        VehicleDTO savedVehicle = vehicleService.saveVehicle(vehicleDTO);
        return ResponseEntity.ok(savedVehicle);
    }

}
