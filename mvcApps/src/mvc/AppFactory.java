package mvc;

public interface AppFactory {

    View makeView(Model model);
    Model makeModel();
    String getTitle();
    String getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(Model model, String type);
}
