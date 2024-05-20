package ru.shefer.view;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import ru.shefer.handler.InputChoiceDataHandler;
import ru.shefer.service.commandLineActions.Action;
import ru.shefer.service.commandLineActions.GetBackToTopicMenuAction;
import ru.shefer.service.commandLineActions.ReadAllPostsAction;
import ru.shefer.service.commandLineActions.WritePostAction;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostMenu extends Menu {
    private final CommandLineOutputService outputService;
    private final InputChoiceDataHandler choiceDataHandler;
    private final CommandLineInputService inputService;

    public PostMenu(ConfigurableApplicationContext context,
                    CommandLineOutputService outputService,
                    InputChoiceDataHandler choiceDataHandler,
                    CommandLineInputService inputService) {
        this.outputService = outputService;
        this.choiceDataHandler = choiceDataHandler;
        this.inputService = inputService;
        setActions(
                new ArrayList<>(List.of(
                        context.getBean(ReadAllPostsAction.class),
                        context.getBean(WritePostAction.class),
                        context.getBean(GetBackToTopicMenuAction.class)
                )));
    }

    @Override
    protected void run() {
        while (true) {

            outputService.printMenuActions(actions);
            int choice = choiceDataHandler.getChoiceInput(inputService.readLine(), actions.size());
            Action chosenAction = actions.get(choice);
            chosenAction.execute();

            if (chosenAction instanceof GetBackToTopicMenuAction) {
                break;
            }
        }
    }
}
