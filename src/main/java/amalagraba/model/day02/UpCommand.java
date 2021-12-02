package amalagraba.model.day02;

public class UpCommand extends Command {

    public UpCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute(Location location) {
        location.setDepth(location.getDepth() - amount);
    }
}