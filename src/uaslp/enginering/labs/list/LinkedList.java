package uaslp.enginering.labs.list;

import uaslp.enginering.labs.model.Student;

public class LinkedList<E> {
    private Node<E> front;
    private Node<E> tail;
    private int count;

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public class Iterator {
        private int index;
        private Node<E> list;

        public Iterator(){
            list = front;
        }
        public boolean hasNext() {
            return index < count;
        }

        public E next() {
            E nextStudent;

            if(list == null) {
                nextStudent = null;
            }else {
                nextStudent = list.getElement();

                if(list.getNext() != null)
                    list = list.getNext();
                else
                    list = null;
                index++;
            }
            return (E)nextStudent;
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>();
        newNode.setElement(element);
        if(count == 0){
            front = tail = newNode;
        }else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        count++;
    }

    public void delete(E element) {
        Node<E> iteratorNode = front;

        while (!(iteratorNode.getElement().equals(element)) && iteratorNode != null){
            iteratorNode = iteratorNode.getNext();
        }
        if(iteratorNode == null){
            return;
        }else {
            if(front == iteratorNode){
                front = iteratorNode.getNext();
                iteratorNode.getNext().setPrevious(null);
                iteratorNode.setNext(null);
            }else if(tail == iteratorNode){
                tail = iteratorNode.getPrevious();
                iteratorNode.getPrevious().setNext(null);
                iteratorNode.setPrevious(null);
            }else {
                iteratorNode.getPrevious().setNext(iteratorNode.getNext());
                iteratorNode.getNext().setPrevious(iteratorNode.getPrevious());
                iteratorNode.setPrevious(null);
                iteratorNode.setNext(null);
            }
        }
    }

    public void delete(int index) {
        if(count == 0 || index > count || index < 0){
            return;
        }else if(tail == front){
            front = tail = null;
        }else {
            iteratorDelete(index);
        }
        count--;
    }

    private void iteratorDelete(int index){
        Node<E> iteratorNode = front;
        Node<E> previousNode;
        Node<E> nextNode;
        int countIterator = 0;

        if(index == 0){
            front = front.getNext();
            front.setPrevious(null);
        }else {
            while (countIterator < index) {
                iteratorNode = iteratorNode.getNext();
                countIterator++;
            }

            previousNode = iteratorNode.getPrevious();
            previousNode.setNext(iteratorNode.getNext());
            if (iteratorNode.getNext() != null) {
                nextNode = iteratorNode.getNext();
                nextNode.setPrevious(iteratorNode.getPrevious());
            }

            //es necesrio para ser recolectaso por garbageCollector ?
            iteratorNode.setPrevious(null);
            iteratorNode.setNext(null);
        }
    }
    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return count;
    }

    public E getAt(int index) {
        Node<E> iteratorNode = front;
        int countIterator = 0;

        while (countIterator < index && iteratorNode.getNext() != null){
            iteratorNode = iteratorNode.getNext();
            countIterator++;
        }

        return (E)iteratorNode.getElement();
    }

    public void insert(E reference, E newStudent, InsertPosition insertPosition) {
        Node<E> iteratorNode = front;
        Node<E> newNode = new Node<>();
        newNode.setElement(newStudent);

        while ((iteratorNode.getElement().equals(reference)) != true && iteratorNode != null){
            iteratorNode = iteratorNode.getNext();
        }

        if(iteratorNode == null){
            return;
        }else {
            reAssign(iteratorNode,newNode,insertPosition);
        }
        count++;
    }

    private void reAssign(Node<E> iteratorNode,Node<E> newNode,InsertPosition insertPosition){
        if(insertPosition.equals(InsertPosition.BEFORE)){
            if(iteratorNode.getPrevious() != null) {
                newNode.setPrevious(iteratorNode.getPrevious());
                iteratorNode.getPrevious().setNext(newNode);
                newNode.setNext(iteratorNode);
                iteratorNode.setPrevious(newNode);
            }else{
                newNode.setPrevious(null);
                iteratorNode.setPrevious(newNode);
                newNode.setNext(iteratorNode);
                front = newNode;
            }
            return;
        }

        if(insertPosition.equals(InsertPosition.AFTER)){
            if(iteratorNode.getNext() != null) {
                newNode.setPrevious(iteratorNode);
                newNode.setNext(iteratorNode.getNext());
                iteratorNode.getNext().setPrevious(newNode);
                iteratorNode.setNext(newNode);
            }else {
                newNode.setNext(null);
                iteratorNode.setNext(newNode);
                newNode.setPrevious(iteratorNode);
                tail = newNode;
            }
            //return;
        }
    }
}

