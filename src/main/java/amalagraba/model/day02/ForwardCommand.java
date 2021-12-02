package amalagraba.model.day02;

public class ForwardCommand extends Command {

    public ForwardCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute(Location location) {
        location.setHorizontal(location.getHorizontal() + amount);
    }
}