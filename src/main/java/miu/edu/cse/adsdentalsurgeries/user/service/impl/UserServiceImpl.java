package miu.edu.cse.adsdentalsurgeries.user.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.adaptor.UserAdapter;
import miu.edu.cse.adsdentalsurgeries.user.dto.request.UserRequestDto;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponse;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;
import miu.edu.cse.adsdentalsurgeries.user.model.User;
import miu.edu.cse.adsdentalsurgeries.user.repository.UserRepository;
import miu.edu.cse.adsdentalsurgeries.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAdapter userAdapter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserResponseDto> findByEmail(String email) {
        Optional<User> user= userRepository.findByEmail(email);
        if (user.isPresent()) {
            User foundUser = user.get();
            return Optional.of(userAdapter.convertUserToUserResponseDto(foundUser));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDto> findByUsername(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            User foundUser = user.get();
            return Optional.of(userAdapter.convertUserToUserResponseDto(foundUser));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDto> addUser(UserRequestDto request) {
        User user = userAdapter.convertRegisterRequestToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return Optional.of(userAdapter.convertUserToUserResponseDto(savedUser));
    }

    @Override
    public Optional<UserResponseDto> updateUser(UserRequestDto request) {
        Optional<User> savedUser = userRepository.findByEmail(request.getEmail());
        if (savedUser.isPresent()) {
            User foundUser = savedUser.get();
            foundUser.setFirstName(request.getFirstName());
            foundUser.setLastName(request.getLastName());
            foundUser.setPassword(request.getPassword());
            foundUser.setPhoneNumber(request.getPhoneNumber());
            foundUser.setRole(request.getRole());
            User updatedUser = userRepository.save(foundUser);
            return Optional.of(userAdapter.convertUserToUserResponseDto(updatedUser));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDto> deleteUser(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            User foundUser = user.get();
            userRepository.delete(foundUser);
            return Optional.of(userAdapter.convertUserToUserResponseDto(foundUser));
        }
        return Optional.empty();
    }

    public Optional<UserResponse> findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            return Optional.of(userAdapter.convertUserToUserResponse(foundUser));
        }
        return Optional.empty();
    }
}
