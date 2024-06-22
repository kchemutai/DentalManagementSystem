package miu.edu.cse.adsdentalsurgeries.address.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.address.dto.request.AddressRequestDto;
import miu.edu.cse.adsdentalsurgeries.address.dto.response.AddressResponseDto;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.address.repository.AddressRepository;
import miu.edu.cse.adsdentalsurgeries.address.service.AddressService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
	
	private final AddressRepository addressRepository;
	private final AddressAdapter addressAdapter;

	@Override
	public Optional<AddressResponseDto> createNewAddress(AddressRequestDto addressRequestDto) {
		Address Address = addressAdapter.convertAddressRequestDtoToAddress(addressRequestDto);
		Address savedAddress = addressRepository.save(Address);
		AddressResponseDto addressResponseDto = addressAdapter.convertAddressToAddressResponseDto(savedAddress);
		return Optional.of(addressResponseDto);
	}

	@Override
	public Optional<List<AddressResponseDto>> findAddresses() {
		List<Address> addresses = addressRepository.findAll();
		if (addresses.isEmpty()) {
			return Optional.empty();
		}
		List<AddressResponseDto> addressResponseDtos = addresses.stream().map(addressAdapter::convertAddressToAddressResponseDto).toList();
		return Optional.of(addressResponseDtos);
	}
}
