package lk.ijse.gdse.aad65.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.aad65.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String userCode;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String nic;
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;
}
