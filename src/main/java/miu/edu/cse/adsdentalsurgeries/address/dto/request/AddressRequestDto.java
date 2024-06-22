package miu.edu.cse.adsdentalsurgeries.address.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto {
    @NotEmpty(message = "Street cannot be null or empty")
    private String street;

    @NotEmpty(message = "City cannot be null or empty")
    private String city;

    @NotEmpty(message = "State cannot be null or empty")
    private String state;

    @NotEmpty(message = "Zip cannot be null or empty")
    private String  zip;
}
