package lk.ijse.gdse.aad65.repository;

import lk.ijse.gdse.aad65.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceDAO extends JpaRepository<UserEntity,String> {
    UserEntity findFirstByOrderByUserCodeDesc();
}
