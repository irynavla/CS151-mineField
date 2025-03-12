package mvc;

public interface AppFactory {
    Model createModel();
    View createView(Model model);
    String getTitle();
}
