package org.example.controller.security;

import org.example.entity.security.AuthorityEntity;
import org.example.entity.security.BasicAuthResponseModel;
import org.example.entity.security.UserEntity;
import org.example.repository.security.AuthorityRepository;
import org.example.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthRestController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping("/login")
    public BasicAuthResponseModel confirmBasicAuthConfig(){

        return new BasicAuthResponseModel("Success");
    }
    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userEntity) {

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setEnabled(true);
        userEntity = userRepository.save(userEntity);

        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setUsername(userEntity.getUsername());
        authorityEntity.setAuthority("USER");
        authorityEntity.setUser(userEntity);
        authorityRepository.save(authorityEntity);
        return userEntity;
    }


}
