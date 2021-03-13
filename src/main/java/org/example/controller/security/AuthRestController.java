package org.example.controller.security;

import org.example.entity.security.BasicAuthResponseModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthRestController {

    @GetMapping("/login")
    public BasicAuthResponseModel confirmBasicAuthConfig(){

        return new BasicAuthResponseModel("Success");
    }


}
