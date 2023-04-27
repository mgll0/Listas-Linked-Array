package ArrayList;

import Exceptions.BadIndexException;
import Interfaces.Iterator;

public class ArrayListIterator <T> implements Iterator<T> {
    private int currentIndex;
    private final ArrayList<T> list;

    ArrayListIterator(ArrayList<T> list){
        this.list = list;
        currentIndex = 0;
    }
    public void setIndexAt(int index){
        currentIndex = index;
    }

    public boolean hasNext(){
        return currentIndex < list.getSize();
    }
    public boolean hasPrevious(){
        return currentIndex > 0;
    }
    public T next(){
        T data = null;
        try {
            data = list.getAt(currentIndex);
        } catch (BadIndexException ignored){
            return null;
        }
        currentIndex++;
        return data;
    }
    public T previous(){
        T data = null;
        try {
            data = list.getAt(currentIndex);
        } catch (BadIndexException ignored){

        }
        currentIndex--;
        return data;
    }

}
