package com.railwayApp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Setter
@Getter
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

}
