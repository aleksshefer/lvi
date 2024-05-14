package ru.shefer.handler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.shefer.entity.User;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Service
public class UserPasswordHandler {
    private final PasswordEncoder passwordEncoder;
    private final CommandLineOutputService outputService;

    public UserPasswordHandler(PasswordEncoder passwordEncoder, CommandLineOutputService outputService) {
        this.passwordEncoder = passwordEncoder;
        this.outputService = outputService;
    }

    public boolean checkUserPassword(String passwordToCheck, User user) {
        if (passwordEncoder.matches(passwordToCheck, user.getPassword())) {
            return true;
        } else {
            outputService.writeMessage(WRONG_PASSWORD);
            return false;
        }
    }
}
