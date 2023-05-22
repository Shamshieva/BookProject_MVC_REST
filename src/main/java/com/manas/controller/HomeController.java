package com.manas.controller;

import com.manas.dto.request.UserRequest;
import com.manas.entity.User;
import com.manas.entity.Vendor;
import com.manas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class HomeController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    @GetMapping
    public String home(){
        return "user/home";
    }

}
