package _3_tree.java;

public class Leaf<Key extends Comparable<Key>, Value> extends Element<Key, Value> {
    public Leaf(Key key, Value value) {
        super(key, value);
    }
}
