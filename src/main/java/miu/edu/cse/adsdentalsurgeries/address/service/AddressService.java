package miu.edu.cse.adsdentalsurgeries.address.service;

import miu.edu.cse.adsdentalsurgeries.address.dto.request.AddressRequestDto;
import miu.edu.cse.adsdentalsurgeries.address.dto.response.AddressResponseDto;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;

import java.util.List;
import java.util.Optional;


public interface AddressService {

	Optional<AddressResponseDto> createNewAddress(AddressRequestDto addressRequestDto);
	Optional<List<AddressResponseDto>> findAddresses();
}
