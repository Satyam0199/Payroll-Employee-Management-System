package com.payrollsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double basicSalary;
    private Double deductions;
    private Double netSalary;
    private LocalDate payDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;  // 👈 Important: this connects Payroll to Employee

    // ✅ Constructors
    public Payroll() {}

    public Payroll(Long id, Double basicSalary, Double deductions, Double netSalary, LocalDate payDate, String status, Employee employee) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.payDate = payDate;
        this.status = status;
        this.employee = employee;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
