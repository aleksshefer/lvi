package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.service.utilServices.LoggedUserService;

import static ru.shefer.view.Constants.*;

@Component
public class GetBackToMainMenuAction extends Action {
    private final LoggedUserService loggedUserService;

    public GetBackToMainMenuAction(LoggedUserService loggedUserService) {
        this.loggedUserService = loggedUserService;
        actionName = GET_BACK_TO_MAIN_MENU.getValue();
    }

    @Override
    public void execute() {
        loggedUserService.userLogOut();
    }
}
