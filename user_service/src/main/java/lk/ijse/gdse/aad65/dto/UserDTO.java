package lk.ijse.gdse.aad65.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String contact;
    private String address;
}
