import model.*;
import view.WindowView;


public class Main {

    public static void main(String[] args) {
        GameField field = new GameField(4, 5);
        MoveCounter counter = new MoveCounter();
        Timer timer = new Timer(100);
        Game game = new Game(field, counter, timer);
        WindowView window = new WindowView(game);
        new Thread(window).start();
    }

}
