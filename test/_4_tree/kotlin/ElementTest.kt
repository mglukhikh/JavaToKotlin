package _4_tree.kotlin

import _4_tree.kotlin.Element.Leaf
import _4_tree.kotlin.Element.Tree
import org.junit.Test

import org.junit.Assert.*

class ElementTest {

    @Test
    fun testSearch() {
        val tree = Tree(2, "b", Leaf(1, "a"), Leaf(3, "c"))
        assertEquals("a", tree.binarySearch(1))
        assertEquals("b", tree.binarySearch(2))
        assertEquals("c", tree.binarySearch(3))
        val complex = Tree("i", "j",
                           Tree("k", "l", Leaf("a", "b"), Leaf("c", "d")),
                           Tree("m", "n", Leaf("e", "f"), Leaf("g", "h")))
        assertEquals("f", complex.search("e"))
        assertEquals("n", complex.search("m"))
        assertEquals("j", complex.search("i"))
    }
}