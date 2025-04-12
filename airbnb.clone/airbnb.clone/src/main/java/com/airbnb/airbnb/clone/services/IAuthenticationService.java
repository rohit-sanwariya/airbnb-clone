package com.airbnb.airbnb.clone.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthenticationService {
    UserDetails authenticate(String email,String password);
    String GenerateToken(UserDetails userDetails);
}
