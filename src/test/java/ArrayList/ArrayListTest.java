package ArrayList;

import Exceptions.BadIndexException;
import Exceptions.CollectionsException;
import Exceptions.NotNullAllowedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    //List creation
    @Test
    public void whenListIsCreated_listIsEmpty(){
        ArrayList<String> list = new ArrayList<String>();

        boolean isEmpty = list.isEmpty();

        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0,list.getSize());
    }

    //AddAtTail
    @Test
    public void EmptyList_usesAddAtTail_thenFirstElementIsInserted() throws NotNullAllowedException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();


        //Execution
        list.addAtTail("Hola");
        boolean isEmpty = list.isEmpty();


        //Validation
        Assertions.assertFalse(isEmpty);
        Assertions.assertEquals(1,list.getSize());

    }
    @Test
    public void listNeedsMoreSpaceWhenAddAtTail_usesIncreseSizeToDouble() throws NotNullAllowedException{
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.addAtTail("Hola");
        list.addAtTail("Holaa");

        //Execution
        list.addAtTail("Holaa");

        //Validation
        Assertions.assertEquals(3,list.getSize());
    }
    @Test
    public void ArrayListThowsNotNullAllowedExeption_whenAddAtTailNullData(){
        ArrayList<String> list = new ArrayList<String>();

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }



    //addAtFront
    @Test
    public void ArrayListThowsNotNullAllowedExeption_whenAddAtFrontNullData(){
        ArrayList<String> list = new ArrayList<String>();

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void EmptyList_usesAddAtFront_thenFirstElementIsInserted() throws NotNullAllowedException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();

        //Execution
        list.addAtFront("Hola");

        //Validation
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1,list.getSize());

    }
    @Test
    public void List_usesAddAtFront_() throws NotNullAllowedException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");
        list.addAtFront("Mundo");

        //Execution
        list.addAtFront("when");

        //Validation
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(3,list.getSize());

    }

    //IncreseSize
    @Test
    public void listNeedsMoreSpaceWhenAddAtFront_usesIncreseSizeToDouble() throws NotNullAllowedException{
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");
        list.addAtFront("Holaa");

        //Execution
        list.addAtFront("Holaa");

        //Validation
        Assertions.assertEquals(3,list.getSize());
    }



    //remove
    @Test
    public void ListWithOneElement_usesRemove_thenListIsEmpty() throws BadIndexException, NotNullAllowedException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");

        //Execution
        list.remove(0);

        //Validation
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.getSize());

    }
    @Test
    public void List_usesRemove_thenListhasSeveralElements() throws BadIndexException, NotNullAllowedException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");
        list.addAtFront("Holaa");
        list.addAtFront("Holaaa");

        //Execution
        list.remove(0);

        //Validation
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(2,list.getSize());

    }



    //removeAll
    @Test
    public void List_usesRemoveAll_thenListIsEmpty() throws NotNullAllowedException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.addAtFront("Hola");
        list.addAtFront("Holaa");
        list.addAtFront("Holaaa");

        //Execution
        list.removeAll();

        //Validation
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0,list.getSize());

    }



    //setAt
    @Test
    public void List_usesSetAt() throws CollectionsException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();

        //Execution
        list.setAt(0,"5");
        list.setAt(0,"3");
        list.setAt(0,"1");

        //Validation
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(3,list.getSize());

    }



    //RemoveAllWithValue
    @Test
    public void ListWithTheSameValues_usesRemovesAllWithValue_removesTheWholeList() throws CollectionsException {
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();
        list.setAt(0,"2");
        list.setAt(0,"2");
        list.setAt(0,"2");

        //Execution
        list.removeAllWithValue("2");

        //Validation
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0,list.getSize());

    }



    //Exceptions
    @Test
    public void ArrayListThowsBadIndexException_andDoesNothing(){
        ArrayList<String> list = new ArrayList<String>();

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.setAt(5, "Hello"));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }



    //IsEmpty
    @Test
    public void List_usesIsEmpty_whenEmpty(){
        //Inicialitation
        ArrayList<String> list = new ArrayList<String>();

        //Execution

        //Validation
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0,list.getSize());

    }
}
