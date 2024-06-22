package miu.edu.cse.adsdentalsurgeries.surgery.service;


import miu.edu.cse.adsdentalsurgeries.surgery.dto.request.SurgeryRequestDto;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.response.SurgeryResponseDto;
import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;

import java.util.List;
import java.util.Optional;


public interface SurgeryService {

	Optional<SurgeryResponseDto> createNewSurgery(SurgeryRequestDto surgeryRequestDto);
	Optional<List<SurgeryResponseDto>> findAllSurgeries();
	Optional<SurgeryResponseDto> findSurgeryById(int id);
}
