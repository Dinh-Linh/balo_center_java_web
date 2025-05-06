package com.example.balo_center.authentication;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.entity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserSessionDetail{
    private final UserRepo userRepo;
    public UserDetailsService get(){
       return username -> {
           User user = userRepo.findUsersByEmail(username)
                   .orElseThrow(() -> new UsernameNotFoundException("Username not found" + username));
           return new org.springframework.security.core.userdetails.User(
                   user.getEmail(),
                   user.getPassword(),
                   Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
           );
       };
    }

}
