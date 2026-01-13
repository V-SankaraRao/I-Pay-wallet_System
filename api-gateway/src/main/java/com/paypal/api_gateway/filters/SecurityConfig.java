//package com.paypal.api_gateway.filters;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        System.out.println("we are inside webFilter");
//
//        return http
//                // 🔴 REQUIRED for API Gateway
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//
//                .authorizeExchange(exchanges -> exchanges
//                        // ✅ Public endpoints (user-service)
//                        .pathMatchers("/auth/**").permitAll()
//
//                        // 🔐 Everything else must have JWT
//                        .anyExchange().authenticated()
//                )
//
//                // Disable default auth mechanisms
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
//                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
//
//                .build();
//    }
//}
//
