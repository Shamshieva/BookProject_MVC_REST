package com.manas.controller;

import com.manas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final UserRepository userRepository;

    @GetMapping
    public String displayDashboard(Model model){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext.getAuthentication().getPrincipal() instanceof DefaultOAuth2User) {
            DefaultOAuth2User user = (DefaultOAuth2User) securityContext.getAuthentication().getPrincipal();
            model.addAttribute("userDetails", user.getAttribute("name")!= null ?user.getAttribute("name"):user.getAttribute("login"));
        }else {
            User user = (User) securityContext.getAuthentication().getPrincipal();
            com.manas.entity.User users = userRepository.findByEmail(user.getUsername()).get();
            model.addAttribute("userDetails", users.getName());
        }
        return "user/index2";
    }
}
