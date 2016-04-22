package _3_geometry.kotlin

import org.junit.Test

import org.junit.Assert.*

class LineTest {

    @Test
    fun testGetDistance() {
        val p1 = Point(0.0, 3.0)
        val p2 = Point(4.0, 0.0)
        val line = create(p1, p2)
        assertEquals(0.0, line.distance(p1), 1e-6)
        assertEquals(0.0, line.distance(p2), 1e-6)
        assertEquals(0.0, line.distance(Point(2.0, 1.5)), 1e-6)
    }
}