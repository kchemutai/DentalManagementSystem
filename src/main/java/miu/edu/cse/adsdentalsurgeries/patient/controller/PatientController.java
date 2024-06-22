package miu.edu.cse.adsdentalsurgeries.patient.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.patient.dto.request.PatientRequestDto;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;
import miu.edu.cse.adsdentalsurgeries.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDto> addPatient(@RequestBody PatientRequestDto patientRequestDto) {
        Optional<PatientResponseDto> patientResponseDto = patientService.addNewPatient(patientRequestDto);
        if (patientResponseDto.isPresent()) {
            return ResponseEntity.ok().body(patientResponseDto.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
