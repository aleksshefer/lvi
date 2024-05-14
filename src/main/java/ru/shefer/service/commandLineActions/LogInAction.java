package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.entity.User;
import ru.shefer.handler.UserDataHandler;
import ru.shefer.handler.UserPasswordHandler;
import ru.shefer.service.utilServices.CommandLineOutputService;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.LoggedUserService;
import ru.shefer.service.UserService;

import static ru.shefer.view.Constants.*;

@Component
public class LogInAction extends Action {
    private final CommandLineInputService inputService;
    private final CommandLineOutputService outputService;
    private final UserPasswordHandler userPasswordHandler;
    private final UserDataHandler userDataHandler;
    private final LoggedUserService loggedUserService;

    public LogInAction(CommandLineInputService inputService, CommandLineOutputService outputService, UserPasswordHandler userPasswordHandler, UserDataHandler userDataHandler, UserService userService, LoggedUserService loggedUserService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.userPasswordHandler = userPasswordHandler;
        this.userDataHandler = userDataHandler;
        this.loggedUserService = loggedUserService;
        actionName = LOG_IN.getValue();
    }

    @Override
    public void execute() {
        int attempt = 4;

        while (attempt != 0) {
            attempt--;

            outputService.writeMessage(ENTER_EMAIL);
            User userByEmail = userDataHandler.getUserByInputEmail(inputService.readLine());
            if (userByEmail == null) {
                outputService.writeMessage(NUMBER_OF_ATTEMPTS, attempt);
                continue;
            }

            outputService.writeMessage(ENTER_PASSWORD);
            if (userPasswordHandler.checkUserPassword(inputService.readLine(), userByEmail)) {
                loggedUserService.userLogIn(userByEmail);
            } else {
                outputService.writeMessage(NUMBER_OF_ATTEMPTS, attempt);
            }
        }
    }
}
