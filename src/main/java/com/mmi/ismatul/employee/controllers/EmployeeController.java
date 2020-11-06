package com.mmi.ismatul.employee.controllers;

import com.mmi.ismatul.employee.entity.Employee;
import com.mmi.ismatul.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/check/{nip}")
    public boolean checkNip(@PathVariable Integer nip) {
        return employeeService.isTakenNip(nip);
    }

    @GetMapping
    public Page<Employee> getAllEmployersByPage(@RequestParam (defaultValue ="20", value = "size") Integer size, @RequestParam(defaultValue ="1", value = "page") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return employeeService.getEmployers(pageable);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void destroyEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
