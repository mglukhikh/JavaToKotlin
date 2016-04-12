package _2_geometry.kotlin

// ax + by - 1 = 0
class Line(private val a: Double, private val b: Double) {

    fun getDistance(p: Point): Double {
        // Property access
        return Math.abs(a * p.x + b * p.y - 1) / Math.sqrt(a * a + b * b)
    }

    // Object bound to a class
    companion object {
        // ax1 + by1 = 1
        // ax2 + by2 = 1
        fun create(p1: Point, p2: Point): Line {
            val d = p1.x * p2.y - p1.y * p2.x
            val da = p2.y - p1.y
            val db = p1.x - p2.x
            return Line(da / d, db / d)
        }
    }
}
