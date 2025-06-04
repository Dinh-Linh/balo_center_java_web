package com.example.balo_center.config;

import com.example.balo_center.authentication.UserSessionDetail;
import com.example.balo_center.component.CustomSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
        private final CustomSuccessHandler customSuccessHandler;
        private final UserSessionDetail userSessionDetail;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/", "/homepage", "/view/auth/**", "/login",
                                                                "/register",
                                                                "/resources/**",
                                                                "/assets/**",
                                                                "/vendor/**",
                                                                "/css/**",
                                                                "/js/**",
                                                                "/images/**",
                                                                "/fonts/**",
                                                                "/template/**",
                                                                "/webjars/**")
                                                .permitAll()
                                                .requestMatchers("/view/admin/**").hasRole("ADMIN")
                                                .requestMatchers("/view/end_user/**").permitAll()
                                                .anyRequest().permitAll())
                                .formLogin(form -> form
                                                .loginPage("/view/auth/login")
                                                .loginProcessingUrl("/login")
                                                .successHandler(customSuccessHandler)
                                                .failureUrl("/view/auth/login?error=true")
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/view/auth/login")
                                                .invalidateHttpSession(true)
                                                .clearAuthentication(true)
                                                .permitAll())
                                .sessionManagement(session -> session
                                                .sessionFixation().migrateSession()
                                                .maximumSessions(1)
                                                .expiredUrl("/view/auth/login?expired=true"));
                httpSecurity.authenticationProvider(authenticationProvider());

                return httpSecurity.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
                authProvider.setUserDetailsService(userSessionDetail);
                authProvider.setPasswordEncoder(passwordEncoder());
                return authProvider;
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }
}
