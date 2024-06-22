package miu.edu.cse.adsdentalsurgeries.surgery.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.request.AddressRequestDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurgeryRequestDto {
    @NotEmpty(message = "Surgery name cannot be empty")
    private String surgeryName;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNumber;

    @NotNull(message = "Address cannot be null")
    private AddressRequestDto addressRequestDto;
}
