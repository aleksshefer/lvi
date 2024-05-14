package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.view.Constants;

@Component
public class AppExitAction extends Action {
    public AppExitAction() {
        actionName = Constants.APP_EXIT.getValue();
    }

    @Override
    public void execute() {
        System.exit(1);
    }
}
