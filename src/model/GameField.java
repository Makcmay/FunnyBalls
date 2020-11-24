package model;

public class GameField {

    private int width;
    private int height;
    private Cell[][] cells;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        init();
    }

    private void init() {
        cells[0][0] = new Cell(0,0, PersName.BARASH);
        cells[0][1] = new Cell(0,1, PersName.BARASH);
        cells[0][2] = new Cell(0,0, PersName.BIBI);
        cells[0][3] = new Cell(0,1, PersName.BIBI);
        cells[0][4] = new Cell(0,0, PersName.EZHIK);
        cells[1][0] = new Cell(0,1, PersName.EZHIK);
        cells[1][1] = new Cell(0,0, PersName.KARYCH);
        cells[1][2] = new Cell(0,1, PersName.KARYCH);
        cells[1][3] = new Cell(0,0, PersName.KOPATYCH);
        cells[1][4] = new Cell(0,1, PersName.KOPATYCH);
        cells[2][0] = new Cell(0,0, PersName.KROSH);
        cells[2][1] = new Cell(0,1, PersName.KROSH);
        cells[2][2] = new Cell(0,0, PersName.LOSYASH);
        cells[2][3] = new Cell(0,1, PersName.LOSYASH);
        cells[2][4] = new Cell(0,0, PersName.NYUSHA);
        cells[3][0] = new Cell(0,1, PersName.NYUSHA);
        cells[3][1] = new Cell(0,0, PersName.PIN);
        cells[3][2] = new Cell(0,1, PersName.PIN);
        cells[3][3] = new Cell(0,0, PersName.SOVUNIYA);
        cells[3][4] = new Cell(0,1, PersName.SOVUNIYA);
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
