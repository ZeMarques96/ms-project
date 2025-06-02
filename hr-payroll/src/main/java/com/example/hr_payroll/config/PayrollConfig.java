package com.example.hr_payroll.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PayrollConfig {

    @Bean
    @Primary
    ServiceInstanceListSupplier supplier(){
        return new PayrollServiceSupplier("hr-worker");
    }
}
class PayrollServiceSupplier implements ServiceInstanceListSupplier{

    private String serviceId;

    PayrollServiceSupplier (String serviceId){
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Arrays.asList(
                new DefaultServiceInstance(serviceId + "1" , serviceId, "localhost", 8001, false),
                new DefaultServiceInstance(serviceId + "2" , serviceId, "localhost", 8002, false)
        ));
    }
}