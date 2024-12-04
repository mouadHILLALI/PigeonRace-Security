package com.PigeonSkyRace.PigeonSkyRace.security.Impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
           return http.csrf(customizer -> customizer.disable())
                   .cors(customizer -> customizer.disable())
           .authorizeRequests(customizer -> customizer.requestMatchers("/api/public/**").permitAll()
                   .requestMatchers("/api/users/**").hasAnyAuthority("ROLE_USER")
                   .requestMatchers("/api/organizers/**").hasAnyAuthority("ROLE_ORGANIZER")
                   .requestMatchers("/api/admin/**").hasAnyAuthority("ROLE_ADMIN").anyRequest().authenticated())
                   .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                   .httpBasic(Customizer.withDefaults()).build();
   }
}
