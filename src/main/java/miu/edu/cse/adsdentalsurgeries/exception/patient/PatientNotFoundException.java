package miu.edu.cse.adsdentalsurgeries.exception.patient;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
