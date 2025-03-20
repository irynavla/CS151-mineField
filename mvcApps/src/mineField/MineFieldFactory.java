package mineField;
import mvc.*;

public class MineFieldFactory implements AppFactory {

    @Override
    public Model makeModel() {
        MineFieldModel model = new MineFieldModel(10, 10);
        model.initializeGrid();
        return model;
    }

    @Override
    public View makeView(Model model) {
        if (model instanceof MineFieldModel) {
            return new MineFieldView((MineFieldModel) model);
        }
        throw new IllegalArgumentException("Invalid model type for MineFieldView");
    }

    @Override
    public String getHelp() {
        return "Help: Use the direction buttons to move around the minefield.";
    }

    @Override
    public String about() {
        return "MineField Game\nVersion 1.0\nDeveloped by YourName";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Move North", "Move East", "Move South", "Move West", "Move Northeast", "Move Northwest", "Move Southeast", "Move Southwest"};
    }

    @Override
    public Command makeEditCommand(Model model, String type) {
        switch (type) {
            case "Move North": return new MineFieldCommand((MineFieldModel) model, Heading.N);
            case "Move East": return new MineFieldCommand((MineFieldModel) model, Heading.E);
            case "Move South": return new MineFieldCommand((MineFieldModel) model, Heading.S);
            case "Move West": return new MineFieldCommand((MineFieldModel) model, Heading.W);
            case "Move Northeast": return new MineFieldCommand((MineFieldModel) model, Heading.NE);
            case "Move Northwest": return new MineFieldCommand((MineFieldModel) model, Heading.NW);
            case "Move Southeast": return new MineFieldCommand((MineFieldModel) model, Heading.SE);
            case "Move Southwest": return new MineFieldCommand((MineFieldModel) model, Heading.SW);
            default: return null;
        }
    }

    @Override
    public String getTitle() {
        return "MineField Game";
    }
}
