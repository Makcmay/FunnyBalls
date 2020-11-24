package model;

public class Game {
    private GameField field;
    private MoveCounter counter;
    private Timer timer;

    public Game(GameField field, MoveCounter counter, Timer timer) {
        this.field = field;
        this.counter = counter;
        this.timer = timer;
    }

    public GameField getField() {
        return field;
    }

    public MoveCounter getCounter() {
        return counter;
    }

    public Timer getTimer() {
        return timer;
    }
}
