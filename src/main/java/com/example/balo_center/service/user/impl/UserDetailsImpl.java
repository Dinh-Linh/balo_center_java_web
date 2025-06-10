package com.example.balo_center.service.user.impl;

import com.example.balo_center.domain.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Service
public class UserDetailsImpl implements UserDetails {
    @Getter
    private String id;
    private String username;
    @Getter
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(String id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) { // Changed id type to String
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities;
        String roleString = user.getRole();
        if (roleString != null && !roleString.isEmpty()) {
            authorities = Arrays.stream(roleString.split(","))
                    .map(String::trim)
                    .filter(role -> !role.isEmpty())
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            if (authorities.isEmpty()) {
                authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
            }
        } else {
            authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        }
        return new UserDetailsImpl(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
