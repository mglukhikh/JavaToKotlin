package _3_tree.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElementTest {

    @Test
    public void testSearch() throws Exception {
        Tree<Integer, String> tree = new Tree<>(2, "b", new Leaf<>(1, "a"), new Leaf<>(3, "c"));
        assertEquals("a", tree.binarySearch(1));
        assertEquals("b", tree.binarySearch(2));
        assertEquals("c", tree.binarySearch(3));
        Tree<String, String> complex = new Tree<>("i", "j",
                new Tree<>("k", "l", new Leaf<>("a", "b"), new Leaf<>("c", "d")),
                new Tree<>("m", "n", new Leaf<>("e", "f"), new Leaf<>("g", "h")));
        assertEquals("f", complex.search("e"));
        assertEquals("n", complex.search("m"));
        assertEquals("j", complex.search("i"));
    }
}