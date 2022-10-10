package com.example.authservice.Controller;

import com.example.authservice.DTO.AuthenticationRequest;
import com.example.authservice.DTO.AuthenticationResponse;
import com.example.authservice.security.JwtUtil;

import com.example.authservice.services.ApplicationUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final ApplicationUserDetailsService userDetailsService;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> createAuthentificationToken(@RequestBody AuthenticationRequest request) throws Exception {



        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            System.out.println("User authenticated successfully");
        }catch (BadCredentialsException e) {

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Username or password invalid");

        }


        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String access_token= jwtUtil.generateToken(userDetails);



        return ResponseEntity.ok(new AuthenticationResponse(access_token));
    }
}
