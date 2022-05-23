package com.eminds.employee.employeemicroservice1.service;

import com.eminds.employee.employeemicroservice1.dto.RegisterDto;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;

public interface UserService {
    RegisterDto registerUser(RegisterDto registerDto) throws DataAlreadyExistsException;
}
