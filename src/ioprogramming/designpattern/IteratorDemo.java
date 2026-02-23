package ioprogramming.designpattern;
import java.util.*;

/*
 Iterator Pattern
 Traverse collection without exposing structure
*/

class StudentCollection {

    String students[] = {"Asha", "Ravi", "Neha", "Kiran"};

    public CustomIterator getIterator() {
        return new NameIterator();
    }

    class NameIterator implements CustomIterator {

        int index;

        public boolean hasNext() {
            return index < students.length;
        }

        public Object next() {
            return students[index++];
        }
    }
}

interface CustomIterator {
    boolean hasNext();
    Object next();
}

public class IteratorDemo {

    public static void main(String[] args) {

        StudentCollection repo = new StudentCollection();

        CustomIterator it = repo.getIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
