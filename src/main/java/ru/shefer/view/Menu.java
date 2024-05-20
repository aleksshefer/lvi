package ru.shefer.view;

import ru.shefer.service.commandLineActions.Action;

import java.util.List;

public abstract class Menu {
    protected List<Action> actions;

    protected void setActions(List<Action> actions) {
        this.actions = actions;
    }

    protected abstract void run();
}
