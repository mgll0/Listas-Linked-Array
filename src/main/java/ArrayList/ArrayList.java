package ArrayList;

import Exceptions.BadIndexException;
import Exceptions.CollectionsException;
import Exceptions.NotNullAllowedException;
import Interfaces.List;

public class ArrayList <T> implements List<T> {    //Es una lista en un arreglo
    private static final int INITIAL_SIZE = 2;
    public T []array;      //arreglo de strings
    private int size;   //cuantos datos se le han insertado al arreglo

    @SuppressWarnings("unchecked")
    public ArrayList(){
        size = 0;
        array = (T[])( new Object [INITIAL_SIZE]);
    }

    public void addAtTail(T data) throws NotNullAllowedException{
        validateNotNullValue(data);

        if (size == array.length){
            increseSize();
        }

        array[size] = data;
        size++;
    }

    public void addAtFront(T data) throws NotNullAllowedException{
        validateNotNullValue(data);

        if (size == array.length){
            increseSize();
        }
        int i = size;
        ArrayListIterator<T> it = getIterator();
        it.setIndexAt(size);
        while (it.hasPrevious()){
            array[i] = it.previous();
            i--;
        }
        size++;
        array[i] = data;
    }

    public void remove(int index) throws BadIndexException{
        validateInvalidIndex(index);

        for (int i = index; i < size; i++){
            if (i < size-1){
                array[i] = array[i+1];
            }
        }
        size--;
    }

    @SuppressWarnings("unchecked")
    public void removeAll(){
        array = (T[])(new Object[INITIAL_SIZE]);
        size = 0;
    }

    public void setAt(int index, T data) throws CollectionsException {
        validateInvalidIndex(index);
        validateNotNullValue(data);


        if (size == array.length){
            increseSize();
        }
        if (size == 0){
            array[index] = data;
        } else {
            int i = size;
            for (; i > index; i--){
                array[i] = array[i-1];
            }
            array[i] = data;
        }

        size++;
    }

    public T getAt(int index)  throws BadIndexException{
        if (index < 0 || index > size){
            validateInvalidIndex(index);
        }

        return array[index];
    }
    public void removeAllWithValue(T data) throws CollectionsException {
        validateNotNullValue(data);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                validateInvalidIndex(i);
                remove(i);
                i--;
            }
        }
    }
    public int getSize(){
        return size;
    }
    private void increseSize(){
        Object []newArray = (new Object[array.length * 2]);
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = (T[]) newArray;
    }
    public boolean isEmpty(){
        return size <= 0;
    }

    public ArrayListIterator<T> getIterator() {
        return new ArrayListIterator<T>(this);
    }
    private void validateInvalidIndex (int index) throws BadIndexException {
        if (index < 0 || index > size){        //No esta dentro de los limtites
            throw new BadIndexException();
        }
    }
    private void validateNotNullValue (T data) throws NotNullAllowedException {
        if (data == null){
            throw new NotNullAllowedException();
        }
    }
}