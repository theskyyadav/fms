package com.pjsoft.fms.service;

import com.pjsoft.fms.conig.JwtUtil;
import com.pjsoft.fms.model.User;
import com.pjsoft.fms.pojo.auth.dto.AuthRequest;
import com.pjsoft.fms.pojo.auth.dto.AuthResponse;
import com.pjsoft.fms.pojo.auth.dto.UserRequest;
import com.pjsoft.fms.pojo.auth.dto.UserResponse;
import com.pjsoft.fms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public
class UserService {
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthUserDetailsService authUserDetailsService;

    private final JwtUtil jwtUtil;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,JwtUtil jwtUtil, AuthenticationManager authenticationManager, AuthUserDetailsService authUserDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil=jwtUtil;
        this.authUserDetailsService=authUserDetailsService;
        this.authenticationManager=authenticationManager;
    }
    public
    List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map
                (user -> new UserResponse(user.getId(), user.getName(), user.getUsername()))
                        .collect(Collectors.toList());
    }
    public
    UserResponse createUser(UserRequest userRequest) {

        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User user = new User(userRequest.getName(), userRequest.getUsername(), userRequest.getPassword());

        user = userRepository.save(user);

        return new UserResponse(user.getId(), user.getName(), user.getUsername());

    }

    public
    AuthResponse userLogin(AuthRequest authRequest) throws Exception {

        authenticate(authRequest.getUsername(), authRequest.getPassword());

        final UserDetails userDetails = authUserDetailsService.loadUserByUsername(authRequest.getUsername());

        final String token = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthResponse(authRequest.getUsername(), token);

    }
    private void authenticate(String username, String password) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);

        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);

        }

    }


}
