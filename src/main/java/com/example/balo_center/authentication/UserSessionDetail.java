package com.example.balo_center.authentication;

import com.example.balo_center.module.entity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSessionDetail {
    private final UserRepo userRepo;
    public UserDetailsService get(){
        return new org.springframework.security.core.userdetails.UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // TODO Auto-generated method stub
                return (UserDetails) userRepo.findUsersByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
            }
        };
    }
}
