package com.eminds.employee.employeemicroservice1.service;

import com.eminds.employee.employeemicroservice1.dto.RegisterDto;
import com.eminds.employee.employeemicroservice1.entity.User;
import com.eminds.employee.employeemicroservice1.exception.DataAlreadyExistsException;
import com.eminds.employee.employeemicroservice1.respository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private static  final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public RegisterDto registerUser(RegisterDto registerDto) throws DataAlreadyExistsException {

        User user = new User();
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setName(registerDto.getName());
        user.setRoles(registerDto.getRoles());

        Long cid = userRepository.getUserByEmail(user.getEmail());
        Long cid1 =userRepository.getUserByUsername(user.getUsername());
      if(null !=cid ){

          LOGGER.debug("Email is Already exist , please sign up with a new email");
          throw new DataAlreadyExistsException("Email is Already exist , please sign up with a new email");
      }
       if(null !=cid1){

          LOGGER.debug("Username is already exist , please use a another one");
          throw new DataAlreadyExistsException("Username is already exist , please use a another one");
        }

         User saveUser = userRepository.save(user);
         return mapToDto(saveUser);
    }



        private User mapToEntity(RegisterDto registerDto){


        User user =mapper.map(registerDto,User.class);
        return  user;

    }

    private RegisterDto mapToDto(User user){


        RegisterDto registerDto =mapper.map(user,RegisterDto.class);
        return  registerDto;

    }

}
