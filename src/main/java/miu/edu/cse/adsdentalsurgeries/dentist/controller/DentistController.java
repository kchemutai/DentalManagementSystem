package miu.edu.cse.adsdentalsurgeries.dentist.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.request.DentistRequestDto;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
import miu.edu.cse.adsdentalsurgeries.dentist.service.DentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dentists")
@RequiredArgsConstructor
public class DentistController {
    private final DentistService dentistService;

    @PostMapping
    public ResponseEntity<DentistResponseDto> addDentist(@RequestBody DentistRequestDto dentist) {
        Optional<DentistResponseDto> dentistResponseDto = dentistService.createNewDentist(dentist);
        return ResponseEntity.ok(dentistResponseDto.get());
    }
}
