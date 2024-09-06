package tech.ecoelho.backend.domain.entity;

import java.math.BigDecimal;

public class Customer {

    private Integer age;
    private String cpf;
    private String name;
    private double income;
    private String location;

    public Customer(Integer age, String cpf, String name, double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean incomeIsBiggerOrEqualThan(double value){
        return income >= value;
    }

    public boolean incomeIsBetween(double minValue, double maxValue){
        return income >= minValue && income <= maxValue;
    }

    public boolean ageIsBiggerThan(int age){
        return age <= 30;
    }

    public boolean isLocationFrom(String location){
        return this.location.equalsIgnoreCase(location);
    }
}
