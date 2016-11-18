package io.bna.ccibook.common;

/**
 * Created by brand on 11/14/2016.
 */
public class BinaryNode<T> {
    public BinaryNode<T> right = null, left = null, parent = null;
    public T data;
    public Integer depth;

    public BinaryNode(T data) {
        this.data = data;
    }

    public void addLeft(T data) throws Exception {
        if(left != null)
            throw new Exception("A node already exists to the left");
        left = new BinaryNode<T>(data);
        left.parent = this;
    }

    public void addRight(T data) throws Exception {
        if(right != null)
            throw new Exception("A node already exists to the right");
        right = new BinaryNode<T>(data);
        right.parent = this;
    }

    private void clearParent(BinaryNode<T> node) {
        if (node.parent != null) {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else if (node.parent.right == node) {
                node.parent.right = null;
            }
        }
    }

    public void addLeft(BinaryNode<T> node) throws Exception {
        if(left != null)
            throw new Exception("A node already exists to the left");
        clearParent(node);
        left = node;
        left.parent = this;
    }

    public void addRight(BinaryNode<T> node) throws Exception {
        if(right != null)
            throw new Exception("A node already exists to the right");
        clearParent(node);
        right = node;
        right.parent = this;
    }

    public void removeLeft() { left = null; }
    public void removeRight() { right = null; }
}
