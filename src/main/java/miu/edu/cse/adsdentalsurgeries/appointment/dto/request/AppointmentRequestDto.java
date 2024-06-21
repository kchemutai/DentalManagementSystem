package miu.edu.cse.adsdentalsurgeries.appointment.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Status;
import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;
import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDto {

    @NotNull(message = "Surgery cannot be null")
    private Surgery surgery;

    @NotNull(message = "Patient cannot be null")
    private Patient patient;

    @NotNull(message = "Dentist cannot be null")
    private Patient dentist;

    @NotNull(message = "Location cannot be null")
    private Address location;
}
