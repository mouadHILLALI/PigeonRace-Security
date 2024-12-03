package com.PigeonSkyRace.PigeonSkyRace.security.Impl;

import com.PigeonSkyRace.PigeonSkyRace.security.CustomUserDetailsService;
import com.PigeonSkyRace.PigeonSkyRace.security.PasswordEncoder;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class CustomSecurityFilterChain extends WebSecurityConfiguration {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
           http.cors(customizer -> customizer.disable());
           http.authorizeRequests(customizer -> customizer.anyRequest().authenticated());

           return http.build();
   }
}
