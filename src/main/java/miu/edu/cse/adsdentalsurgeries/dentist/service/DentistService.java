package miu.edu.cse.adsdentalsurgeries.dentist.service;



import miu.edu.cse.adsdentalsurgeries.dentist.dto.request.DentistRequestDto;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;

import java.util.Optional;

public interface DentistService {

	Optional<DentistResponseDto> createNewDentist(DentistRequestDto dentistRequestDto);
	
	Optional<DentistResponseDto> findDentistById(Integer dentistId);
	
	Optional<DentistResponseDto> updateExistingDentist(int dentistId, DentistRequestDto dentistRequestDto);
	
	void deleteDentist(Integer dentistId);
}
