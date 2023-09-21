package com.example.springbootsample_2.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
        .formLogin(login -> login
          .loginProcessingUrl("/login") // ログイン処理のパス
          .loginPage("/login") // ログインページの指定
          .failureUrl("/login?error") // ログイン失敗時の遷移先
          .usernameParameter("userId") // ログインページのユーザID
          .passwordParameter("password") // ログインページのパスワード
          .defaultSuccessUrl("/user/list",true) //　ログイン成功時の遷移先
          .permitAll()
        )
        .logout(logout -> logout
          .logoutSuccessUrl("/")
        )
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/login").permitAll()
        .requestMatchers("/user/signup").permitAll()
        .requestMatchers("/user/list").hasRole("USER")
        .requestMatchers("/user/detail/**").hasRole("USER")
        .anyRequest().denyAll()
      );
      return http.build();
    }     

    @Bean
    protected UserDetailsService users() {
      PasswordEncoder encorder = passwordEncoder();
      UserDetails user = User.builder()
        .username("user")
        .password(encorder.encode("user"))
        .roles("USER")
        .build();
      UserDetails admin = User.builder()
        .username("admin")
        .password(encorder.encode("admin"))
        .roles("USER", "ADMIN")
        .build();
      return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean 
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }
}
