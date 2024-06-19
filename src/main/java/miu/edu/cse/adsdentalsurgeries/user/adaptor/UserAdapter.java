package miu.edu.cse.adsdentalsurgeries.user.adaptor;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.dto.request.RegisterRequest;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;
import miu.edu.cse.adsdentalsurgeries.user.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final ModelMapper modelMapper;

    public UserResponseDto convertUserToUserResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    public User convertUserDtoToUser(UserResponseDto userResponseDto) {
        return modelMapper.map(userResponseDto, User.class);
    }

    public List<UserResponseDto> convertUserListToUserResponseDtoList(List<User> userList) {
       return userList.stream().map(this::convertUserToUserResponseDto).toList();
    }

    public User convertRegisterRequestToUser(RegisterRequest registerRequest) {
        return modelMapper.map(registerRequest, User.class);
    }
}
