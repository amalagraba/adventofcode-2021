package amalagraba.model.day02;

public class DownCommand extends Command {

    public DownCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute(Location location) {
        location.setDepth(location.getDepth() + amount);
    }
}