package uaslp.enginering.labs.list;
import uaslp.enginering.labs.model.*;

public class Node {
    private Object field;
    private Node previous;
    private Node Next;

    public void setElement(Student element){
        field = element;
    }

    public Student getElement(){
        return (Student)field;
    }

    public void setPrevious(Node previous){
        this.previous = previous;
    }

    public Node getPrevious(){
        return previous;
    }

    public void setNext(Node Next){
        this.Next = Next;
    }

    public Node getNext(){
        return Next;
    }
}