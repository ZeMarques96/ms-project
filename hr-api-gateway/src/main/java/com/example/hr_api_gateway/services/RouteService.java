//package com.example.hr_api_gateway.services;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RouteService {
//
//    @Bean
//    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("hr-worker-route", r -> r.path("/workers/**")
//                        .uri("lb://hr-worker"))
//                .route("hr-payroll-route", r -> r.path("/payments/**")
//                        .uri("lb://hr-payroll"))
//                .build();
//    }
//}

