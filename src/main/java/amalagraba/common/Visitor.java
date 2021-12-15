package amalagraba.common;

public interface Visitor<T> {

    void accept(T visited);
}
