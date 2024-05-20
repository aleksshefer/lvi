package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.entity.Topic;
import ru.shefer.service.TopicService;
import ru.shefer.service.utilServices.ChosenTopicService;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Component
public class GetIntoTopicAction extends Action {
    private final CommandLineOutputService outputService;
    private final CommandLineInputService inputService;
    private final TopicService topicService;
    private final ChosenTopicService chosenTopicService;


    public GetIntoTopicAction(CommandLineOutputService outputService,
                              CommandLineInputService inputService,
                              TopicService topicService,
                              ChosenTopicService chosenTopicService) {
        this.outputService = outputService;
        this.inputService = inputService;
        this.topicService = topicService;
        this.chosenTopicService = chosenTopicService;
        actionName = GET_INTO_TOPIC.getValue();
    }

    @Override
    public void execute() {
        outputService.printMessage(CHOOSE_POST);
        Topic topic = topicService.findByNameContains(inputService.readLine());

        if (topic == null) {
            outputService.printMessage(NO_SUCH_POST);
            return;
        }

        chosenTopicService.chooseTopic(topic);
    }
}
