package _3_geometry.kotlin

//import _3_geometry.java.Point;

// ax + by - 1 = 0
class Line(val a: Double, val b: Double)

// ax1 + by1 = 1
// ax2 + by2 = 1
fun createLine(p1: Point, p2: Point): Line {
    val d = p1.x * p2.y - p1.y * p2.x
    val da = p2.y - p1.y
    val db = p1.x - p2.x
    return Line(da / d, db / d)
}

fun Line.distance(p: Point): Double {
    return Math.abs(a * p.x + b * p.y - 1) / Math.sqrt(a * a + b * b)
}