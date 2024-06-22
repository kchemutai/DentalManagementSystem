package miu.edu.cse.adsdentalsurgeries.user.adaptor;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.dto.request.UserRequestDto;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponse;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;
import miu.edu.cse.adsdentalsurgeries.user.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter {
    private final PasswordEncoder passwordEncoder;
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

    public User convertRegisterRequestToUser(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return modelMapper.map(userRequestDto, User.class);
    }

    public UserResponse convertUserToUserResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public User convertUserResponseToUser(UserResponse userResponse) {
        return modelMapper.map(userResponse, User.class);
    }

}
