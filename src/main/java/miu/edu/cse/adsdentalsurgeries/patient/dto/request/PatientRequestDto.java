package miu.edu.cse.adsdentalsurgeries.patient.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.request.AddressRequestDto;
import miu.edu.cse.adsdentalsurgeries.user.dto.request.UserRequestDto;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PatientRequestDto {
    private AddressRequestDto addressRequestDto;
    private UserRequestDto userRequestDto;
}
