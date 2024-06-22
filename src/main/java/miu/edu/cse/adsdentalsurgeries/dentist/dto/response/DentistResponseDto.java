package miu.edu.cse.adsdentalsurgeries.dentist.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DentistResponseDto {
    private String specialization;
    private UserResponseDto userResponseDto;
}
