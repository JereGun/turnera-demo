package dev.jgunsett.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desactiva protección CSRF (necesaria para POST/PUT en desarrollo)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite todas las rutas
                )
                .formLogin().disable() // Desactiva formulario de login
                .httpBasic().disable(); // Desactiva autenticación básica

        return http.build();
    }
}