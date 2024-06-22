package miu.edu.cse.adsdentalsurgeries.exception.dentist;

public class DentistNotFoundException extends RuntimeException {
    public DentistNotFoundException(String message) {
        super(message);
    }
}
