package com.apipractice.global;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : iyeong-gyo
 * @package : com.apipractice.global
 * @since : 01.06.24
 */
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement((session) -> session.sessionCreationPolicy(STATELESS))
        .authorizeHttpRequests(
            (authorize) -> authorize
                .anyRequest()
                .permitAll()
        );
    return http.build();
  }
}
