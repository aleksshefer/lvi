package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.entity.Topic;
import ru.shefer.service.TopicService;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Component
public class DeleteTopicAction extends Action {
    private final CommandLineOutputService outputService;
    private final CommandLineInputService inputService;
    private final TopicService topicService;


    public DeleteTopicAction(CommandLineOutputService outputService,
                             CommandLineInputService inputService,
                             TopicService topicService) {
        this.outputService = outputService;
        this.inputService = inputService;
        this.topicService = topicService;
        actionName = DELETE_POST.getValue();
    }

    @Override
    public void execute() {
        outputService.printMessage(ENTER_POST_TO_DELETE);
        Topic topicToDelete = topicService.findByNameContains(inputService.readLine());

        if (topicToDelete == null) {
            outputService.printMessage(NO_SUCH_POST);
            return;
        }

        topicService.delete(topicToDelete);
    }
}
