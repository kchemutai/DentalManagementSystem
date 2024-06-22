package miu.edu.cse.adsdentalsurgeries.dentist.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.dto.request.UserRequestDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DentistRequestDto {
    @NotNull(message = "Specialisation cannot be null or empty")
    private String specialization;

    @NotNull(message = "User details cannot be null")
    private UserRequestDto userRequestDto;
}
