package ru.shefer.service.commandLineActions;

import ru.shefer.entity.Topic;
import ru.shefer.service.TopicService;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;
import ru.shefer.service.utilServices.LoggedUserService;

import static ru.shefer.view.Constants.*;

public class CreateTopicAction extends Action {
    private final CommandLineInputService inputService;
    private final CommandLineOutputService outputService;
    private final TopicService topicService;
    private final LoggedUserService loggedUserService;

    public CreateTopicAction(CommandLineInputService inputService,
                             CommandLineOutputService outputService,
                             TopicService topicService,
                             LoggedUserService loggedUserService) {
        actionName = CREATE_TOPIC.getValue();
        this.inputService = inputService;
        this.outputService = outputService;
        this.topicService = topicService;
        this.loggedUserService = loggedUserService;
    }

    @Override
    public void execute() {
        Topic topic = new Topic();
        outputService.writeMessage(ENTER_TOPIC_NAME);
        topic.setName(inputService.readLine());
        topic.setAuthor();
        outputService
    }
}
