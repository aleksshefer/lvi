package ru.shefer.view;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import ru.shefer.exception.WrongMenuChoiceException;
import ru.shefer.handler.InputChoiceDataHandler;
import ru.shefer.service.commandLineActions.Action;
import ru.shefer.service.commandLineActions.AppExitAction;
import ru.shefer.service.commandLineActions.LogInAction;
import ru.shefer.service.commandLineActions.RegistrationAction;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainMenu extends Menu {
    private final CommandLineOutputService outputService;
    private final CommandLineInputService inputService;
    private final InputChoiceDataHandler choiceDataHandler;
    private final TopicMenu topicMenu;

    public MainMenu(ConfigurableApplicationContext context,
                    CommandLineOutputService outputService,
                    CommandLineInputService inputService,
                    InputChoiceDataHandler choiceDataHandler,
                    TopicMenu topicMenu) {
        this.outputService = outputService;
        this.inputService = inputService;
        this.choiceDataHandler = choiceDataHandler;
        this.topicMenu = topicMenu;
        setActions(new ArrayList<>(List.of(
                context.getBean(LogInAction.class),
                context.getBean(RegistrationAction.class),
                context.getBean(AppExitAction.class)
        )));
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            outputService.printMenuActions(actions);
            int choice;
            try {
                choice = choiceDataHandler.getChoiceInput(inputService.readLine(), actions.size());
            } catch (WrongMenuChoiceException e) {
                continue;
            }
            Action chosenAction = actions.get(choice);
            chosenAction.execute();

            if (chosenAction instanceof LogInAction) {
                topicMenu.run();
            }
        }
    }

}
