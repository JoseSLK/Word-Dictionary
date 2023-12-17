package model.binary_tree;

/**
 * The TreeNode class represents a node in a binary tree.
 *
 * @param <T> The type of data stored in the node.
 */
public class TreeNode <T> {
    /**
     * The information stored in the node.
     */
    private T info;
    /**
     * The left child of the node.
     */
    private TreeNode<T> left;
    /**
     * The right child of the node.
     */
    private TreeNode<T> right;

    /**
     * Constructs a TreeNode with the specified information.
     *
     * @param info The information to be stored in the node.
     */
    public TreeNode(T info) {
        this.info = info;
    }

    /**
     * Gets the information stored in the node.
     *
     * @return The information stored in the node.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Sets the information stored in the node.
     *
     * @param info The new information to be stored in the node.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Gets the left child of the node.
     *
     * @return The left child of the node.
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the left child of the node.
     *
     * @param left The new left child of the node.
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Gets the right child of the node.
     *
     * @return The right child of the node.
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Sets the right child of the node.
     *
     * @param right The new right child of the node.
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
