package _5_game.java;

import java.util.HashMap;
import java.util.Map;

public class FourInRow {

    public enum Chip {
        YELLOW,
        RED;

        public Chip opposite() {
            if (this == YELLOW) return RED;
            return YELLOW;
        }
    }

    public static class Cell {
        private final int x;

        private final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cell plus(Cell arg) {
            return new Cell(x + arg.x, y + arg.y);
        }

        public boolean correct(FourInRow field) {
            return x >= 0 && x < field.width && y >= 0 && y < field.height;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Cell) {
                Cell cell = (Cell) obj;
                return x == cell.x && y == cell.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private final Map<Cell, Chip> chips = new HashMap<>();

    private Chip turn = Chip.YELLOW;

    private final int width;

    private final int height;

    private final int winLength;

    public FourInRow(int width, int height, int winLength) {
        this.width = width;
        this.height = height;
        this.winLength = winLength;
    }

    public FourInRow() {
        this(7, 4, 4);
    }

    public Chip get(int x, int y) {
        return get(new Cell(x, y));
    }

    public Chip get(Cell cell) {
        return chips.get(cell);
    }

    public Chip getTurn() {
        return turn;
    }

    public Cell makeTurn(int x) {
        if (x < 0 || x >= width) return null;
        for (int y = 0; y < height; y++) {
            Cell cell = new Cell(x, y);
            if (get(cell) == null) {
                chips.put(cell, turn);
                turn = turn.opposite();
                return cell;
            }
        }
        return null;
    }

    public boolean hasFreeCells() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (get(x, y) == null) return true;
            }
        }
        return false;
    }

    private final Cell[] directions = new Cell[] {
            new Cell(0, 1), new Cell(1, 0), new Cell(1, 1), new Cell(1, -1)
    };

    public Chip winner() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell cell = new Cell(x, y);
                Chip start = get(cell);
                if (start == null) continue;
                for (Cell dir: directions) {
                    int length = 0;
                    Cell current = cell;
                    while (++length < winLength) {
                        current = current.plus(dir);
                        if (!current.correct(this)) break;
                        if (get(current) != start) break;
                    }
                    if (length == winLength) {
                        return start;
                    }
                }
            }
        }
        return null;
    }
}
