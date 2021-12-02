package amalagraba.model.day02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Command {

    protected final int amount;

    public abstract void execute(Location location);
}