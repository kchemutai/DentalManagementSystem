package miu.edu.cse.adsdentalsurgeries.auth;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.auth.dto.request.AuthenticationRequest;
import miu.edu.cse.adsdentalsurgeries.auth.dto.response.AuthenticationResponse;
import miu.edu.cse.adsdentalsurgeries.exception.user.UserNotFoundException;
import miu.edu.cse.adsdentalsurgeries.user.repository.UserRepository;
import miu.edu.cse.adsdentalsurgeries.utils.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(
                        ()->new UserNotFoundException("User with email "+authenticationRequest.getEmail()+" not found")
                );
        // Verify the password
//        if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
//            throw new BadCredentialsException("Invalid password");
//        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
