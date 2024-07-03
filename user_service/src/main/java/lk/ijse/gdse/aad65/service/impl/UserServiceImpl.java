package lk.ijse.gdse.aad65.service.impl;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lk.ijse.gdse.aad65.convertion.ConversionData;
import lk.ijse.gdse.aad65.dto.UserDTO;
import lk.ijse.gdse.aad65.entity.UserEntity;
import lk.ijse.gdse.aad65.repository.UserServiceDAO;
import lk.ijse.gdse.aad65.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserServiceDAO userServiceDAO;
    private  final ConversionData conversionData;


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
         userServiceDAO.save(conversionData.mapTo(userDTO, UserEntity.class));
        return userDTO;
    }

    @Override
    public Object getUser(String id) {
        if(!userServiceDAO.existsById(id))throw new NotFoundException("User Not Found");
        return conversionData.mapTo(userServiceDAO.findById(id).get(),UserDTO.class);
    }

    @Override
    public Object getAllUser() {
        return conversionData.mapTo(userServiceDAO.findAll(), UserDTO.class);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if(!userServiceDAO.existsById(userDTO.getUserId())){
            return;
        }
        userServiceDAO.save(conversionData.mapTo(userDTO, UserEntity.class));
    }


    @Override
    public boolean isUserExists(String userId) {
        return userServiceDAO.existsById(userId);
    }

    private String generateUserCode() {
        UserEntity firstByOrderByUserCodeDesc = userServiceDAO.findFirstByOrderByUserCodeDesc();
        return (firstByOrderByUserCodeDesc != null)
                ? String.format("User-%03d", Integer.parseInt(firstByOrderByUserCodeDesc.getUserCode().replace("User-", "")) + 1)
                : "User-001";
    }
}
