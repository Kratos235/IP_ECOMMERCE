package Ecommerce.service;

import Ecommerce.dto.RegisterDTO;
import Ecommerce.entity.UserEntity;
import Ecommerce.repository.UserRepository;
import io.jsonwebtoken.security.Password;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterDTO dto){
        if(userRepository.findByUsername(dto.getUserName()).isPresent()){
            return "Username already exists.";
        }
        UserEntity user = new UserEntity();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword());
    }
}
