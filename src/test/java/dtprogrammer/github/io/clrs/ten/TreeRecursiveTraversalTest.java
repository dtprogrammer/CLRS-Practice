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

import dtprogrammer.github.io.clrs.commons.ConsoleTestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link TreeRecursiveTraversal}.
 */
public class TreeRecursiveTraversalTest extends ConsoleTestBase {

    @Test
    public void testValidTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(2);
        tree.insert(4);
        tree.insert(0);
        tree.insert(11);

        TreeRecursiveTraversal.print(tree.root);
        String actualOutput = getOutContent().toString();
        Assert.assertEquals(7, actualOutput.split("\n").length);
        Assert.assertTrue(actualOutput.contains("5"));
    }

    @Test
    public void testEmptyTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        TreeRecursiveTraversal.print(tree.root);
        String actualOutput = getOutContent().toString();
        Assert.assertTrue("".equals(actualOutput));
    }
}
