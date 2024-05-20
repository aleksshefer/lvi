package ru.shefer.service.commandLineActions;

import lombok.Getter;

@Getter
public abstract class Action {
    protected String actionName;

    public abstract void execute();

}
