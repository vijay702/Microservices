package com.eminds.employee.employeemicroservice1.controller;

import com.eminds.employee.employeemicroservice1.dto.EmployeeDto;
import com.eminds.employee.employeemicroservice1.entity.Employee;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;
import com.eminds.employee.employeemicroservice1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save/v1")
    public ResponseEntity <EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) throws DataAlreadyExistsException {


    return  new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);

    }


    @GetMapping("/fetch/v1")
    public List<EmployeeDto> getAllEmployee(){


        return employeeService.getAllEmployee();

    }


}
