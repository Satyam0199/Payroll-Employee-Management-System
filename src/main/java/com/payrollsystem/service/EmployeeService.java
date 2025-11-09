package com.payrollsystem.service;

import com.payrollsystem.entity.Department;
import com.payrollsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee,Long departmentId);
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployeesByDepartment(Department departmentId);
    Employee getEmployeeById(Long id);
    Employee updateEmployees(Long id,Employee employee);
    void deleteEmployees(Long id);
    List<Employee> getEmployeesByDepartment(Long departmentId);
}
