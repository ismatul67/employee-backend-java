package com.mmi.ismatul.employee.services;

import com.mmi.ismatul.employee.entity.Employee;
import com.mmi.ismatul.employee.entity.Position;
import com.mmi.ismatul.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceDBImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PositionService positionService;

    @Override
    public Employee saveEmployee(Employee employee) {

        Position position = positionService.getPositionById(employee.getPositionId());

        if (employee.getId()==null){
            employee.setRemove(false);
        }
        employee.setPosition(position);
        return employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployeeById(Integer id) {
        if (employeeRepository.findById(id).isPresent()) return employeeRepository.findById(id).get();
        else return null;
    }

    @Override
    public Page<Employee> getEmployers(Pageable pageable) {

        return employeeRepository.findAllByRemoveIsFalse(pageable);
    }

    @Override
    public boolean isTakenNip(Integer nip) {
        Employee employee = employeeRepository.findByIdNumber(nip);

        if (employee==null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = getEmployeeById(id);
        employee.setRemove(true);
        employeeRepository.save(employee);
    }

}
