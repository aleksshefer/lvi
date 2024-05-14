package ru.shefer.service.commandLineActions;

public abstract class Action {
    protected String actionName;

    public abstract void execute();

    public String getActionName() {
        return actionName;
    }
}
