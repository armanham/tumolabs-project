package com.labs.project.service.user;

import com.labs.project.service.user.model.UserCreationParameter;
import com.labs.project.service.user.model.UserDetails;
//import com.labs.project.service.model.UserLoginParameter;

import java.util.Optional;

public interface UserService {

    Long create(UserCreationParameter parameter);

    Optional<UserDetails> findById(Long id);

 //   UserDetails getById(Long id);

//    Optional<UserDetails> findByUsername(String username);

//    UserDetails getByUsername(String username);

//    UserDetails login(UserLoginParameter parameter);


}
