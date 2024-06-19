package miu.edu.cse.adsdentalsurgeries.appointment.service;


import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;

import java.util.List;


public interface AppointmentService {

	Integer createNewAppointment(Appointment appointment);
	
	List<Appointment> findAppointment();
}
