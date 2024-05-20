package ru.shefer.handler;

import org.springframework.stereotype.Service;
import ru.shefer.exception.WrongMenuChoiceException;
import ru.shefer.service.utilServices.CommandLineOutputService;

import static ru.shefer.view.Constants.*;

@Service
public class InputChoiceDataHandler {
    private final CommandLineOutputService outputService;

    public InputChoiceDataHandler(CommandLineOutputService outputService) {
        this.outputService = outputService;
    }

    public int getChoiceInput(String inputString, int choiceCount) {
        try {
            int result = Integer.parseInt(inputString) - 1;

            if (result < 0 || result >= choiceCount) {
                outputService.printMessage(WRONG_MENU_CHOICE_COUNT);
                throw new WrongMenuChoiceException();
            }
            return result;
        } catch (NumberFormatException e) {
            outputService.printMessage(WRONG_MENU_INPUT);
            throw new WrongMenuChoiceException();
        }
    }
}
