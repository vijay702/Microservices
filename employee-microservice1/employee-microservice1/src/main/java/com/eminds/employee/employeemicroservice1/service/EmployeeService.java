package com.eminds.employee.employeemicroservice1.service;

import com.eminds.employee.employeemicroservice1.dto.EmployeeDto;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto) throws DataAlreadyExistsException;

    List<EmployeeDto> getAllEmployee();
}
