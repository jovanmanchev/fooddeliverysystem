package com.example.fooddeliverysystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    private final PasswordEncoder passwordEncoder;
    private final UsernameAndPasswordAuthProvider usernameAndPasswordAuthProvider;

    public WebSecurityConfiguration(PasswordEncoder passwordEncoder, UsernameAndPasswordAuthProvider usernameAndPasswordAuthProvider) {
        this.passwordEncoder = passwordEncoder;
        this.usernameAndPasswordAuthProvider = usernameAndPasswordAuthProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/salePlaces").hasAnyRole("ADMIN", "CONSUMER")
                .requestMatchers("/checkOrderStatus").hasAnyRole("ADMIN", "CONSUMER")
                .requestMatchers("/salePlace/Orders").hasAnyRole("ADMIN", "SALEPLACEEMPLOYEE")
                .requestMatchers("/salePlace/**").hasAnyRole("ADMIN", "CONSUMER")
                .requestMatchers("/checkOrderStatus").hasAnyRole("ADMIN", "CONSUMER")
                .requestMatchers("/deliveryOrders").hasAnyRole("ADMIN", "DELIVER")
                .requestMatchers("/takeOrder/*").hasAnyRole("ADMIN", "DELIVER")
                .requestMatchers("/showOrderDeliverer").hasAnyRole("ADMIN", "DELIVER")
                .requestMatchers("/orderPayment/*").hasAnyRole("ADMIN", "DELIVER")
                .requestMatchers("/reports/**").hasRole("ADMIN")
                .requestMatchers("/images/**","/home","/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/home", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/home");


        return http.build();

    }
}
