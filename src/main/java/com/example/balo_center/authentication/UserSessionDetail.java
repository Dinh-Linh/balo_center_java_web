package com.example.balo_center.authentication;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserSessionDetail implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUsersByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
//        log.info("Loading user: email={}, fullname={}", user.getEmail(), user.getFullname());
        return new CustomUserDetails(user);
    }
}