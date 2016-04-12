package _5_game.kotlin

import _5_game.kotlin.FourInRow.Chip.YELLOW
import org.junit.Test

import org.junit.Assert.*

class FourInRowTest {

    @Test
    fun testWinner() {
        val field = FourInRow()
        assertNotNull(field.makeTurn(3))
        assertNotNull(field.makeTurn(4))
        assertNotNull(field.makeTurn(2))
        assertNotNull(field.makeTurn(5))
        assertNotNull(field.makeTurn(1))
        assertNotNull(field.makeTurn(6))
        assertNotNull(field.makeTurn(0))
        assertEquals(YELLOW, field[0, 0])
        assertEquals(YELLOW, field[1, 0])
        assertEquals(YELLOW, field[2, 0])
        assertEquals(YELLOW, field[3, 0])
        assertEquals(YELLOW, field.winner())
        assertTrue(field.hasFreeCells())
    }
}