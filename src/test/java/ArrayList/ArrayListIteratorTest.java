package ArrayList;

import Exceptions.BadIndexException;
import Exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListIteratorTest {
    @Test
    public void IteratorHasNext_inOneElementList() throws NotNullAllowedException {
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");

        ArrayListIterator<String> it = list.getIterator();

        Assertions.assertTrue(it.hasNext());
    }

    @Test
    public void IteratorNext_throwsBadIndexHandles() throws NotNullAllowedException {
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");

        ArrayListIterator<String> it = list.getIterator();
        it.setIndexAt(5);
        String data = it.next();

        Assertions.assertEquals(null, data);
    }

    @Test
    public void IteratorPrevious_throwsBadIndexHandles() throws NotNullAllowedException {
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");

        ArrayListIterator<String> it = list.getIterator();
        it.setIndexAt(5);
        String data = it.previous();

        Assertions.assertEquals(null, data);
    }

    @Test
    public void IteratorNext_givesElement() throws NotNullAllowedException {
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");

        ArrayListIterator<String> it = list.getIterator();

        Assertions.assertEquals("Hola",it.next());
    }
}
