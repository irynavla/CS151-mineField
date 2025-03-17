package stopLight;

import mvc.*;

public class StoplightFactory implements AppFactory {

    public Model makeModel() { return new Stoplight(); }

    public View createModel(Model m) {
        return new StoplightView((Stoplight)m);
    }

    public String[] getEditCommands() { return new String[] {"Change"}; }

    @Override
    public Command makeEditCommand(String name) {
        return null;
    }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Change")
            return new ChangeCommand(model);
        return null;
    }

    @Override
    public Model createModel() {
        return null;
    }

    @Override
    public View makeView(Model model) {
        return null;
    }

    public String getTitle() {
        return "Stop Light Simulator";
    }

    public String getHelp() {
        String s = "click Change to cycle through colors";
        return s;
    }

    public String about() {
        return "Stoplight Simulator version 1.0. Copyright 2020 by Cyberdellic Designs";
    }

}