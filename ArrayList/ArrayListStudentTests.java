 import org.junit.Before;
 import org.junit.Test;

 import static org.junit.Assert.assertArrayEquals;
 import static org.junit.Assert.assertEquals;
 import static org.junit.Assert.assertSame;

 /**
  * This is a basic set of unit tests for ArrayList. Passing these does
  * NOT guarantee any grade on this assignment. This is only a sanity check to
  * help you get started on the homework and writing JUnits in general.
  *
  * @author CS 1332 TAs
  * @version 1.0
  */
 public class ArrayListStudentTests {

     private ArrayList<String> list;
     private ArrayList<String> list2;

     public static final int TIMEOUT = 200;

     @Before
     public void setUp() {
         list = new ArrayList<String>();
     }

     @Test(timeout = TIMEOUT)
     public void testAddStringsFront() {
         assertEquals(0, list.size());

         list.addToFront("0a"); // 0a
         list.addToFront("1a"); // 1a 0a
         list.addToFront("2a"); // 2a 1a 0a
         list.addToFront("3a"); // 3a 2a 1a 0a
         list.addToFront("4a"); // 4a 3a 2a 1a 0a

         assertEquals(5, list.size());

         Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
         expected[0] = "4a";
         expected[1] = "3a";
         expected[2] = "2a";
         expected[3] = "1a";
         expected[4] = "0a";
         assertArrayEquals(expected, list.getBackingArray());
     }

     @Test(timeout = TIMEOUT)
     public void testAddStringsBack() {
         assertEquals(0, list.size());

         list.addToBack("0a"); // 0a
         list.addToBack("1a"); // 0a 1a
         list.addToBack("2a"); // 0a 1a 2a
         list.addToBack("3a"); // 0a 1a 2a 3a

         assertEquals(4, list.size());

         Object[] expected = new Object[ArrayList.INITIAL_CAPACITY];
         expected[0] = "0a";
         expected[1] = "1a";
         expected[2] = "2a";
         expected[3] = "3a";
         assertArrayEquals(expected, list.getBackingArray());
     }
 }