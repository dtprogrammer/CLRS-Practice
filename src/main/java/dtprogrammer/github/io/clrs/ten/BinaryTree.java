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

package dtprogrammer.github.io.clrs.ten;

/**
 * A generic Binary Tree implementation. Note this is not a Binary Search Tree.
 *
 * @param <E> the type of data
 */
class BinaryTree<E> {

    TreeNode root = null;

    /**
     * Class which represents a node in binary tree.
     */
    class TreeNode {
        final E data;
        TreeNode left;
        TreeNode right;

        TreeNode(E data) {
            this.data = data;
        }
    }

    /**
     * Inserts the given element in the binary tree.
     *
     * @param data the element to be inserted
     */
    void insert(E data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, E data) {
        if (node == null) {
            node = new TreeNode(data);
        } else {
            if (node.left == null) {
                node.left = insert(node.left, data);
            } else if (node.right == null) {
                node.right = insert(node.right, data);
            } else {
                // neither left or right child is null so randomly select one to traverse down
                // this is very naive random
                double random = Math.random();
                if (random < 0.5) {
                    node.left = insert(node.left, data);
                } else {
                    node.right = insert(node.right, data);
                }
            }
        }
        return node;
    }
}
