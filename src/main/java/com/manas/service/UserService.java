package com.manas.service;

import com.manas.dto.request.UserRequest;
import com.manas.entity.Transaction;
import com.manas.entity.User;
import com.manas.repository.UserRepository;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);

    User getById(Long userId);

    void update(Long userId, User user);

    void delete(Long userId);

    List<Transaction> getTransactions(Long userId);

    void authenticate(UserRequest userRequest);
}
