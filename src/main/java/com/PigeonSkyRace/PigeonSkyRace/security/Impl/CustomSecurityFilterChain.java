package com.PigeonSkyRace.PigeonSkyRace.security.Impl;

import com.PigeonSkyRace.PigeonSkyRace.security.CustomUserDetailsService;
import com.PigeonSkyRace.PigeonSkyRace.security.PasswordEncoder;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CustomSecurityFilterChain extends WebSecurityConfiguration {

    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;
//   @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       http.authorizeRequests().requestMatchers("/api/public/**").permitAll().
//               anyRequest().authenticated().and().
//   }
}
