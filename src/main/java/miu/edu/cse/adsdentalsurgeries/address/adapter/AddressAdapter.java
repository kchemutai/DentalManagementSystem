package miu.edu.cse.adsdentalsurgeries.address.adapter;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.request.AddressRequestDto;
import miu.edu.cse.adsdentalsurgeries.address.dto.response.AddressResponseDto;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressAdapter {
    private final ModelMapper modelMapper;

    public AddressResponseDto convertAddressToAddressResponseDto(Address address) {
        return modelMapper.map(address, AddressResponseDto.class);
    }

    public Address convertAddressRequestDtoToAddress(AddressRequestDto addressRequestDto) {
        return modelMapper.map(addressRequestDto, Address.class);
    }

    public Address convertAddressResponseDtoToAddress(AddressResponseDto addressRequestDto) {
        return Address.builder()
                .street(addressRequestDto.getStreet())
                .city(addressRequestDto.getCity())
                .state(addressRequestDto.getState())
                .zip(addressRequestDto.getZip())
                .build();
//        return modelMapper.map(addressRequestDto, Address.class);
    }
}
