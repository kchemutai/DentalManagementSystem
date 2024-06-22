package miu.edu.cse.adsdentalsurgeries.patient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.response.AddressResponseDto;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDto {
    private AddressResponseDto addressResponseDto;
    private UserResponse userResponse;
}
