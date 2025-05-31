package com.example.hr_payroll.services;

import com.example.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
            return new Payment("Bob", 100.00, days);
    }

}
