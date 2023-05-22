package com.manas.service;

import com.manas.dto.request.UserRegisteredDTO;
import com.manas.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DefaultUserService extends UserDetailsService {
    User save(UserRegisteredDTO userRegisteredDTO);
}