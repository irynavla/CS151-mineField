package mineField;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class MineFieldFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new MineFieldModel(10, 10); // Example grid size
    }

    @Override
    public View makeView(Model model) {
        return new MineFieldView((MineFieldModel) model);
    }

    @Override
    public String getTitle() {
        return "Mine Field";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Move North", "Move East", "Move South", "Move West"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Move North": return new MineFieldCommand(model, Heading.N);
            case "Move East": return new MineFieldCommand(model, Heading.E);
            case "Move South": return new MineFieldCommand(model, Heading.S);
            case "Move West": return new MineFieldCommand(model, Heading.W);
            default: return null;
        }
    }

    @Override
    public String about() {
        return "Mine Field Game v1.0";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Move using directional commands. Avoid mines!"};
    }
}
