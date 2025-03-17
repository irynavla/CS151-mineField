package mvc;

public interface AppFactory {
    Model makeModel();
    View makeView(Model model);
    String getTitle();
    String getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(String name);
    Model createModel();
}
