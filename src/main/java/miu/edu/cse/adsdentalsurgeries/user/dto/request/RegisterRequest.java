package miu.edu.cse.adsdentalsurgeries.user.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.cse.adsdentalsurgeries.user.model.Role;

@AllArgsConstructor
@Data
public class RegisterRequest {
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Size(min = 10, max = 10, message = "Phone number must be 10 digit US format")
    private String phoneNumber;

    @NotNull(message = "email cannot be empty")
    private String email;

    @NotNull(message = "Password cannot be null")
//    @Size(min = 6, max = 100, message = "Password should be at least 6 characters")
    private String password;

    @NotNull(message = "Role cannot be null or empty")
    private Role role;
}
