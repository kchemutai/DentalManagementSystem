package miu.edu.cse.adsdentalsurgeries.appointment.service;


import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;

import java.util.List;


public interface AppointmentService {
	Integer bookAppointment(Appointment appointment);

	List<Appointment> findAppointment();
}
