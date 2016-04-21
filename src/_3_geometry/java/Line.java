package _3_geometry.java;

//import _3_geometry.kotlin.Point;

// ax + by - 1 = 0
public class Line {
    private final double a;

    private final double b;

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // ax1 + by1 = 1
    // ax2 + by2 = 1
    static public Line create(Point p1, Point p2) {
        double d = p1.getX() * p2.getY() - p1.getY() * p2.getX();
        double da = p2.getY() - p1.getY();
        double db = p1.getX() - p2.getX();
        return new Line(da / d, db / d);
    }

    public double getDistance(Point p) {
        return Math.abs(a * p.getX() + b * p.getY() - 1) / Math.sqrt(a * a + b * b);
    }
}
