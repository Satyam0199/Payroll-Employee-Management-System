package com.payrollsystem.serviceimpl;

import com.payrollsystem.entity.Department;
import com.payrollsystem.entity.Employee;
import com.payrollsystem.exception.ResourceNotFoundException;
import com.payrollsystem.repository.DepartmentRepository;
import com.payrollsystem.repository.EmployeeRepository;
import com.payrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final DepartmentRepository departmentRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository)
    {
        this.employeeRepository=employeeRepository;
        this.departmentRepository=departmentRepository;
    }

    @Override
    public Employee createEmployee(Employee employee,Long departmentId) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(dept);
        } else {
            throw new RuntimeException("Department ID is required");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Department departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id"+id));
    }

    @Override
    public Employee updateEmployees(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);
        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployees(Long id) {
        Employee emp = getEmployeeById(id);
        employeeRepository.delete(emp);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartment_Id(departmentId);
    }
}
