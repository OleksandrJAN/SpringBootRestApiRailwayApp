package com.railwayApp.api.security;

import com.railwayApp.api.domain.User;
import com.railwayApp.api.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserDetailsFactory {

    public static UserDetails create(User user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                getUserAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> getUserAuthorities(Set<UserRole> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }
}
