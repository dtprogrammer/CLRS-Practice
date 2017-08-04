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

import dtprogrammer.github.io.clrs.commons.ConsoleTestBase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest extends ConsoleTestBase {
    static BinarySearchTree<Integer> bst;
    static BinarySearchTree<Integer> emptyBST;

    @BeforeClass
    public static void createTree() {
        bst = new BinarySearchTree<>();
        emptyBST = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(2);
        bst.insert(6);
        bst.insert(99);
        bst.insert(1);
        bst.insert(54);
    }

    @Test
    public void testInOrderTraversal() {
        bst.printInOrder();
        String actualOutput = getOutContent().toString();
        Assert.assertEquals(6, actualOutput.split("\n").length);

        Assert.assertEquals("1\n2\n6\n12\n54\n99\n", actualOutput);

        cleanUpStreams();
        emptyBST.printInOrder();
        actualOutput = getOutContent().toString();
        Assert.assertEquals("", actualOutput);
    }

    @Test
    public void testSearch() {
        // existing data
        BinarySearchTree<Integer>.Node node = bst.search(6);
        Assert.assertNotNull(node);

        // non-existing data
        node = bst.search(7);
        Assert.assertNull(node);

        // search on empty tree
        node = emptyBST.search(6);
        Assert.assertNull(node);
    }

    @Test
    public void testMin() {
        BinarySearchTree<Integer>.Node minNode = bst.min();
        Assert.assertEquals(1, (int) minNode.data);

        minNode = emptyBST.min();
        Assert.assertNull(minNode);
    }

    @Test
    public void testMax() {
        BinarySearchTree<Integer>.Node maxNode = bst.max();
        Assert.assertEquals(99, (int) maxNode.data);

        maxNode = emptyBST.max();
        Assert.assertNull(maxNode);
    }

    @Test
    public void testSuccessor() {
        BinarySearchTree<Integer>.Node successor = bst.successor(6);
        Assert.assertEquals(12, (int) successor.data);

        successor = bst.successor(99);
        Assert.assertNull(successor);

        successor = bst.successor(98);
        Assert.assertNull(successor);

        successor = emptyBST.successor(6);
        Assert.assertNull(successor);
    }

    @Test
    public void testPredecessor() {
        BinarySearchTree<Integer>.Node predecessor = bst.predecessor(12);
        Assert.assertEquals(6, (int) predecessor.data);

        predecessor = bst.predecessor(1);
        Assert.assertNull(predecessor);

        predecessor = bst.predecessor(98);
        Assert.assertNull(predecessor);

        predecessor = emptyBST.predecessor(6);
        Assert.assertNull(predecessor);
    }

//    @Test
//    public void testDelete() {
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        bst.insert(12);
//        bst.insert(2);
//        bst.insert(6);
//        bst.insert(99);
//        bst.insert(1);
//        bst.insert(54);
//        bst.delete(12);
//
//        bst.delete(12);
//
//        bst.printInOrder();
//        String actualOutput = getOutContent().toString();
//        Assert.assertEquals(5, actualOutput.split("\n").length);
//
//        Assert.assertEquals("1\n2\n6\n54\n99\n", actualOutput);
//
//        bst.delete(14);
//        cleanUpStreams();
//        bst.printInOrder();
//        actualOutput = getOutContent().toString();
//        Assert.assertEquals(5, actualOutput.split("\n").length);
//        Assert.assertEquals("1\n2\n6\n54\n99\n", actualOutput);
//
//        // put it back so that other tests don't get affected
//        bst.insert(12);
//    }


}
