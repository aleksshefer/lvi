package ru.shefer.service;

import org.springframework.stereotype.Service;
import ru.shefer.entity.User;
import ru.shefer.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> saveUser(User user) {
        return Optional.of(userRepository.save(user));
    }
}
