package _4_tree.java;

public class Tree<Key extends Comparable<Key>, Value> extends Element<Key, Value> {

    private final Element<Key, Value> left;

    private final Element<Key, Value> right;

    Tree(Key key, Value value, Element<Key, Value> left, Element<Key, Value> right) {
        super(key, value);
        this.left = left;
        this.right = right;
    }

    public Element<Key, Value> getLeft() {
        return left;
    }

    public Element<Key, Value> getRight() {
        return right;
    }
}
