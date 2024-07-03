package lk.ijse.gdse.aad65.controller;

import lk.ijse.gdse.aad65.dto.UserDTO;
import lk.ijse.gdse.aad65.entity.UserEntity;
import lk.ijse.gdse.aad65.repository.UserServiceDAO;
import lk.ijse.gdse.aad65.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class User_Controller {
    private final UserServiceDAO userServiceDAO;
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    @GetMapping("/health")
    public String health(){
        return "User Health";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@Validated @RequestBody UserDTO userDTO,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            userService.saveUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | User saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        userService.updateUser(userDTO);
        return ResponseEntity.ok("user updated successfully");
    }



    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable ("id") String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<?>getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/userExists/{userId}")
    public ResponseEntity<?> isUserExists(@PathVariable String userId) {
        logger.info("Checking user existence with ID: {}", userId);
        try {
            boolean isUserExists = userService.isUserExists(userId);
            logger.info("User Exists: {}", isUserExists);
            return ResponseEntity.ok(isUserExists);
        } catch (Exception exception) {
            logger.error("Error checking user existence: ", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to check user existence.\nMore Details\n" + exception);
        }
    }
}
