package miu.edu.cse.adsdentalsurgeries.dentist.adapter;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
import miu.edu.cse.adsdentalsurgeries.dentist.model.Dentist;
import miu.edu.cse.adsdentalsurgeries.user.adaptor.UserAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DentistAdapter {

    private final ModelMapper modelMapper;
    private final UserAdapter userAdapter;

    public DentistResponseDto dentistToDentistResponseDto(Dentist dentist) {
        return DentistResponseDto.builder()
                .specialization(dentist.getSpecialization())
                .userResponseDto(userAdapter.convertUserToUserResponseDto(dentist.getUser()))
                .build();
    }

    public Dentist dentistResponseDtoToDentist(DentistResponseDto dentistResponseDto) {
        return modelMapper.map(dentistResponseDto, Dentist.class);
    }
}
