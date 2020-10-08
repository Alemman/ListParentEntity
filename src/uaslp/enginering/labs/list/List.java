package uaslp.enginering.labs.list;



import uaslp.enginering.labs.model.Student;

public interface List{
    enum InsertPosition {
        BEFORE,
        AFTER
    }
    void add(Student element);
    void delete(Student element);
    void delete(int index);
    int size();
    Student getAt(int index);
    void insert(Student reference, Student newStudent, InsertPosition insertPosition);
    Iterator getIterator();
}
