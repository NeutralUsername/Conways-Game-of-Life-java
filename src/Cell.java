public class Cell {
    private int row;
    private int column;

    private boolean alive;

    public Cell( int row, int column, boolean alive) {
        this.row = row;
        this.column = column;
        this.alive = alive;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
