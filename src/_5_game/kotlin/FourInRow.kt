package _5_game.kotlin

import java.util.*

class FourInRow(private val width: Int = 7, private val height: Int = 4, private val winLength: Int = 4) {

    enum class Chip {
        YELLOW,
        RED;

        fun opposite() = if (this == YELLOW) RED else YELLOW
    }

    data class Cell(private val x: Int, private val y: Int) {

        operator fun plus(arg: Cell): Cell {
            return Cell(x + arg.x, y + arg.y)
        }

        fun correct(field: FourInRow) = x >= 0 && x < field.width && y >= 0 && y < field.height
    }

    private val chips = HashMap<Cell, Chip>()

    var turn = Chip.YELLOW
        private set

    operator fun get(x: Int, y: Int) = get(Cell(x, y))

    operator fun get(cell: Cell) = chips[cell]

    fun makeTurn(x: Int): Cell? {
        if (x < 0 || x >= width) return null
        for (y in 0..height - 1) {
            val cell = Cell(x, y)
            if (this[cell] == null) {
                chips[cell] = turn
                turn = turn.opposite()
                return cell
            }
        }
        return null
    }

    fun hasFreeCells(): Boolean {
        for (x in 0..width - 1) {
            for (y in 0..height - 1) {
                if (this[x, y] == null) return true
            }
        }
        return false
    }

    private val directions = arrayOf(Cell(0, 1), Cell(1, 0), Cell(1, 1), Cell(1, -1))

    fun winner(): Chip? {
        for (x in 0..width - 1) {
            for (y in 0..height - 1) {
                val cell = Cell(x, y)
                val start = this[cell] ?: continue
                for (dir in directions) {
                    var length = 0
                    var current = cell
                    while (++length < winLength) {
                        current += dir
                        if (!current.correct(this)) break
                        if (this[current] != start) break
                    }
                    if (length == winLength) {
                        return start
                    }
                }
            }
        }
        return null
    }
}
