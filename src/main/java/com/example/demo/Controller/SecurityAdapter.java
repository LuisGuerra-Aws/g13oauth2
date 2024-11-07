package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

public class SecurityAdapter extends WsConfigurerAdapter{
    @SuppressWarnings("removal")
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
        .AntPathRequestMatcher("/", "/user", "/logout", "/errors", "/ebjears/**").permitAll()
        .anyRequest().authenticated()
        .logout(l -> l.logoutSuccessUrl("/").permitAll()
        ).exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login();
        

        http.cors().and().csrf().disable();
    }

}
