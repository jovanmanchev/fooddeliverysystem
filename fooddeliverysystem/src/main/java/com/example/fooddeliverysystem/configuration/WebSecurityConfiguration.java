package com.example.fooddeliverysystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration   {

    private final PasswordEncoder passwordEncoder;
    private final UsernameAndPasswordAuthProvider usernameAndPasswordAuthProvider;

    public WebSecurityConfiguration(PasswordEncoder passwordEncoder, UsernameAndPasswordAuthProvider usernameAndPasswordAuthProvider) {
        this.passwordEncoder = passwordEncoder;
        this.usernameAndPasswordAuthProvider = usernameAndPasswordAuthProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/salePlaces", true)
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login");


        return http.build();

    }
}
