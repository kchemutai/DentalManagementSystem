package miu.edu.cse.adsdentalsurgeries.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.user.dto.request.RegisterRequest;
import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;
import miu.edu.cse.adsdentalsurgeries.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<UserResponseDto> getUserByEmail(@RequestParam String email) {
        Optional<UserResponseDto> user = userService.findByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponseDto> registerUser( @Valid @RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.addUser(registerRequest).get());
    }
}
