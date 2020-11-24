package view;

import controller.MoveController;
import model.CellStatus;
import model.Game;
import model.GameField;
import model.PersName;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class WindowView extends JFrame implements Runnable{

    private int cellSize = 100;
    private int widthInCells = 5;
    private int heightInCells = 4;

    private Game game;
    private Graphics g;

    private HashMap<PersName, BufferedImage> images = new HashMap<>();
    private BufferedImage back;


    public WindowView (Game game) {
        this.game = game;
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(150, 150, widthInCells * cellSize, heightInCells * cellSize);
        this.setResizable(false);
        initImages();
        g = this.getGraphics();
        paintField(game, g);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int cellX = x / cellSize;
                int cellY = y / cellSize;
                MoveController.makeMove(cellX, cellY, game);
                paintField(game, g);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void initImages(){
        for(PersName name : PersName.values()) {
            try{
                BufferedImage image =
                        ImageIO.read(new File("images\\" + name + ".png"));
                images.put(name, image);
            } catch (IOException e) {
                System.out.println("файла " + name + " не существует ;(");
            }
        }
        try {
            back = ImageIO.read(new File("images\\back.jpg"));
        } catch (IOException e) {
            System.out.println("Рубашка карт не найдена");
        }
    }

    public void paintField (Game game, Graphics g) {
        clearField(g);
        GameField field = game.getField();
        for (int i = 0; i < heightInCells; i++) {
            for (int j = 0; j < widthInCells; j++) {
                switch (field.getCell(i, j).getStatus()) {
                    case CLOSE:
                        g.drawImage(back,
                                i*cellSize,
                                j*cellSize,
                                cellSize,
                                cellSize, null);
                        break;
                    case OPEN:
                        g.drawImage(images.get(field.getCell(i, j).getId()),
                                i*cellSize,
                                j*cellSize,
                                cellSize,
                                cellSize, null);
                        break;
                    case INACTIVE:
                        break;
                }

            }
        }

    }

    private void clearField(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, widthInCells * cellSize, heightInCells*cellSize);
    }

    @Override
    public void run() {
        while (true) {
            paintField(game, g);
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
