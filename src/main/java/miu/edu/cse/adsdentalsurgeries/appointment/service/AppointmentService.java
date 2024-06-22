package miu.edu.cse.adsdentalsurgeries.appointment.service;


import miu.edu.cse.adsdentalsurgeries.appointment.dto.request.AppointmentRequestDto;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.response.AppointmentResponseDto;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;

import java.util.List;
import java.util.Optional;


public interface AppointmentService {
	Optional<AppointmentResponseDto> bookAppointment(AppointmentRequestDto appointmentRequestDto);

	Optional<List<AppointmentResponseDto>> findAppointment();
}
