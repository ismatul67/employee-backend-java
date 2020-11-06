package com.mmi.ismatul.employee.services;


import com.mmi.ismatul.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public Employee getEmployeeById(Integer id);
    public Page<Employee> getEmployers(Pageable pageable);
    public boolean isTakenNip(Integer nip);
    public void deleteEmployee(Integer id);

}
