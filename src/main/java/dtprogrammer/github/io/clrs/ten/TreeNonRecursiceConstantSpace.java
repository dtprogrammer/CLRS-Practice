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
 * 10.4-5 Write an O.n/-time nonrecursive procedure that, given an n-node binary tree, prints out the key of each
 * node.
 * Use no more than constant extra space outside of the tree itself and do not modify the tree, even temporarily,
 * during the procedure.
 * <p>
 * A non recursive constant space traversal is only possible if we the nodes have pointer to its parent which can be
 * used during traversal.
 */
public class TreeNonRecursiceConstantSpace {

    static void print(BinaryTree.TreeNode node) {
        // the parent to root node is null
        BinaryTree.TreeNode prev = null;

        while (node != null) {
            if (prev == node.parent) {
                System.out.println(node.data);
                prev = node;
                node = node.left != null ? node.left : node.right != null ? node.right : node.parent;
            } else if (node.left == prev && node.right != null) {
                prev = node;
                node = node.right;
            } else {
                prev = node;
                node = node.parent;
            }
        }
    }
}
