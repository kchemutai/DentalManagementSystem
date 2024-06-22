package miu.edu.cse.adsdentalsurgeries.surgery.service.impl;

import java.util.List;
import java.util.Optional;

import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.surgery.adapter.SurgeryAdapter;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.request.SurgeryRequestDto;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.response.SurgeryResponseDto;
import miu.edu.cse.adsdentalsurgeries.surgery.service.SurgeryService;
import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;
import miu.edu.cse.adsdentalsurgeries.surgery.repository.SurgeryRepository;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurgeryServiceImpl implements SurgeryService {
	
	private final SurgeryRepository surgeryRepository;
	private final AddressAdapter addressAdapter;
	private final SurgeryAdapter surgeryAdapter;

	@Override
	public Optional<SurgeryResponseDto> createNewSurgery(SurgeryRequestDto surgeryRequestDto) {
		Surgery surgery = Surgery.builder()
				.surgeryName(surgeryRequestDto.getSurgeryName())
				.phoneNumber(surgeryRequestDto.getPhoneNumber())
				.address(addressAdapter.convertAddressRequestDtoToAddress(surgeryRequestDto.getAddressRequestDto()))
				.build();
		Surgery savedSurgery = surgeryRepository.save(surgery);
		SurgeryResponseDto surgeryResponseDto = SurgeryResponseDto.builder()
				.surgeryName(savedSurgery.getSurgeryName())
				.phoneNumber(savedSurgery.getPhoneNumber())
				.addressResponseDto(addressAdapter.convertAddressToAddressResponseDto(savedSurgery.getAddress()))
				.build();
		return Optional.of(surgeryResponseDto);
	}

	@Override
	public Optional<List<SurgeryResponseDto>> findAllSurgeries() {
		List<Surgery> surgeryList = surgeryRepository.findAll();
		if (surgeryList.isEmpty()) {
			return Optional.empty();
		}
		List<SurgeryResponseDto> surgeryResponseDtoList = surgeryList.stream()
				.map(surgeryAdapter::convertSurgeryToDto)
				.toList();
		return Optional.of(surgeryResponseDtoList);
	}

	@Override
	public Optional<SurgeryResponseDto> findSurgeryById(int id) {
		Optional<Surgery> surgery = surgeryRepository.findById(id);
		if (surgery.isPresent()) {
			return Optional.of(surgeryAdapter.convertSurgeryToDto(surgery.get()));
		}
		return Optional.empty();
	}
}
