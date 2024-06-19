package miu.edu.cse.adsdentalsurgeries.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Role role;
}
