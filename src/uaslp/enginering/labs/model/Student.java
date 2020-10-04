package uaslp.enginering.labs.model;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public boolean equals(Student obj) {
=======
    public boolean equals(Object obj) {
>>>>>>> 3363f1ee76210d7c4eac8ba15eb12e59ecbc7c20
        if (!(obj instanceof Student)) {
            return false;
        }
        Student otherStudent = (Student) obj;

        return this.name.equals(otherStudent.name);
    }
}
