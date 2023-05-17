import java.util.ArrayList;
import java.util.List;

public class World {

    private int width;
    private int height;
    private Cell[][] cells;

    public void generateGlider(int row, int col) {
        Cell cell = cells[row][col];
        Cell bottomRight = getBottomRightNeighbor(cell);
        Cell bottom = getBottomNeighbor(bottomRight);
        Cell topRight = getTopRightNeighbor(bottom);
        Cell left = getLeftNeighbor(bottom);
        cell.setAlive(true);
        bottomRight.setAlive(true);
        bottom.setAlive(true);
        topRight.setAlive(true);
        left.setAlive(true);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < width; i++) {
            result += "\n";
            for (int j = 0; j < height; j++) {
                if (cells[i][j].isAlive()) {
                    result += "X  ";
                } else {
                    result += ".  ";
                }
            }
        }
        return result;
    }
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell( i, j, false);
            }
        }
    }

    public void nextGeneration() {
        Cell[][] newCells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                List<Cell> neighbors = getNeighborCells(cells[i][j]);
                int aliveNeighbors = 0;
                for (Cell neighbor : neighbors) {
                    if (neighbor.isAlive()) {
                        aliveNeighbors++;
                    }
                }
                if (cells[i][j].isAlive()) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                          newCells[i][j] = new Cell(i, j, false);
                    } else {
                          newCells[i][j] = new Cell(i, j, true);
                    }
                } else {
                    if (aliveNeighbors == 3) {
                        newCells[i][j] = new Cell(i, j, true);
                    } else {
                        newCells[i][j] = new Cell(i, j, false);
                    }
                }
            }
        }
        this.cells = newCells;
    }

    public Cell getLeftNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (column == 0) {
            return cells[row][width - 1];
        } else if (column < width) {
            return cells[row][column - 1];
        }
        return null;
    }
    public Cell getRightNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (column == width - 1) {
            return cells[row][0];
        } else if (column < width) {
            return cells[row][column + 1];
        }
        return null;
    }
    public Cell getTopNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (row == 0) {
            return cells[height - 1][column];
        } else if (row < height) {
            return cells[row - 1][column];
        }
        return null;
    }
    public Cell getBottomNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (row == height - 1) {
            return cells[0][column];
        } else if (row < height) {
            return cells[row + 1][column];
        }
        return null;
    }
    public Cell getTopLeftNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (row == 0) {
            if (column == 0) {
                return cells[height - 1][width - 1];
            } else if (column < width) {
                return cells[height - 1][column - 1];
            }
        } else if (row < height) {
            if (column == 0) {
                return cells[row - 1][width - 1];
            } else if (column < width) {
                return cells[row - 1][column - 1];
            }
        }
        return null;
    }

    public Cell getTopRightNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (row == 0) {
            if (column == width - 1) {
                return cells[height - 1][0];
            } else if (column < width) {
                return cells[height - 1][column + 1];
            }
        } else if (row < height) {
            if (column == width - 1) {
                return cells[row - 1][0];
            } else if (column < width) {
                return cells[row - 1][column + 1];
            }
        }
        return null;
    }

    public Cell getBottomLeftNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (row == height - 1) {
            if (column == 0) {
                return cells[0][width - 1];
            } else if (column < width) {
                return cells[0][column - 1];
            }
        } else if (row < height) {
            if (column == 0) {
                return cells[row + 1][width - 1];
            } else if (column < width) {
                return cells[row + 1][column - 1];
            }
        }
        return null;
    }

    public Cell getBottomRightNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        if (row == height - 1) {
            if (column == width - 1) {
                return cells[0][0];
            } else if (column < width) {
                return cells[0][column + 1];
            }
        } else if (row < height) {
            if (column == width - 1) {
                return cells[row + 1][0];
            } else if (column < width) {
                return cells[row + 1][column + 1];
            }
        }
        return null;
    }


    public List<Cell> getNeighborCells(Cell cell) {
        List<Cell> neighbors = new ArrayList<Cell>();
        neighbors.add(getLeftNeighbor(cell));
        neighbors.add(getRightNeighbor(cell));
        neighbors.add(getTopNeighbor(cell));
        neighbors.add(getBottomNeighbor(cell));
        neighbors.add(getTopLeftNeighbor(cell));
        neighbors.add(getTopRightNeighbor(cell));
        neighbors.add(getBottomLeftNeighbor(cell));
        neighbors.add(getBottomRightNeighbor(cell));
        return neighbors;
    }
}
