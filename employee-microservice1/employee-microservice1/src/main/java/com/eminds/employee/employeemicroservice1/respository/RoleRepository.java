package com.eminds.employee.employeemicroservice1.respository;

import com.eminds.employee.employeemicroservice1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {


    Optional<Role> findByName(String name);

}
