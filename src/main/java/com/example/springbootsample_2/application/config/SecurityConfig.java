package com.example.springbootsample_2.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
    /**
     * セキュリティ対象外を設定する
     * @return
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/webjars/**"))
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .requestMatchers(new AntPathRequestMatcher( "/css/**"))
                .requestMatchers(new AntPathRequestMatcher( "/js/**"));
    }

    /**
     * セキュリティの各種設定
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

      /** Spring Security 6.0以上 */

      // // CSRF
      http.csrf(csrf -> csrf.disable());

      http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/login").permitAll()
        .requestMatchers("/user/signup").permitAll()
        .anyRequest().denyAll()
      );
      return http.build();

    }     
}
