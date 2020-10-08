package uaslp.enginering.labs.list;
import uaslp.enginering.labs.model.Student;

public interface Iterator {
    boolean hasNext();
    Student next();
}