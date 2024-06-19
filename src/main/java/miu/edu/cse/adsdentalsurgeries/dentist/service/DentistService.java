package miu.edu.cse.adsdentalsurgeries.dentist.service;


import miu.edu.cse.adsdentalsurgeries.dentist.model.Dentist;

public interface DentistService {

	Integer createNewDentist(Dentist dentist);
	
	Dentist findDentistById(Integer dentistId);
	
	Dentist updateExistingDentist(Dentist dentist);
	
	Integer deleteDentist(Integer dentistId);
}
