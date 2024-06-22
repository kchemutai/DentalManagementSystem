package miu.edu.cse.adsdentalsurgeries.user.service;


import miu.edu.cse.adsdentalsurgeries.user.dto.request.UserRequestDto;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;

import java.util.Optional;

public interface UserService {
    public Optional<UserResponseDto> findByEmail(String email);
    public Optional<UserResponseDto> findByUsername(String username);
    public Optional<UserResponseDto> addUser(UserRequestDto request);
    public Optional<UserResponseDto> updateUser(UserRequestDto request);
    public Optional<UserResponseDto> deleteUser(String username);
}
