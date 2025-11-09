package com.payrollsystem.controller;

import com.payrollsystem.entity.Payroll;
import com.payrollsystem.payload.ApiResponse;
import com.payrollsystem.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payrolls")
public class PayrollController {
    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Payroll>> createPayroll(@RequestBody Payroll payroll) {
        Payroll saved = payrollService.createPayroll(payroll);
        return ResponseEntity.ok(new ApiResponse<>("Success", "Payroll created successfully", saved));
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<Payroll>>> getAllPayrolls() {
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return ResponseEntity.ok(new ApiResponse<>("Success", "Payrolls fetched successfully", payrolls));
    }
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Payroll>> getPayrollsByEmployeeId(@PathVariable Long employeeId)
    {
        List<Payroll> payrolls = payrollService.getPayrollsByEmployeeId(employeeId);
        return ResponseEntity.ok(payrolls);
    }


}
