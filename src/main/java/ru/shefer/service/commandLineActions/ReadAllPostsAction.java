package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.service.PostService;
import ru.shefer.service.utilServices.ChosenTopicService;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Component
public class ReadAllPostsAction extends Action {
    private final CommandLineOutputService outputService;
    private final PostService postService;
    private final ChosenTopicService chosenTopicService;

    public ReadAllPostsAction(CommandLineOutputService outputService,
                              PostService postService,
                              ChosenTopicService chosenTopicService) {
        this.outputService = outputService;
        this.postService = postService;
        this.chosenTopicService = chosenTopicService;
        actionName = READ_ALL_POSTS.getValue();
    }

    @Override
    public void execute() {
        outputService.printPostList(
                postService.findByTopic(
                        chosenTopicService.getChosenTopic()
                )
        );
    }
}
