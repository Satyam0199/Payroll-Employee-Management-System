package com.payrollsystem.controller;

import com.payrollsystem.entity.Employee;
import com.payrollsystem.payload.ApiResponse;
import com.payrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 1️⃣ Add Employee
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> create(@RequestBody Employee employee) {
        Long deptId = employee.getDepartment().getId();
        Employee savedEmployee = employeeService.createEmployee(employee, deptId);
        return ResponseEntity.ok(new ApiResponse<>("Success", "Employee created successfully", savedEmployee));
    }

    // 2️⃣ Get All Employees
    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>("Success", "Employees fetched", employeeService.getAllEmployees()));
    }

    // 3️⃣ Get Employees By Department (optional)
    @GetMapping("/by-department/{departmentId}")
    public ResponseEntity<ApiResponse<List<Employee>>> getByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(
                new ApiResponse<>("Success", "Employees fetched for department", employeeService.getEmployeesByDepartment(departmentId))
        );
    }
}
