package ru.shefer.service.commandLineActions;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.shefer.entity.User;
import ru.shefer.service.utilServices.CommandLineOutputService;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.UserService;

import static ru.shefer.view.Constants.*;

@Component
public class RegistrationAction extends Action {
    private final UserService userService;
    private final CommandLineInputService inputService;
    private final CommandLineOutputService outputService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationAction(UserService userService,
                              CommandLineInputService inputService,
                              CommandLineOutputService outputService,
                              PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.inputService = inputService;
        this.outputService = outputService;
        actionName = REGISTER.getValue();
    }

    @Override
    public void execute() {
        User newUser = new User();
        outputService.printMessage(ENTER_USER_NAME);
        newUser.setName(inputService.readLine());

        outputService.printMessage(ENTER_USER_SURNAME);
        newUser.setSurname(inputService.readLine());

        outputService.printMessage(ENTER_EMAIL);
        newUser.setEmail(inputService.readLine());

        outputService.printMessage(ENTER_PASSWORD);
        newUser.setPassword(passwordEncoder.encode(inputService.readLine()));

        userService.saveUser(newUser);
    }
}
