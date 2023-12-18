package com.example.RegisterLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http
            .csrf(csfr->csfr.disable())
            .authorizeHttpRequests(auth->{
                auth.requestMatchers("").permitAll();
                auth.requestMatchers("/myAccount").permitAll();
            }
            ).build();
    }
    
}
