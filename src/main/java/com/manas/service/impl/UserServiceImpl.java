package com.manas.service.impl;

import com.manas.dto.request.UserRequest;
import com.manas.entity.Transaction;
import com.manas.entity.User;
import com.manas.repository.UserRepository;
import com.manas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public void update(Long userId, User user) {
        User user1 = userRepository.findById(userId).orElseThrow();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setEmail(user.getEmail());
        userRepository.save(user1);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Transaction> getTransactions(Long userId) {
        return null;
    }

    @Override
    public void authenticate(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.email()).orElseThrow();
        if (!user.getPassword().equals(userRequest.password())){
            throw new BadCredentialsException("Invalid password!");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.email(), userRequest.password()));

    }
}
