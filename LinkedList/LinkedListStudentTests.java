import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/**
 * This is a basic set of unit tests for SinglyLinkedList.java. Passing these does
 * NOT guarantee any grade on this assignment. This is only a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * @author The 1332 TAs
 * @version 1.0
 */
public class LinkedListStudentTests {
    private SinglyLinkedList<String> list;

    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }


    @Test(timeout = TIMEOUT)
    public void testAddStringsFront() {
        assertEquals(0, list.size());

        list.addToFront("0a");
        list.addToFront("1a");
        list.addToFront("2a");
        list.addToFront("3a");
        list.addToFront("4a");
        list.addToFront("5a"); //5a 4a 3a 2a 1a 0a

        assertEquals(6, list.size());

        SinglyLinkedListNode<String> tail = list.getTail();
        assertNotNull(tail);
        assertNull(tail.getNext());
        assertEquals("0a", tail.getData());

        SinglyLinkedListNode<String> current = list.getHead();
        assertNotNull(current);
        assertEquals("5a", current.getData());

        list.addToFront("6a");
        assertEquals("6a", list.getHead().getData());
        assertEquals("0a", list.getTail().getData());
        assertNull(list.getTail().getNext());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("4a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("3a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("2a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("1a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("0a", current.getData());

        current = current.getNext();
        assertNull(current);
    }

    @Test(timeout = TIMEOUT)
    public void testAddStringsBack() {
        assertEquals(0, list.size());

        list.addToBack("0a");
        list.addToBack("1a");
        list.addToBack("2a");
        list.addToBack("3a");
        list.addToBack("4a");

        assertEquals(5, list.size());

        SinglyLinkedListNode<String> tail = list.getTail();
        assertNotNull(tail);
        assertNull(tail.getNext());
        assertEquals("4a", tail.getData());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveStringsFront() {
        assertEquals(0, list.size());

        list.addToBack("0a");
        list.addToBack("1a");
        list.addToBack("2a");
        list.addToBack("3a");
        list.addToBack("4a");
        list.addToBack("5a"); //0a 1a 2a 3a 4a 5a

        assertEquals(6, list.size());

        assertEquals("0a", list.removeFromFront()); //1a 2a 3a 4a 5a

        assertEquals(5, list.size());

        SinglyLinkedListNode<String> current = list.getHead();
        assertNotNull(current);
        assertEquals("1a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("2a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("3a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("4a", current.getData());

        current = current.getNext();
        assertNotNull(current);
        assertEquals("5a", current.getData());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveStringsBack() {
        assertEquals(0, list.size());

        list.addToBack("0a");
        list.addToBack("1a");
        list.addToBack("2a"); //0a 1a 2a

        assertEquals(3, list.size());

        assertEquals("2a", list.removeFromBack()); //0a 1a 2a 3a 4a

        assertEquals(2, list.size());

        assertEquals("1a", list.removeFromBack()); //0a 1a 2a 3a 4a

        assertEquals(1, list.size());

        SinglyLinkedListNode<String> tail = list.getTail();
        assertEquals("0a", tail.getData());
        assertNotNull(tail);
        assertNull(tail.getNext());

        SinglyLinkedListNode<String> head = list.getTail();
        assertEquals("0a", head.getData());
        assertNotNull(head);
        assertNull(head.getNext());

        assertEquals("0a", list.removeFromBack()); //0a 1a 2a 3a 4a

        assertEquals(0, list.size());
    }
}