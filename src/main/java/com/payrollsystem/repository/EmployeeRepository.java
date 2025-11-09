package com.payrollsystem.repository;

import com.payrollsystem.entity.Department;
import com.payrollsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(Department department);
    List<Employee> findByDepartment_Id(Long departmentId);
}
