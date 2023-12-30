package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConf {
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception{


        http.authorizeHttpRequests(cust -> {
            cust
                    .requestMatchers("/public", "/login", "/register","/logout").permitAll()
                    .requestMatchers("/private","/").authenticated()
                    .requestMatchers("/protected").hasRole("access")
                    .requestMatchers("/user").hasAnyAuthority("USER" , "ADMIN");


        });

        http.formLogin(cust ->{
                cust.loginPage("/public");
                cust.loginProcessingUrl("/login");
                cust.usernameParameter("login");
                cust.passwordParameter("cred");
                cust.successHandler((request,response,authentication) -> {
                    response.sendRedirect("/user");
                });
                cust.failureHandler(((request, response, exception) -> {
                    response.sendRedirect("/public");//Тут криминала нет, никакого :)
                }));
        });

        http.logout(cust -> {
                    cust.logoutUrl("/logout");
                    cust.invalidateHttpSession(true);
        });
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
