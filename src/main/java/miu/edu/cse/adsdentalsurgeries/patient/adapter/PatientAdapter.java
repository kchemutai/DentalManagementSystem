package miu.edu.cse.adsdentalsurgeries.patient.adapter;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.adapter.AddressAdapter;
import miu.edu.cse.adsdentalsurgeries.patient.dto.request.PatientRequestDto;
import miu.edu.cse.adsdentalsurgeries.patient.dto.response.PatientResponseDto;
import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;
import miu.edu.cse.adsdentalsurgeries.user.adaptor.UserAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientAdapter {

    private final AddressAdapter addressAdapter;
    private final UserAdapter userAdapter;

    public Patient convertRequestDtoToPatient(PatientRequestDto patientRequestDto) {
        return Patient.builder()
                .mailingAddress(addressAdapter.convertAddressRequestDtoToAddress(patientRequestDto.getAddressRequestDto()))
                .user(userAdapter.convertRegisterRequestToUser(patientRequestDto.getUserRequestDto()))
                .build();

    }

    public PatientResponseDto convertPatientToDto(Patient patient) {
        return PatientResponseDto.builder()
                .addressResponseDto(addressAdapter.convertAddressToAddressResponseDto(patient.getMailingAddress()))
                .userResponse(userAdapter.convertUserToUserResponse(patient.getUser()))
                .build();
    }

    public Patient convertPatientResponseDtoToPatient(PatientResponseDto patientResponseDto) {
        return Patient.builder()
                .outstandingBill(0.0)
                .mailingAddress(addressAdapter.convertAddressResponseDtoToAddress(patientResponseDto.getAddressResponseDto()))
                .user(userAdapter.convertUserResponseToUser(patientResponseDto.getUserResponse()))
                .build();
    }
}
