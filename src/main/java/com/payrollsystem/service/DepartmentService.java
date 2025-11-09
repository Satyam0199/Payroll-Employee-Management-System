package com.payrollsystem.service;

import com.payrollsystem.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id,Department department);
    void deleteDepartment(Long id);
}
