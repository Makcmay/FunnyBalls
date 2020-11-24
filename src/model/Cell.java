package model;

public class Cell {

    private CellStatus status = CellStatus.CLOSE;
    private int x;
    private int y;
    private PersName id;

    public Cell(int x, int y, PersName id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public CellStatus getStatus() {
        return status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PersName getId() {
        return id;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
