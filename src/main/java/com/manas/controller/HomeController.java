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
    @GetMapping()
    public String home(){
        return "user/home";
    }

    @GetMapping("/index")
    public String index(){
        return "user/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", UserRequest.builder().build());
        return "user/login";
    }

    @PostMapping
    public String loginAfter(@ModelAttribute("user") UserRequest userRequest){
        userService.authenticate(userRequest);
        return "redirect:/index";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user")  User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/register";
        }
        userService.save(user);
        return "redirect:/index";
    }


}
