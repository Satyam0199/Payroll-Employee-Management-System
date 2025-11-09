package com.payrollsystem.serviceimpl;

import com.payrollsystem.entity.Employee;
import com.payrollsystem.entity.Payroll;
import com.payrollsystem.repository.EmployeeRepository;
import com.payrollsystem.repository.PayrollRepository;
import com.payrollsystem.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PayrollRepository payrollRepository;


    @Override
    public Payroll createPayroll(Payroll payroll) {
        if(payroll.getEmployee()==null || payroll.getEmployee().getId()==null)
        {
            throw new RuntimeException("Employee ID is required to create payroll!");
        }
        Employee employee= employeeRepository.findById(payroll.getEmployee().getId()).orElseThrow(()-> new RuntimeException(("Employee not found with ID:"+payroll.getEmployee().getId())));
        payroll.setEmployee(employee);
        return payrollRepository.save(payroll);
    }

    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    @Override
    public List<Payroll> getPayrollsByEmployeeId(Long employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }
}
