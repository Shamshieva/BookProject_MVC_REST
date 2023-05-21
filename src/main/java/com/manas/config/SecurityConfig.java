package com.manas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author kurstan
 * @created at 01.03.2023 14:06
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        UserDetails admin = userBuilder
                .username("Admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        UserDetails doctor = userBuilder
                .username("Vendor")
                .password("vendor")
                .roles("VENDOR")
                .build();

        UserDetails patient = userBuilder
                .username("Customer")
                .password("customer")
                .roles("CUSTOMER")
                .build();
        return new InMemoryUserDetailsManager(admin, doctor, patient);
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth
//                .requestMatchers("/vendors").permitAll()
//                .requestMatchers("/vendors/{id}").permitAll()
//                .requestMatchers("/vendors/new").hasRole("ADMIN")
//                .requestMatchers("/vendors/save").hasRole("ADMIN")
//                .requestMatchers("/vendors/{id}/delete").hasRole("ADMIN")
//                .requestMatchers("/vendors/{id}/edit").hasRole("ADMIN")
//                .requestMatchers("/vendors/{id}/update").hasRole("ADMIN")
//        );
        return http.build();



    }
}
