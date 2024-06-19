package miu.edu.cse.adsdentalsurgeries.appointment.service.impl;

import java.util.List;


import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import miu.edu.cse.adsdentalsurgeries.appointment.repository.AppointmentRepository;
import miu.edu.cse.adsdentalsurgeries.appointment.service.AppointmentService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	
	@Override
	public Integer createNewAppointment(Appointment appointment) {
	log.info("A new Appointment with id=" + appointment.getId() + " will be created!");
	
	appointmentRepository.save(appointment);
	
	log.info("The Appointment with id=" + appointment.getId() + " is created!");
	
	return appointment.getId();
	}

	@Override
	public List<Appointment> findAppointment() {
		return appointmentRepository.findAll();
	}

}
