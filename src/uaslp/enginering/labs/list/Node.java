package uaslp.enginering.labs.list;
import uaslp.enginering.labs.model.*;

public class Node<E> {
    private Object field;
    private Node<E> previous;
    private Node<E> Next;

    public void setElement(E element){
        field = element;
    }

    public E getElement(){
        return (E)field;
    }

    public void setPrevious(Node<E> previous){
        this.previous = previous;
    }

    public Node<E> getPrevious(){
        return previous;
    }

    public void setNext(Node<E> Next){
        this.Next = Next;
    }

    public Node<E> getNext(){
        return Next;
    }
}