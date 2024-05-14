package ru.shefer.handler;

import org.springframework.stereotype.Service;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Service
public class InputIntegerDataHandler {
    private final CommandLineOutputService outputService;

    public InputIntegerDataHandler(CommandLineOutputService outputService) {
        this.outputService = outputService;
    }

    public int getIntegerInput(String inputString, int choiceCount) {
        try {
            int result = Integer.parseInt(inputString);

            if (result < 1 || result > choiceCount) {
                outputService.writeMessage(WRONG_MENU_CHOICE_COUNT);
                return 0;
            }
            return result;
        } catch (NumberFormatException e) {
            outputService.writeMessage(WRONG_MENU_INPUT);
            return 0;
        }
    }
}
