package ru.shefer.handler;

import org.springframework.stereotype.Service;
import ru.shefer.entity.User;
import ru.shefer.service.utilServices.CommandLineOutputService;
import ru.shefer.service.UserService;

import java.util.Optional;

import static ru.shefer.view.Constants.*;

@Service
public class UserDataHandler {
    private final UserService userService;
    private final CommandLineOutputService outputService;


    public UserDataHandler(UserService userService,
                           CommandLineOutputService outputService) {
        this.userService = userService;
        this.outputService = outputService;
    }

    public User getUserByInputEmail(String email) {
        Optional<User> userByEmail = userService.getUserByEmail(email);

        if (userByEmail.isPresent()) {
            return userByEmail.get();
        } else {
            outputService.printMessage(NO_SUCH_USER_EXIST);
            return null;
        }
    }
}
