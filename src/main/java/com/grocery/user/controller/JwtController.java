package com.grocery.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.user.entity.JwtRequest;
import com.grocery.user.entity.JwtResponse;
import com.grocery.user.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public String createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.generateToken(jwtRequest);
    }
}