package miu.edu.cse.adsdentalsurgeries.address.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDto {
    private String street;
    private String city;
    private String state;
    private String  zip;
}
