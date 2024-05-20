package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.service.utilServices.ChosenTopicService;
import ru.shefer.view.Constants;

import static ru.shefer.view.Constants.*;

@Component
public class GetBackToTopicMenuAction extends Action {
    private final ChosenTopicService chosenTopicService;

    public GetBackToTopicMenuAction(ChosenTopicService chosenTopicService) {
        this.chosenTopicService = chosenTopicService;
        actionName = BACK_TO_TOPIC_MENU.getValue();
    }

    @Override
    public void execute() {
        chosenTopicService.dropChosenTopic();
    }
}
