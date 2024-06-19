package miu.edu.cse.adsdentalsurgeries.patient.service;


import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;

public interface PatientService {

	Integer createNewPatient(Patient patient);
	
	Patient findPatientById(Integer patientId);
	
	Patient updateExistingPatient(Patient patient);
	
	Integer deletePatient(Integer patientId);
}
