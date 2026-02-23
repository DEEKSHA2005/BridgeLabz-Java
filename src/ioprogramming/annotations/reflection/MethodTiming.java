package ioprogramming.annotations.reflection;
import java.lang.reflect.*;   // Import reflection classes like Method

/*
   Task class
   This class contains the method whose execution time
   will be measured using Reflection
*/
class Task{

    // Method that performs some work
    public void runTask(){

        /*
         Simulate some processing work
         by running a loop many times
        */
        for(int i = 0; i < 1000000; i++){
        }

        // Print confirmation message
        System.out.println("Task executed");

    }
}

/*
   Main class that measures execution time
   of a method using Reflection
*/
public class MethodTiming{

    public static void main(String[] args) throws Exception{

        // Create object of Task class
        Task t = new Task();

        // Get runtime class information of object t
        Class<?> cls = t.getClass();

        // Retrieve the method named "runTask"
        Method method = cls.getMethod("runTask");

        // Record starting time in nanoseconds
        long start = System.nanoTime();

        /*
         Invoke the runTask() method dynamically
         using Reflection
        */
        method.invoke(t);

        // Record ending time
        long end = System.nanoTime();

        // Print total execution time
        System.out.println("Execution Time: " + (end - start));

    }
}