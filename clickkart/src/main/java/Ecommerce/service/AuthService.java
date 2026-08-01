package Ecommerce.service;

import Ecommerce.dto.AuthResponseDTO;
import Ecommerce.dto.LoginDTO;
import Ecommerce.dto.RegisterDTO;
import Ecommerce.entity.Role;
import Ecommerce.entity.UserEntity;
import Ecommerce.repository.UserRepository;
import Ecommerce.security.JwtUtil;
import io.jsonwebtoken.security.Password;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterDTO dto){
        if(userRepository.findByUsername(dto.getUserName()).isPresent()){
            return "Username already exists.";
        }
        UserEntity user = new UserEntity();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        Role role = (dto.getRole() !=null && dto.getRole().equalsIgnoreCase("ADMIN"))?Role.ADMIN:Role.USER;
        user.setRole(role);
        userRepository.save(user);
        return "User registered successfully as" + role;
    }

    public AuthResponseDTO login(LoginDTO dto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(),dto.getPassword()));
        UserEntity user = userRepository.findByUsername(dto.getUserName()).orElseThrow(()->new RuntimeException("User not found"));

        String token= jwtUtil.generateToken(user.getUserName(),user.getRole().name());
        return new AuthResponseDTO(token,user.getUserName(),user.getRole().name());
    }
}
