package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Test;
import uaslp.enginering.labs.model.Student;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    @Test
    public void givenNewList_whenSize_thenZeroIsReturned() {
        // Given:
        List arrayList = new ArrayList<>();

        // When:
        int size = arrayList.size();

        // Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewList_whenAdd_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student student = new Student("Ivan");

        // When:
        arrayList.add(student);

        // Then:
        assertEquals(1, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
    }

    @Test
    public void givenAListWithNoMoreCapacity_whenAdd_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>(2);

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));


        // When:
        arrayList.add(new Student("Francisco"));

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteFirst_thenElementIsDeleted() {
        // Given:
        List arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(0);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Israel");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteLast_thenElementIsDeleted() {
        // Given:
        List arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(2);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteMiddle_thenElementIsDeleted() {
        // Given:
        List arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(1);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteNegative_thenDoesNothing() {
        // Given:
        List arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(-1);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteOutOfSize_thenDoesNothing() {
        // Given:
        List arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(4);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningBefore_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Lupita");
        assertEquals(arrayList.getAt(1).getName(), "Ivan");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Lupita");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleBefore_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Lupita");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningAfter_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Lupita");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndAfter_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
        assertEquals(arrayList.getAt(3).getName(), "Lupita");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleAfter_thenElementIsInserted() {
        // Given:
        List arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Lupita");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenEmptyList_whenGetIterator_thenIteratorIsEmpty(){
        // Given:
        List arrayList = new ArrayList<>();

        // When:
        uaslp.enginering.labs.list.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void givenListWithOneElement_whenGetIterator_thenIteratorHasOneNext(){
        // Given:
        List arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));

        // When:
        uaslp.enginering.labs.list.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertEquals("Ivan", student.getName());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }
}
