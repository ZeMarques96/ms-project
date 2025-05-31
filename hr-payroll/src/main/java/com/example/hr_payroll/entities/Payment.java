package com.example.hr_payroll.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal(){
        return getDays() * getDailyIncome();
    }
}
