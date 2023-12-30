package com.example.token.config;

import com.example.token.filter.TokenGenFilter;
import com.example.token.filter.TokenValidFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private TokenGenFilter genFilter;
    @Autowired
    private TokenValidFilter validFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(cust -> {
            cust
                    .requestMatchers("/auth").permitAll()
                    .requestMatchers("/actualPage").authenticated()
                    .requestMatchers("/admin").hasRole("ADMIN");

        });

        http.addFilterAfter(genFilter, LogoutFilter.class);
        http.addFilterBefore(validFilter, LogoutFilter.class);

        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);

        return http.build();

    }

}
