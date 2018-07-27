package datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datastructures.concrete.BST;

class TestBinarySearchTreeMap {
    
    private BST<Integer, String> fillTree() {
        BST<Integer, String> tree = new BST<Integer, String>();
        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(8,  "eight");
        tree.put(2, "two");
        tree.put(6, "six");
        tree.put(4, "four");
        tree.put(9, "nine");
        tree.put(1, "one");
        tree.put(7, "seven");
        return tree;
    }
    
    @Test
    void TestOrder() {
        BST<Integer, String> tree = fillTree();
        assertEquals(tree.preOrder(),
                "<5, five><3, three><2, two><1, one><4, four><8, eight><6, six><7, seven><9, nine>");
    }
    
    @Test
    void TestPutIncrementsSize() {
        BST<Integer, String> tree = new BST<>();
        for (int i = 0; i < 5; i++) {
            tree.put(i, "aa");
        }
        assertEquals(5, tree.size());
        tree.put(1, "bb");
        assertEquals(5, tree.size());
    }

    @Test
    void TestPutReplacesProperly() {
        BST<Integer, String> tree = fillTree();
        assertEquals("five", tree.put(5, "FIVE"));
        assertEquals(tree.preOrder(),
                "<5, FIVE><3, three><2, two><1, one><4, four><8, eight><6, six><7, seven><9, nine>");
    }
    
    @Test
    void TestPutIsEfficient() {
        BST<Integer, String> tree = fillTree();
        for(int i = 0; i < 5000; i++) {
            tree.put(i, "aa");
        }
        assertEquals(5000, tree.size());
    }
    
    @Test
    void TestGetWorks() {
        BST<Integer, String> tree = fillTree();
        assertEquals("one", tree.get(1));
        assertEquals("two", tree.get(2));
        assertEquals("three", tree.get(3));
        assertEquals("four", tree.get(4));
        assertEquals("five", tree.get(5));
        assertEquals("six", tree.get(6));
        assertEquals("seven", tree.get(7));
        assertEquals("seven", tree.get(7));
        assertEquals("eight", tree.get(8));
        assertEquals("nine", tree.get(9));
        assertEquals(null, tree.get(10));
    }
}
