package _4_tree.java;

public abstract class Element<Key extends Comparable<Key>, Value> {
    private final Key key;

    private final Value value;

    public Element(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public Value search(Key key) {
        if (key != null ? key.equals(getKey()) : getKey() == null) return getValue();
        if (this instanceof Leaf) {
            return null;
        }
        if (this instanceof Tree) {
            Tree<Key, Value> tree = (Tree<Key, Value>) this;
            if (tree.getLeft() != null) {
                Value fromLeft = tree.getLeft().search(key);
                if (fromLeft != null) return fromLeft;
            }
            if (tree.getRight() != null) {
                return tree.getRight().search(key);
            }
        }
        return null;
    }

    public Value binarySearch(Key key) {
        if (key != null ? key.equals(getKey()) : getKey() == null) return getValue();
        if (this instanceof Leaf) {
            return null;
        }
        if (this instanceof Tree) {
            Tree<Key, Value> tree = (Tree<Key, Value>) this;
            if (key != null && key.compareTo(getKey()) < 0 && tree.getLeft() != null) {
                return tree.getLeft().search(key);
            }
            else if (key != null && key.compareTo(getKey()) > 0 && tree.getRight() != null) {
                return tree.getRight().search(key);
            }
        }
        return null;
    }
}
