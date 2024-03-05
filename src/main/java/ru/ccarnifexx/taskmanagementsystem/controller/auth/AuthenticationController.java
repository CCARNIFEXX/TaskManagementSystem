package ru.ccarnifexx.taskmanagementsystem.controller.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ccarnifexx.taskmanagementsystem.dto.user.UserAuthRequest;
import ru.ccarnifexx.taskmanagementsystem.util.JWTUtils;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AuthenticationController {

    JWTUtils jwtUtils;
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String createToken(@RequestBody @Valid UserAuthRequest authRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return jwtUtils.generateToken(authRequest.getUsername());
    }
}
