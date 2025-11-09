package com.payrollsystem.service;

import com.payrollsystem.entity.Payroll;

import java.util.List;

public interface PayrollService {
    Payroll createPayroll(Payroll payroll);
    List<Payroll> getAllPayrolls();
    List<Payroll> getPayrollsByEmployeeId(Long employeeId);
}
