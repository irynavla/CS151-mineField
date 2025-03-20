package mineField;
import mvc.Command;
import mvc.Model;

public class MineFieldCommand extends Command{
    private Heading heading;

    public MineFieldCommand(Model model, Heading heading) {
        super(model);
        this.heading = heading;
    }

    @Override
    public void execute() {
        MineFieldModel field = (MineFieldModel) model;
        try {
            field.move(heading);
        } catch (GameOverException | IllegalMoveException | WinException | LoseException e) {
            // Already handled by custom exceptions
        }
    }
}
