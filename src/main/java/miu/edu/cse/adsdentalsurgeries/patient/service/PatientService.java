package miu.edu.cse.adsdentalsurgeries.patient.service;


import miu.edu.cse.adsdentalsurgeries.patient.dto.request.PatientRequestDto;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;

import java.util.Optional;

public interface PatientService {

	Optional<PatientResponseDto> addNewPatient(PatientRequestDto patientRequestDto);
	
	Optional<PatientResponseDto> findPatientById(Integer patientId);
	
	Optional<PatientResponseDto> updateExistingPatient(PatientRequestDto patientRequestDto);
	
	void deletePatient(Integer patientId);
}
