package _6_game.java;

import org.junit.Test;

import static _6_game.java.FourInRow.Chip.YELLOW;
import static org.junit.Assert.*;

public class FourInRowTest {

    @Test
    public void testWinner() {
        FourInRow field = new FourInRow();
        assertNotNull(field.makeTurn(3));
        assertNotNull(field.makeTurn(4));
        assertNotNull(field.makeTurn(2));
        assertNotNull(field.makeTurn(5));
        assertNotNull(field.makeTurn(1));
        assertNotNull(field.makeTurn(6));
        assertNotNull(field.makeTurn(0));
        assertEquals(YELLOW, field.get(0, 0));
        assertEquals(YELLOW, field.get(1, 0));
        assertEquals(YELLOW, field.get(2, 0));
        assertEquals(YELLOW, field.get(3, 0));
        assertEquals(YELLOW, field.winner());
        assertTrue(field.hasFreeCells());
    }
}