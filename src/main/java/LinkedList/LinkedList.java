package LinkedList;

import Exceptions.BadIndexException;
import Exceptions.CollectionsException;
import Exceptions.NotNullAllowedException;
import Interfaces.Iterator;
import Interfaces.List;

public class LinkedList <T> implements List<T> {       //Lista con nodos
    private Node<T> head;
    private Node<T> tail;
    private int size;

    //Encapsulacion -> Capacidad que tienen las clases para hacer visible u ocultar los atributos
    //y los metodos para dar niveles de visibilidad

    public void addAtTail(T newData) throws NotNullAllowedException {
       validateNotNullValue(newData);
        if (size == 0){
            addAtFront(newData);
            return;
        }

        Node<T> node = new Node<T>();
        node.data = newData;
        node.previous = tail;
        tail.next = node;
        tail = node;

        size++;
        System.out.println("Se añadio un nodo al final");
    }
    public void addAtFront(T newData) throws NotNullAllowedException{
        validateNotNullValue(newData);

        Node<T> node = new Node<T>();
        node.data = newData;

        if (head == null){
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
        }
        head = node;
        size++;
        System.out.println("Se añadio un nodo al inicio");
    }

    public void remove(int index) throws BadIndexException{
        validateInvalidIndex(index);

        LinkedListIterator<T> it = (LinkedListIterator<T>) getIterator();

        while (it.hasNext() && it.getCurrentIndex() != index){
            it.next();
        }
        Node<T> nodeToErase = it.getCurrentNode();
        deleteNode(nodeToErase);
    }

    public void removeAll(){
        head = tail = null;
        size = 0;
        System.out.println("La lista fue eliminada");
    }

    public void setAt(int index, T data) throws CollectionsException {
        validateNotNullValue(data);
        validateInvalidIndex(index);

        if (index == 0){                        //Eliminar el primero
            addAtFront(data);
        } else
        if (index == size){                   //Eliminar el ultimo
            addAtTail(data);
        }

        LinkedListIterator<T> it = (LinkedListIterator<T>) getIterator();
        while (it.hasNext() && it.getCurrentIndex() != index){
            it.next();
        }
        Node<T> itNode = it.getCurrentNode();

        Node<T> node = new Node<T>();
        node.data = data;

        node.next = itNode;
        node.previous = itNode.previous;
        itNode.previous = node;

    }
    private void deleteNode(Node<T> nodeToErase){
        if (nodeToErase.previous == null && nodeToErase.next == null){
            removeAll();
        } else
        if (nodeToErase.next == null){
            tail = nodeToErase.previous;
        } else
        if (nodeToErase.previous == null){
            head = nodeToErase.next;
            head.previous = null;
        } else {

            nodeToErase.next.previous = nodeToErase.previous;
            nodeToErase.previous.next = nodeToErase.next;
        }
        if (size > 0){
            size--;
        }
    }
    public T getAt(int index) throws BadIndexException{
        validateInvalidIndex(index);

        LinkedListIterator<T> it = (LinkedListIterator<T>) getIterator();

        while (it.hasNext() && it.getCurrentIndex() != index){
            it.next();
        }
        return it.getCurrentNode().data;
    }
    public void removeAllWithValue(T data) throws NotNullAllowedException{
        validateNotNullValue(data);
        LinkedListIterator<T> it = (LinkedListIterator<T>) getIterator();
        while (it.hasNext()){
            if (it.getCurrentNode().data == data){
                deleteNode(it.getCurrentNode());

            }
            it.next();
        }

    }

    public int getSize(){
        return size;
    }

    public Iterator<T> getIterator(){
        return new LinkedListIterator<T>(head);
    }

    public boolean isEmpty(){
        return size <= 0;
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