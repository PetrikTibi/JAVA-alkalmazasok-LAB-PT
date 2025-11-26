package com.example.notebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Biztonsági ellenőrzés egyszerűsítése
                .authorizeHttpRequests(auth -> auth
                        // EZEKET AZ OLDALAKAT MINDENKI LÁTHATJA:
                        .requestMatchers("/", "/index", "/regisztral", "/regisztral_feldolgoz",
                                "/kapcsolat", "/kapcsolat_feldolgoz", "/diagram", "/api/**",
                                "/css/**", "/js/**", "/images/**").permitAll()

                        // Minden más oldalhoz (pl. /uzenetek) be kell jelentkezni:
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll() // Ha lenne egyedi login oldalunk
                        .defaultSuccessUrl("/", true) // Sikeres belépés után ide visz
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }
}