package miu.edu.cse.adsdentalsurgeries.surgery.adapter;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.request.SurgeryRequestDto;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.response.SurgeryResponseDto;
import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurgeryAdapter {
    private final AddressAdapter addressAdapter;

    public SurgeryResponseDto convertSurgeryToDto(Surgery surgery) {
       return SurgeryResponseDto.builder()
               .surgeryName(surgery.getSurgeryName())
               .phoneNumber(surgery.getPhoneNumber())
               .addressResponseDto(addressAdapter.convertAddressToAddressResponseDto(surgery.getAddress()))
               .build();
    }

    public Surgery convertRequestDtoToSurgery(SurgeryRequestDto surgeryRequestDto) {
        return Surgery.builder()
                .surgeryName(surgeryRequestDto.getSurgeryName())
                .phoneNumber(surgeryRequestDto.getPhoneNumber())
                .address(addressAdapter.convertAddressRequestDtoToAddress(surgeryRequestDto.getAddressRequestDto()))
                .build();
    }
}
