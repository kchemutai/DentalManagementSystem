package miu.edu.cse.adsdentalsurgeries.dentist.service.impl;


import miu.edu.cse.adsdentalsurgeries.dentist.adapter.DentistAdapter;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.request.DentistRequestDto;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
import miu.edu.cse.adsdentalsurgeries.dentist.model.Dentist;
import miu.edu.cse.adsdentalsurgeries.dentist.service.DentistService;
import miu.edu.cse.adsdentalsurgeries.dentist.repository.DentistRepository;
import miu.edu.cse.adsdentalsurgeries.user.adaptor.UserAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {

	private final DentistRepository dentistRepository;
	private final DentistAdapter dentistAdapter;
	private final UserAdapter userAdapter;

	@Override
	public Optional<DentistResponseDto> createNewDentist(DentistRequestDto dentistRequestDto) {
		Dentist dentist = Dentist.builder()
				.specialization(dentistRequestDto.getSpecialization())
				.user(userAdapter.convertRegisterRequestToUser(dentistRequestDto.getUserRequestDto()))
				.build();
		Dentist createdDentist = dentistRepository.save(dentist);
		DentistResponseDto dentistResponseDto = DentistResponseDto.builder()
				.specialization(createdDentist.getSpecialization())
				.userResponseDto(userAdapter.convertUserToUserResponseDto(createdDentist.getUser()))
				.build();
		return Optional.of(dentistResponseDto);
	}

	@Override
	public Optional<DentistResponseDto> findDentistById(Integer dentistId) {
		Optional<Dentist> dentist = dentistRepository.findById(dentistId);
		if (dentist.isPresent()) {
			return Optional.of(dentistAdapter.dentistToDentistResponseDto(dentist.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<DentistResponseDto> updateExistingDentist(int dentistId, DentistRequestDto dentistRequestDto) {
		Optional<Dentist> existingDentist = dentistRepository.findById(dentistId);
		if (existingDentist.isPresent()) {
			Dentist dentist = existingDentist.get();
			dentist.setSpecialization(dentistRequestDto.getSpecialization());
			dentist.setUser(userAdapter.convertRegisterRequestToUser(dentistRequestDto.getUserRequestDto()));
			Dentist updatedDentist = dentistRepository.save(dentist);
			DentistResponseDto dentistResponseDto = dentistAdapter.dentistToDentistResponseDto(updatedDentist);
			return Optional.of(dentistResponseDto);
		}
		return Optional.empty();
	}

	@Override
	public void deleteDentist(Integer dentistId) {
		dentistRepository.deleteById(dentistId);
	}
}
