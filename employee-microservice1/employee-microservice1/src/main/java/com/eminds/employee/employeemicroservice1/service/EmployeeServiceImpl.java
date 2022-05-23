package com.eminds.employee.employeemicroservice1.service;

import com.eminds.employee.employeemicroservice1.dto.EmployeeDto;
import com.eminds.employee.employeemicroservice1.entity.Employee;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;
import com.eminds.employee.employeemicroservice1.respository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) throws DataAlreadyExistsException {

        Employee employee = mapToEntity(employeeDto);

        Integer cid = employeeRepository.getEmployeeByEmployeeName(employee.getEmployeeName());

        if(null !=cid){

            LOGGER.info("Name Already exists , Please give the unique Name");

             employee.setEmployeeId(cid);
            throw new DataAlreadyExistsException("Name Already exists , Please give the unique Name");

        }

        Employee saveEmployee =  employeeRepository.save(employee);
        return mapToDto(saveEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

      List<Employee> employees =employeeRepository.findAll();

      return   employees.stream().map(employee -> mapToDto(employee)).collect(Collectors.toList());


    }


    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = mapper.map(employeeDto,Employee.class);
        return  employee;
    }


    private EmployeeDto mapToDto (Employee employee){

        EmployeeDto employeeDto = mapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }

}
