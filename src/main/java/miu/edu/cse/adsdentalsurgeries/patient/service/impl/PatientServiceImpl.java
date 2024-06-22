package miu.edu.cse.adsdentalsurgeries.patient.service.impl;


import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.address.service.AddressService;
import miu.edu.cse.adsdentalsurgeries.patient.adapter.PatientAdapter;
import miu.edu.cse.adsdentalsurgeries.patient.dto.request.PatientRequestDto;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;
import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;
import miu.edu.cse.adsdentalsurgeries.patient.service.PatientService;
import miu.edu.cse.adsdentalsurgeries.patient.repository.PatientRepository;
import miu.edu.cse.adsdentalsurgeries.user.adaptor.UserAdapter;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

	private final PatientRepository patientRepository;
	private final AddressAdapter addressAdapter;
	private final UserAdapter userAdapter;
	private final AddressService addressService;
	private final PatientAdapter patientAdapter;

	@Override
	public Optional<PatientResponseDto> addNewPatient(PatientRequestDto patientRequestDto) {
		Patient patient= Patient.builder()
				.outstandingBill(0)
				.mailingAddress(addressAdapter.convertAddressRequestDtoToAddress(patientRequestDto.getAddressRequestDto()))
				.user(userAdapter.convertRegisterRequestToUser(patientRequestDto.getUserRequestDto()))
				.build();
		Patient savedPatient = patientRepository.save(patient);
		PatientResponseDto patientResponseDto = PatientResponseDto.builder()
				.addressResponseDto(addressAdapter.convertAddressToAddressResponseDto(patient.getMailingAddress()))
				.userResponse(userAdapter.convertUserToUserResponse(patient.getUser()))
				.build();
		return Optional.of(patientResponseDto);
	}

	@Override
	public Optional<PatientResponseDto> findPatientById(Integer patientId) {
		Optional<Patient> patientOptional = patientRepository.findById(patientId);
		if (patientOptional.isPresent()) {
			Patient patient = patientOptional.get();
			PatientResponseDto patientResponseDto = patientAdapter.convertPatientToDto(patient);
			return Optional.of(patientResponseDto);
		}
		return Optional.empty();
	}

	@Override
	public Optional<PatientResponseDto> updateExistingPatient(PatientRequestDto patientRequestDto) {
		return Optional.empty();
	}

	@Override
	public void deletePatient(Integer patientId) {
		patientRepository.deleteById(patientId);
	}
}
