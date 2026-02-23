package ioprogramming.annotations.annotations;
import java.lang.annotation.*;   // Import annotation classes
import java.lang.reflect.*;     // Import reflection classes like Method

/*
   Custom annotation to mark methods
   whose execution time needs to be measured
*/
@Retention(RetentionPolicy.RUNTIME)   // Annotation available during runtime
@Target(ElementType.METHOD)           // Annotation can only be applied to methods
@interface LogExecutionTime{}


/*
   Worker class containing a method
   that performs some work
*/
class Worker{

    // Apply the custom annotation to this method
    @LogExecutionTime
    public void task(){

        /*
         Simulate heavy computation
         by running a large loop
        */
        for(int i = 0; i < 10000000; i++){}

        // Print completion message
        System.out.println("Task finished");
    }
}


/*
   Main class that checks for the annotation
   and measures execution time using reflection
*/
public class ExecutionTimeLogger{

    public static void main(String[] args) throws Exception{

        // Create object of Worker class
        Worker w = new Worker();

        // Retrieve the method named "task" using reflection
        Method m = Worker.class.getMethod("task");

        /*
         Check whether the method has the
         LogExecutionTime annotation
        */
        if(m.isAnnotationPresent(LogExecutionTime.class)){

            // Record start time in nanoseconds
            long start = System.nanoTime();

            // Invoke the method dynamically
            m.invoke(w);

            // Record end time
            long end = System.nanoTime();

            // Calculate and print execution time
            System.out.println("Execution Time: " + (end - start));
        }
    }
}
