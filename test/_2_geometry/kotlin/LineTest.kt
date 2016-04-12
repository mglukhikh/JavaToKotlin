package _2_geometry.kotlin

import org.junit.Test

import org.junit.Assert.*

class LineTest {

    @Test
    fun testGetDistance() {
        val p1 = Point(0.0, 3.0)
        val p2 = Point(4.0, 0.0)
        val line = Line.create(p1, p2)
        assertEquals(0.0, line.getDistance(p1), 1e-6)
        assertEquals(0.0, line.getDistance(p2), 1e-6)
        assertEquals(0.0, line.getDistance(Point(2.0, 1.5)), 1e-6)
    }
}