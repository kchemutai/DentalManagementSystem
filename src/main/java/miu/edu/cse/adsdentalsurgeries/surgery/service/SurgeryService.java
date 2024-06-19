package miu.edu.cse.adsdentalsurgeries.surgery.service;


import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;

import java.util.List;


public interface SurgeryService {

	Integer createNewSurgery(Surgery surgery);
	
	List<Surgery> findAppointment();
}
