package mineField;
import mvc.Command;
public class MineFieldCommand extends Command{
    private Heading heading;

    public MineFieldCommand(MineFieldModel model, Heading heading) {
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
