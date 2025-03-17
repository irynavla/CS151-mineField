package mineField;

public class MineFieldHeading {
    private Heading currentHeading = Heading.E;

    public Heading getCurrentHeading() {
        return currentHeading;
    }

    public void setCurrentHeading(Heading heading) {
        this.currentHeading = heading;
    }
}
