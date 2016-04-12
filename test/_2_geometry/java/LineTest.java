package _2_geometry.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testGetDistance() throws Exception {
        Point p1 = new Point(0.0, 3.0);
        Point p2 = new Point(4.0, 0.0);
        Line line = Line.create(p1, p2);
        assertEquals(0.0, line.getDistance(p1), 1e-6);
        assertEquals(0.0, line.getDistance(p2), 1e-6);
        assertEquals(0.0, line.getDistance(new Point(2.0, 1.5)), 1e-6);
    }
}