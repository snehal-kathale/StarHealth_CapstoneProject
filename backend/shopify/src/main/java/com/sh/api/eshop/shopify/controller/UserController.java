package com.sh.api.eshop.shopify.controller;


import com.sh.api.eshop.shopify.Dto.ResponseDto;
import com.sh.api.eshop.shopify.Dto.user.SignInDto;
import com.sh.api.eshop.shopify.Dto.user.SignInResponseDto;
import com.sh.api.eshop.shopify.Dto.user.SignupDto;
import com.sh.api.eshop.shopify.entity.User;
import com.sh.api.eshop.shopify.exception.util.AuthenticationFailException;
import com.sh.api.eshop.shopify.exception.util.CustomException;
import com.sh.api.eshop.shopify.repository.UserRepository;
import com.sh.api.eshop.shopify.service.imp.AuthenticationService;
import com.sh.api.eshop.shopify.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
     UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }


}
