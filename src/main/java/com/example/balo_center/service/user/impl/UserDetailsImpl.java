package com.example.balo_center.service.user.impl;

import com.example.balo_center.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class UserDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private String id; // Changed to String to match User entity

    private String username; // This will hold the identifier used for login (e.g., email)

    @Getter
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    // Default constructor might be needed by some frameworks, ensure it's present if required.
    public UserDetailsImpl() {
    }


    // Constructor used by the build method
    public UserDetailsImpl(String id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username; // Ensure this is the field Spring Security uses for username
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
                // Default role if parsing results in empty list but roleString was not empty
                authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
            }
        } else {
            // Default role if roleString is null or empty
            authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        }
        return new UserDetailsImpl(
                user.getId(), // Assuming User.getId() returns String
                user.getEmail(), // Using email as the username for Spring Security
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
        // This must return the identifier used by Spring Security for authentication (e.g., email)
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
