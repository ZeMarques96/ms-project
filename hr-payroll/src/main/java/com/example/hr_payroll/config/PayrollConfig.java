package com.example.hr_payroll.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class PayrollConfig {

    @Bean
    @Primary
    public ServiceInstanceListSupplier payrollServiceSupplier(DiscoveryClient discoveryClient) {
        return new PayrollServiceSupplier("hr-worker", discoveryClient);
    }
}


class PayrollServiceSupplier implements ServiceInstanceListSupplier{


    private DiscoveryClient discoveryClient;

    private final String serviceId;

    PayrollServiceSupplier (String serviceId, DiscoveryClient discoveryClient){
        this.serviceId = serviceId;
        this.discoveryClient = discoveryClient;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

//    @Override
//    public Flux<List<ServiceInstance>> get() {
//        return Flux.just(Arrays.asList(
//                new DefaultServiceInstance(serviceId + "1" , serviceId, "localhost", 8001, false),
//                new DefaultServiceInstance(serviceId + "2" , serviceId, "localhost", 8002, false)
//        ));
//    }
    @Override
    public Flux<List<ServiceInstance>> get() {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        return Flux.just(instances);
    }
}