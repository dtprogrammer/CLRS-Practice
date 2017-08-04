/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017. Duct Tape Programmer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package dtprogrammer.github.io.clrs.twelve;

/**
 * Implementation of binary search tree.
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root = null;

    public class Node {
        E data;
        Node left;
        Node right;
        Node parent;

        Node(E data) {
            this(data, null);
        }

        public Node(E data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void insert(E data) {
        Node parent = null; // initialize the parent pointer to null since parent of root is null
        Node cur = root;

        // move to the right insert location
        while (cur != null) {
            parent = cur;
            cur = data.compareTo(cur.data) < 0 ? cur.left : cur.right;
        }

        // empty tree so add as root
        if (parent == null) {
            root = new Node(data, null);
            return;
        }

        // insert as left or right node depending on the data
        if (data.compareTo(parent.data) < 0) {
            parent.left = new Node(data, parent);
        } else {
            parent.right = new Node(data, parent);
        }
    }

    /**
     * Searches the given data in the bst
     *
     * @param data the data to be searched
     * @return the {@link Node} containing the data if found in the tree else null
     */
    public Node search(E data) {
        return search(data, root);
    }

    private Node search(E data, Node node) {
        if (node == null || node.data.compareTo(data) == 0) {
            return node;
        }

        return data.compareTo(node.data) < 0 ? search(data, node.left) : search(data, node.right);
    }

    /**
     * @return the minimum in the bst. If the tree is empty then return null
     */
    public Node min() {
        return min(root);
    }

    public Node min(Node cur) {
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    /**
     * @return the maximum in the bst. If the tree is empty then return null
     */
    public Node max() {
        return max(root);
    }

    private Node max(Node cur) {
        while (cur != null && cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    /**
     * Finds the successor for the given data
     *
     * @param data the data whose successor needs to found
     * @return {@link Node} which is the successor of the given data or null if no such successor exists
     */
    public Node successor(E data) {
        Node node = search(data, root);

        // if the element was not found in the tree
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return min(node.right);
        }

        Node parent = node.parent;

        while (parent != null && parent.right == node) {
            node = parent;
            parent = node.parent;
        }

        return parent;
    }

    /**
     * Finds the predecessor for the given data
     *
     * @param data the data whose predecessor needs to found
     * @return {@link Node} which is the predecessor of the given data or null if no such predecessor exists
     */
    public Node predecessor(E data) {
        Node node = search(data);

        // if the element was not found in the tree
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return max(node.left);
        }

        Node parent = node.parent;
        while (parent != null && parent.left == node) {
            node = parent;
            parent = node.parent;
        }

        return parent;
    }

    private void transplant(Node delNode, Node replacement) {
        if (delNode.parent == null) {
            // root node
            root = replacement;
        } else if (delNode.parent.left == delNode) {
            delNode.parent.left = replacement;
        } else {
            delNode.parent.right = replacement;
        }
        // if replacement is not null then set its parent
        if (replacement != null) {
            replacement.parent = delNode.parent;
        }
    }

    public void delete(E data) {
        Node node = search(data);

        // data to be deleted not found
        if (node == null) {
            return;
        }

        // if either of the child is null
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            // neither of the children are null
            Node min = min(node.right);
            if (min.parent != node) {
                transplant(min, min.right);
                min.right = node.right;
                min.right.parent = min;
            }
            transplant(node, min);
            min.left = node.left;
            min.left.parent = min;
        }
    }

    /**
     * Prints the bst in order.
     */
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.data);
            printInOrder(node.right);
        }
    }
}