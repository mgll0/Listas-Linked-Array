package LinkedList;

import Exceptions.BadIndexException;
import Exceptions.CollectionsException;
import Exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void whenListIsCreated_thenItIsEmpty(){
        //Inicializacion
        LinkedList<Object> list = new LinkedList<>();

        //Ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //Validacion
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(size, 0);
    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();

        //Ejecucion
        list.addAtTail(("1"));

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAnNonEmptyList_whenAddAtTail_thenElementIsInserted() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtTail(("1"));

        //Ejecucion
        list.addAtTail("2");

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertEquals("2", list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();

        //Ejecucion
        list.addAtFront(("1"));

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAnNonEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront(("1"));

        //Ejecucion
        list.addAtFront("2");

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("2", list.getAt(0));
        Assertions.assertEquals("1", list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAList_whenAddAtFrontANullValue_thenExceptionIsThrown() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAnEmptyList_whenRemoveWrongIndex_thenDoesNothing() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(3));

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenAListWithData_whenRemoveWrongIndex_thenDoesNothing() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtTail("10");
        list.addAtFront("5");

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(3));

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAListWith1Element_whenRemove_thenElementIsRemoved() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtTail("10");
        //Ejecucion
        list.remove(0);


        //Validacion
        Assertions.assertEquals(0 ,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    //setAt
    @Test
    public void givenAnEmptyList_whenSetAt_thenDoesNothing() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.setAt(3,"123"));

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenAnEmptyList_SetAtFirstElement() throws CollectionsException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();

        //Ejecucion
        list.setAt(0, "123");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAList_SetAtLastElement() throws CollectionsException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.setAt(0, "123");
        //Ejecucion
        list.setAt(1, "123");

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }


    //deleteNode
    @Test
    public void givenAListWith3Elements_removeFirstElement() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront("3");
        list.addAtFront("2");
        list.addAtFront("1");

        //Ejecucion
        list.remove(0);


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAListWith3Elements_removeMiddleElement() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront("3");
        list.addAtFront("2");
        list.addAtFront("1");

        //Ejecucion
        list.remove(1);


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAListWith3Elements_removeLastElement() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront("3");
        list.addAtFront("2");
        list.addAtFront("1");

        //Ejecucion
        list.remove(2);


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }


    //removeAllWithValue
    @Test
    public void givenAListWith3ElementsofSameValue_removeAllWithValue() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront("1");
        list.addAtFront("1");
        list.addAtFront("1");

        //Ejecucion
        list.removeAllWithValue("1");


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    //getAt
    @Test
    public void givenAListWith3Elements_GetLastElement() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront("3");
        list.addAtFront("2");
        list.addAtFront("1");

        //Ejecucion
        String item = list.getAt(2);


        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals(item, "3");
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAListWith1Elements_GetLastElement() throws NotNullAllowedException, BadIndexException {
        //iniciacion
        LinkedList<String> list = new LinkedList<String>();
        list.addAtFront("0");

        //Ejecucion
        String item = list.getAt(0);


        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals(item, "0");
        Assertions.assertFalse(list.isEmpty());
    }




}
