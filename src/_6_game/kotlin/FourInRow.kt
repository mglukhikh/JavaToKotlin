package _6_game.kotlin

import java.util.*

class FourInRow(private val width: Int = 7, private val height: Int = 6, private val winLength: Int = 4) {

    enum class Chip {
        YELLOW,
        RED;

        fun opposite() = if (this == YELLOW) RED else YELLOW
    }

    data class Cell(internal val x: Int, internal val y: Int) {

        operator fun plus(arg: Cell) = Cell(x + arg.x, y + arg.y)
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

    private fun allCells() = generateSequence(Cell(0, 0)) {
        if (it.x < width - 1) Cell(it.x + 1, it.y)
        else if (it.y < height - 1) Cell(0, it.y + 1)
        else null
    }

    fun hasFreeCells() = allCells().any { this[it] == null }

    private val directions = arrayOf(Cell(0, 1), Cell(1, 0), Cell(1, 1), Cell(1, -1))

    private fun correct(cell: Cell) = cell.x >= 0 && cell.x < width && cell.y >= 0 && cell.y < height

    private fun directionSequence(start: Cell, dir: Cell) = generateSequence(start) {
        (start + dir).let {
            if (correct(it)) it
            else null
        }
    }

    fun winner(): Chip? {
        allCells().forEach {
            cell -> val chip = this[cell] ?: return@forEach
            for (dir in directions) {
                directionSequence(cell, dir).forEachIndexed { i, cell ->
                    if (i == winLength) return chip
                    if (this[cell] != chip) return@forEachIndexed
                }
            }
        }
        return null
    }
}
