package ru.shefer.service.commandLineActions;

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

    public RegistrationAction(UserService userService, CommandLineInputService inputService, CommandLineOutputService outputService) {
        actionName = REGISTER.getValue();
        this.userService = userService;
        this.inputService = inputService;
        this.outputService = outputService;
    }

    @Override
    public void execute() {
        User newUser = new User();
        outputService.writeMessage(ENTER_USER_NAME);
        newUser.setName(inputService.readLine());

        outputService.writeMessage(ENTER_USER_SURNAME);
        newUser.setSurname(inputService.readLine());

        outputService.writeMessage(ENTER_EMAIL);
        newUser.setEmail(inputService.readLine());

        outputService.writeMessage(ENTER_PASSWORD);
        newUser.setPassword(inputService.readLine());

        userService.saveUser(newUser);
    }
}
