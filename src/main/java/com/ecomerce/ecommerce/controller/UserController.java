package com.ecomerce.ecommerce.controller;
import com.ecomerce.ecommerce.dto.ResponseDto;
import com.ecomerce.ecommerce.dto.user.SignInDto;
import com.ecomerce.ecommerce.dto.user.SignInResponseDto;
import com.ecomerce.ecommerce.dto.user.SignupDto;
import com.ecomerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    // two Apis

    // SignUp

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }

    //SignIn

    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
}
