package mineField;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class MineFieldFactory implements AppFactory {
    @Override
    public Model createModel() {
        return null;
    }

    @Override
    public View createView(Model model) {
        return null;
    }

    @Override
    public String getTitle() {
        return "Mine Field";
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public Command makeEditCommand(String name) {
        return null;
    }

    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model model) {
        return null;
    }

    @Override
    public String about() {
        return null;
    }

    @Override
    public String getHelp() {
        return null;
    }
}
