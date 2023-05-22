package com.manas.service.impl;

import com.manas.dto.request.UserRegisteredDTO;
import com.manas.enums.Role;
import com.manas.repository.UserRepository;
import com.manas.service.DefaultUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultUserServiceImpl implements DefaultUserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public com.manas.entity.User save(UserRegisteredDTO userRegisteredDTO) {
        com.manas.entity.User user = new com.manas.entity.User();
        user.setEmail(userRegisteredDTO.getEmail());
        user.setPhoneNumber(userRegisteredDTO.getPhoneNumber());
        user.setName(userRegisteredDTO.getName());
        user.setPassword(bCryptPasswordEncoder.encode(userRegisteredDTO.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.manas.entity.User user = userRepository.findByEmail(email)
                .orElseThrow( ()-> new UsernameNotFoundException("Invalid username or password"));
        return new User(user.getEmail(), user.getPassword(), getAuthorities(user.getRole()));
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
//    }
    public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

}
