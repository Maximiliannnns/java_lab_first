import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntContTest 
{

    private IntCont cont;

    @BeforeEach
    void setUp()
    {
        cont = new IntCont();
    }

    @Test
    void contAreEmpty() 
    {
        assertTrue(cont.isEmpty());
        assertEquals(0, cont.size());
    }

    @Test
    void addOneElem() 
    {
        cont.add(100);

        assertFalse(cont.isEmpty());
        assertEquals(1, cont.size());
        assertEquals(100, cont.get(0));
    }

    @Test
    void addManyElems() 
    {
        cont.add(7);
        cont.add(14);
        cont.add(21);
        cont.add(28);

        assertEquals(4, cont.size());
        assertEquals(7,  cont.get(0));
        assertEquals(14, cont.get(1));
        assertEquals(21, cont.get(2));
        assertEquals(28, cont.get(3));
    }

    @Test
    void toStrTest() 
    {
        assertEquals("[]", cont.toString());

        cont.add(5);
        assertEquals("[5]", cont.toString());

        cont.add(10);
        cont.add(-3);
        assertEquals("[5, 10, -3]", cont.toString());
    }

    @Test
    void removeFirst() 
    {
        cont.add(100);
        cont.add(200);
        cont.add(300);

        int removed = cont.remove(0);

        assertEquals(100, removed);
        assertEquals(2, cont.size());
        assertEquals(200, cont.get(0));
        assertEquals(300, cont.get(1));
        assertEquals("[200, 300]", cont.toString());
    }

    @Test
    void removeMiddle() 
    {
        cont.add(1);
        cont.add(2);
        cont.add(3);
        cont.add(4);
        cont.add(5);

        int removed = cont.remove(2);

        assertEquals(3, removed);
        assertEquals(4, cont.size());
        assertEquals(1, cont.get(0));
        assertEquals(2, cont.get(1));
        assertEquals(4, cont.get(2));
        assertEquals(5, cont.get(3));
        assertEquals("[1, 2, 4, 5]", cont.toString());
    }

    @Test
    void removeLast()
    {
        cont.add(77);
        cont.add(88);

        int removed = cont.remove(1);

        assertEquals(88, removed);
        assertEquals(1, cont.size());
        assertEquals(77, cont.get(0));
        assertEquals("[77]", cont.toString());
    }

    @Test
    void removeOnlyElem() 
    {
        cont.add(999);

        int removed = cont.remove(0);

        assertEquals(999, removed);
        assertTrue(cont.isEmpty());
        assertEquals(0, cont.size());
        assertEquals("[]", cont.toString());
    }


    @Test
    void getInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> cont.get(-1));
    }

    @Test
    void getIndexEqualToSize() 
    {
        cont.add(10);
        cont.add(20);

        assertThrows(IndexOutOfBoundsException.class, () -> cont.get(2));
    }

    @Test
    void getIndexLargerThanSize() 
    {
        cont.add(5);

        IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> cont.get(10));

        String message = ex.getMessage();
        assertTrue(message.contains("Index: 10"));
        assertTrue(message.contains("Size: 1"));
    }

    @Test
    void removeInvalidIndex()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> cont.remove(-1));
    }

    @Test
    void removeIndexEqualToSize() 
    {
        cont.add(100);

        assertThrows(IndexOutOfBoundsException.class, () -> cont.remove(1));
    }

    @Test
    void operationsOnEmptyContGet() 
    {
        assertThrows(IndexOutOfBoundsException.class, () -> cont.get(0));
    }

    @Test
    void operationsOnEmptyContRemove() 
    {
        assertThrows(IndexOutOfBoundsException.class, () -> cont.remove(0));
    }
}