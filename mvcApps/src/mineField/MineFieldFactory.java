package mineField;
import mvc.*;

public class MineFieldFactory implements AppFactory {

    public Model makeModel() {
        return new MineFieldModel(20, 20);
    }

    public View makeView(Model model) {
        System.out.println("New view made");
        return new MineFieldView((MineFieldModel) model);
    }

    public String[] getHelp() { //Using the help menu option requires a String Array (also stoplightFactory has it setup like this)
        return new String[]{"Help: Use the direction buttons to move around the minefield."};
    }

    public String about() {
        return "MineField Game\nVersion 1.0\nDeveloped by Iryna Vlasiuk";
    }

    public String[] getEditCommands() {
        return new String[] {"N", "E", "S", "W", "NE", "NW", "SE", "SW"};
    }

    public Command makeEditCommand(Model model, String type) {
        switch (type) {
            case "N": return new MineFieldCommand(model, Heading.N);
            case "E": return new MineFieldCommand(model, Heading.E);
            case "W": return new MineFieldCommand(model, Heading.W);
            case "S": return new MineFieldCommand(model, Heading.S);
            case "NE": return new MineFieldCommand(model, Heading.NE);
            case "NW": return new MineFieldCommand(model, Heading.NW);
            case "SE": return new MineFieldCommand(model, Heading.SE);
            case "SW": return new MineFieldCommand(model, Heading.SW);
            default: return null;
        }
    }

    public String getTitle() {
        return "MineField Game";
    }
}
