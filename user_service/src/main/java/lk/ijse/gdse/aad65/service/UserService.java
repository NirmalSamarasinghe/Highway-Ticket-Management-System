package lk.ijse.gdse.aad65.service;

import lk.ijse.gdse.aad65.dto.UserDTO;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);


    boolean isUserExists(String userId);

    Object getUser(String id);

    Object getAllUser();


    void updateUser(UserDTO userDTO);
}
