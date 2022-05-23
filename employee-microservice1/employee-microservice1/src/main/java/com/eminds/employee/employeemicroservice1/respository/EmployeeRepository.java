package com.eminds.employee.employeemicroservice1.respository;

import com.eminds.employee.employeemicroservice1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("select u.employeeId from Employee u where u.employeeName =?1 ")
    Integer getEmployeeByEmployeeName(String employeeName);
}
