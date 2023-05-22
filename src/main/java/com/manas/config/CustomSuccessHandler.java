package com.manas.config;

import com.manas.dto.request.UserRegisteredDTO;
import com.manas.enums.Role;
import com.manas.repository.UserRepository;
import com.manas.service.DefaultUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final DefaultUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String redirectUrl;
        if (authentication.getPrincipal() instanceof DefaultOAuth2User userDetails) {
            String password = authentication.getCredentials().toString();
            System.out.println(password);
            String username = userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login") + "@gmail.com";
            if (userRepository.findByEmail(username).isEmpty()) {
                UserRegisteredDTO user = new UserRegisteredDTO();
                user.setEmail(username);
                user.setName(userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login"));
                user.setPassword(password);
                user.setRole(Role.USER);
                userService.save(user);
                System.out.println(user);
            }
        }
        redirectUrl = "/dashboard";
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
