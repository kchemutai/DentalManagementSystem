package miu.edu.cse.adsdentalsurgeries.appointment.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.request.AppointmentRequestDto;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.response.AppointmentResponseDto;
import miu.edu.cse.adsdentalsurgeries.appointment.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        Optional<AppointmentResponseDto> appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
        if (appointmentResponseDto.isPresent()) {
            return ResponseEntity.ok(appointmentResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }
}
