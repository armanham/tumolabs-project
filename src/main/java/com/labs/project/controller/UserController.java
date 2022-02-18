package com.labs.project.controller;

import com.labs.project.service.user.UserService;
import com.labs.project.service.user.model.UserCreationParameter;
//import com.labs.project.service.model.UserLoginParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("tittle", "User");
        return "user";
    }

    @GetMapping("/user/sign-in")
    public String signIn(Model model) {
        model.addAttribute("tittle", "SignIn");
        return "user-sign-in";
    }

    @PostMapping("/user/sign-in")
    public String signIn(Model model, final UserCreationRequest request) {
        model.addAttribute("tittle", "SignIn");
        final UserCreationParameter creationParameter = new UserCreationParameter(
                request.getName(),
                request.getSurname(),
                request.getUsername(),
                request.getPassword()
        );

        final UserCreationResponse creationResponse = new UserCreationResponse();

        try {
            creationResponse.setId(service.create(creationParameter));
            ResponseEntity.ok(creationResponse);
            return "redirect:/user";
        } catch (RuntimeException ex) {
            creationResponse.setMessage(ex.getMessage());
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(creationResponse);
            return "user-sign-in-try-again";
        }
    }
//
//    @GetMapping("/user/sign-up")
//    public String signUp(Model model) {
//        model.addAttribute("tittle", "SignUp");
//        return "user-sign-up";
//    }
//
//    @GetMapping("/user/sign-up")
//    public String signUp(Model model, final UserLoginRequest request) {
//        model.addAttribute("tittle", "SignUp");
//        final UserLoginParameter loginParameter = new UserLoginParameter(
//                request.getUsername(),
//                request.getPassword()
//        );
//
//        final UserLoginResponse loginResponse = new UserLoginResponse();
//        try {
//            loginResponse.setDetailsDTO(toDTO(service.login(loginParameter)));
//            ResponseEntity.ok(loginResponse);
//            return "user-page";
//        } catch (UsernameNotFoundException | WrongPasswordException ex) {
//            loginResponse.setMessage(ex.getMessage());
//            ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginResponse);
//            return "user-sign-up-try-again";
//        }
//    }
//
//    private UserDetailsDTO toDTO(final UserDetails details) {
//        UserDetailsDTO detailsDTO = new UserDetailsDTO();
//        detailsDTO.setName(details.getName());
//        detailsDTO.setSurname(details.getSurname());
//        detailsDTO.setUsername(details.getUsername());
//        detailsDTO.setCreatedOn(details.getCreatedOn());
//        detailsDTO.setUpdatedOn(details.getUpdatedOn());
//        return detailsDTO;
//    }
}
