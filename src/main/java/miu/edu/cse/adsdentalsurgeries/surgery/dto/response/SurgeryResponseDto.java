package miu.edu.cse.adsdentalsurgeries.surgery.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.response.AddressResponseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurgeryResponseDto {
    private String surgeryName;
    private String phoneNumber;
    private AddressResponseDto addressResponseDto;
}
