package miu.edu.cse.adsdentalsurgeries.appointment.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.response.AddressResponseDto;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Status;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;
import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.response.SurgeryResponseDto;
import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDto {
    @NotNull(message = "Status cannot be null")
    private Status status;

    @NotNull(message = "Surgery cannot be null")
    private SurgeryResponseDto surgeryResponseDto;

    @NotNull(message = "Patient cannot be null")
    private PatientResponseDto patientResponseDto;

    @NotNull(message = "Dentist cannot be null")
    private DentistResponseDto dentistResponseDto;

    @NotNull(message = "Location cannot be null")
    private AddressResponseDto addressResponseDto;
}
