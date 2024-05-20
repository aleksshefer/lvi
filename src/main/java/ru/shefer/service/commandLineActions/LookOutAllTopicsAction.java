package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.service.TopicService;
import ru.shefer.service.utilServices.CommandLineOutputService;
import ru.shefer.view.Constants;

@Component
public class LookOutAllTopicsAction extends Action {
    private final TopicService topicService;
    private final CommandLineOutputService commandLineOutputService;

    public LookOutAllTopicsAction(TopicService topicService,
                                  CommandLineOutputService commandLineOutputService) {
        this.topicService = topicService;
        this.commandLineOutputService = commandLineOutputService;
        actionName = Constants.LOOK_OUT_ALL_TOPICS.getValue();
    }

    @Override
    public void execute() {
        commandLineOutputService.printTopicList(topicService.findAll());
    }
}
