package miu.edu.cse.adsdentalsurgeries.appointment.service.impl;

import java.util.List;
import java.util.Optional;


import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.appointment.adapter.AppointmentAdapter;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.request.AppointmentRequestDto;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.response.AppointmentResponseDto;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Status;
import miu.edu.cse.adsdentalsurgeries.appointment.repository.AppointmentRepository;
import miu.edu.cse.adsdentalsurgeries.appointment.service.AppointmentService;
import miu.edu.cse.adsdentalsurgeries.dentist.adapter.DentistAdapter;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
import miu.edu.cse.adsdentalsurgeries.dentist.service.DentistService;
import miu.edu.cse.adsdentalsurgeries.exception.dentist.DentistNotFoundException;
import miu.edu.cse.adsdentalsurgeries.exception.patient.PatientNotFoundException;
import miu.edu.cse.adsdentalsurgeries.notification.EmailSender;
import miu.edu.cse.adsdentalsurgeries.patient.adapter.PatientAdapter;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;
import miu.edu.cse.adsdentalsurgeries.patient.service.PatientService;
import miu.edu.cse.adsdentalsurgeries.surgery.adapter.SurgeryAdapter;
import miu.edu.cse.adsdentalsurgeries.surgery.service.SurgeryService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	private final EmailSender emailSender;
	private final DentistService dentistService;
	private final SurgeryService surgeryService;
	private final SurgeryAdapter surgeryAdapter;
	private final PatientService patientService;
	private final PatientAdapter patientAdaptor;
	private final DentistAdapter dentistAdapter;
	private final AddressAdapter addressAdapter;
	private final AppointmentAdapter appointmentAdapter;

	@Override
	public Optional<AppointmentResponseDto> bookAppointment(AppointmentRequestDto appointmentRequestDto) {

		Appointment appointment = Appointment.builder()
				.status(Status.RECEIVED)
				.surgery(surgeryAdapter.convertRequestDtoToSurgery(appointmentRequestDto.getSurgeryRequestDto()))
				.patient(patientAdaptor.convertPatientResponseDtoToPatient(appointmentRequestDto.getPatient()))
				.dentist(dentistAdapter.dentistResponseDtoToDentist(appointmentRequestDto.getDentist()))
				.location(addressAdapter.convertAddressRequestDtoToAddress(appointmentRequestDto.getAddressRequestDto()))
				.build();

		Appointment savedAppointment = appointmentRepository.save(appointment);
		AppointmentResponseDto appointmentResponseDto = appointmentAdapter.convertToAppointmentResponseDto(savedAppointment);
		return Optional.of(appointmentResponseDto);
	}

	@Override
	public Optional<List<AppointmentResponseDto>> findAppointment() {
		return Optional.empty();
	}
}
