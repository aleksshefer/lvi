package ru.shefer.service.commandLineActions;

import org.springframework.stereotype.Component;
import ru.shefer.service.PostService;
import ru.shefer.service.utilServices.CommandLineInputService;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Component
public class WritePostAction extends Action {
    private final CommandLineOutputService outputService;
    private final CommandLineInputService inputService;
    private final PostService postService;

    public WritePostAction(CommandLineOutputService outputService,
                           CommandLineInputService inputService,
                           PostService postService) {
        this.outputService = outputService;
        this.inputService = inputService;
        this.postService = postService;
        actionName = TO_WRITE_POST.getValue();
    }

    @Override
    public void execute() {
        outputService.printMessage(WRITE_POST);
        postService.save(inputService.readLine());
    }
}
