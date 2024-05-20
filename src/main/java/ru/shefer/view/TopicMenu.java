package ru.shefer.view;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import ru.shefer.handler.InputChoiceDataHandler;
import ru.shefer.service.commandLineActions.*;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;
import ru.shefer.service.utilServices.LoggedUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicMenu extends Menu {

    private final CommandLineOutputService outputService;
    private final CommandLineInputService inputService;
    private final InputChoiceDataHandler choiceDataHandler;
    private final ConfigurableApplicationContext context;
    private final LoggedUserService loggedUserService;
    private final PostMenu postMenu;

    public TopicMenu(ConfigurableApplicationContext context,
                     CommandLineOutputService outputService,
                     CommandLineInputService inputService,
                     InputChoiceDataHandler choiceDataHandler,
                     PostMenu postMenu,
                     LoggedUserService loggedUserService) {
        this.outputService = outputService;
        this.inputService = inputService;
        this.choiceDataHandler = choiceDataHandler;
        this.postMenu = postMenu;
        this.context = context;
        this.loggedUserService = loggedUserService;
        setActions(new ArrayList<>(List.of(
                context.getBean(CreateTopicAction.class),
                context.getBean(LookOutAllTopicsAction.class),
                context.getBean(GetIntoTopicAction.class),
                context.getBean(GetBackToMainMenuAction.class)
        )));
    }

    @Override
    protected void run() {
        if (loggedUserService.getLoggedUser().getRole().equals("admin")) {
            actions.add(1, context.getBean(DeleteTopicAction.class));
        }

        while (true) {
            outputService.printMenuActions(actions);
            int choice = choiceDataHandler.getChoiceInput(inputService.readLine(), actions.size());
            Action chosenAction = actions.get(choice);
            chosenAction.execute();

            if (chosenAction instanceof GetBackToMainMenuAction) {
                break;
            } else if (chosenAction instanceof GetIntoTopicAction) {
                postMenu.run();
            }
        }
    }
}
