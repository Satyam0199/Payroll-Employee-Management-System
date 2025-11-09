package com.payrollsystem.controller;

import com.payrollsystem.entity.Department;
import com.payrollsystem.payload.ApiResponse;
import com.payrollsystem.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService=departmentService;
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Department>>create(@RequestBody Department department)
    {
        return ResponseEntity.ok(new ApiResponse<>("Success","Department created successfully",departmentService.createDepartment(department)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Department>>>getAll()
    {
        return ResponseEntity.ok(new ApiResponse<>("Success","Departments fetched",departmentService.getAllDepartments()));
    }
}
