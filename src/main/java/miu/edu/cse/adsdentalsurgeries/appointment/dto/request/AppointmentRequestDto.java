package miu.edu.cse.adsdentalsurgeries.appointment.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.dto.request.AddressRequestDto;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
import miu.edu.cse.adsdentalsurgeries.dentist.model.Dentist;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;
import miu.edu.cse.adsdentalsurgeries.surgery.dto.request.SurgeryRequestDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDto {

    @NotNull(message = "Surgery cannot be null")
    private SurgeryRequestDto surgeryRequestDto;

    @NotNull(message = "Patient cannot be null")
    private PatientResponseDto patient;

    @NotNull(message = "Dentist cannot be null")
    private DentistResponseDto dentist;

    @NotNull(message = "Location cannot be null")
    private AddressRequestDto addressRequestDto;
}
