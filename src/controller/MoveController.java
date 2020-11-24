package controller;

import model.Cell;
import model.CellStatus;
import model.Game;
import model.GameField;

import javax.swing.plaf.TableHeaderUI;

public class MoveController {

    private static Cell firstOpenCell;
    private static Cell secondOpenCell;

    public static void makeMove(int x, int y, Game game) {
        GameField field = game.getField();
        Cell cell = field.getCell(x, y);
        switch (cell.getStatus()) {
            case CLOSE:
                cell.setStatus(CellStatus.OPEN);
                game.getCounter().increaseMoveCounter();
                if (countOpenCells(field) == 2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    checkField(field);
                }
                break;
            case OPEN:
                cell.setStatus(CellStatus.CLOSE);
                game.getCounter().increaseMoveCounter();
                break;
            case INACTIVE:
                break;
        }



    }

    private static void checkField(GameField field) {
        if (firstOpenCell.getId() == secondOpenCell.getId()) {
            firstOpenCell.setStatus(CellStatus.INACTIVE);
            secondOpenCell.setStatus(CellStatus.INACTIVE);
        } else {
            firstOpenCell.setStatus(CellStatus.CLOSE);
            secondOpenCell.setStatus(CellStatus.CLOSE);
        }
    }

    public static int countOpenCells(GameField field) {
        firstOpenCell = null;
        secondOpenCell = null;
        int count = 0;
        int width = field.getWidth();
        int height = field.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field.getCell(i, j).getStatus() == CellStatus.OPEN) {
                    count++;
                    if (firstOpenCell == null) {
                        firstOpenCell = field.getCell(i, j);
                    } else {
                        secondOpenCell = field.getCell(i, j);
                    }
                }
            }
        }
        return count;
    }

}
