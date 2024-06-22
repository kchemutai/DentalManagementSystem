package miu.edu.cse.adsdentalsurgeries.appointment.adapter;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.request.AppointmentRequestDto;
import miu.edu.cse.adsdentalsurgeries.appointment.dto.response.AppointmentResponseDto;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import miu.edu.cse.adsdentalsurgeries.dentist.adapter.DentistAdapter;
import miu.edu.cse.adsdentalsurgeries.patient.adapter.PatientAdapter;
import miu.edu.cse.adsdentalsurgeries.surgery.adapter.SurgeryAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentAdapter {
    private final SurgeryAdapter surgeryAdapter;
    private final AddressAdapter addressAdapter;
    private final PatientAdapter patientAdapter;
    private final DentistAdapter dentistAdapter;

    public AppointmentResponseDto convertToAppointmentResponseDto(Appointment appointment) {
        return AppointmentResponseDto.builder()
                .status(appointment.getStatus())
                .surgeryResponseDto(surgeryAdapter.convertSurgeryToDto(appointment.getSurgery()))
                .patientResponseDto(patientAdapter.convertPatientToDto(appointment.getPatient()))
                .dentistResponseDto(dentistAdapter.dentistToDentistResponseDto(appointment.getDentist()))
                .addressResponseDto(addressAdapter.convertAddressToAddressResponseDto(appointment.getLocation()))
                .build();
    }
}
