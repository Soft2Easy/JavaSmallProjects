package com.application.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    public SecurityConfig() {
        System.out.println("SecurityConfig loaded!");
    }
    
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

                UserDetails applicant = User.withUsername("user")
                .password("{noop}user123")
                .roles("APPLICANT")
                .build();

        return new InMemoryUserDetailsManager(admin, applicant);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/jobs").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/jobs/all").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/application/apply/**").hasRole("APPLICANT")
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").authenticated()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .oauth2Login(oauth -> oauth
                    .userInfoEndpoint(userInfo -> userInfo
                        .userService(UserRequest -> {
                            var delegate = new DefaultOAuth2UserService();
                            var oAuth2User = delegate.loadUser(UserRequest);

                            return new DefaultOAuth2User(
                                List.of(new SimpleGrantedAuthority("ROLE_APPLICANT")),
                                oAuth2User.getAttributes(),
                                "email");
                        })))
                .build();
    }
}
