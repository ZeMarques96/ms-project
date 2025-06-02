package com.example.hr_worker.config;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(name = "hr-worker", configuration = ServiceInstanceListSupplier.class)
public class LoadBalancerConfig {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
