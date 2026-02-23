package ioprogramming.annotations.reflection;
import java.lang.reflect.*;
import java.util.Scanner;

/*
 Class with methods whose execution time
 will be measured dynamically
*/
class Worker{

    public void slowTask(){

        /*
         Simulate slow task
        */
        for(int i = 0; i < 100000000; i++){
        }

        System.out.println("Slow task completed");
    }

    public void fastTask(){

        /*
         Simulate faster task
        */
        for(int i = 0; i < 1000000; i++){
        }

        System.out.println("Fast task completed");
    }

}


/*
 Main class to measure method execution time
*/
public class MethodTimingReflection{

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        // User input for class name
        System.out.println("Enter class name:");
        String className = sc.nextLine();

        // User input for method name
        System.out.println("Enter method name:");
        String methodName = sc.nextLine();

        /*
         Load class dynamically using reflection
        */
        Class<?> cls = Class.forName(className);

        // Create object dynamically
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Get method dynamically
        Method method = cls.getMethod(methodName);

        // Record start time
        long start = System.nanoTime();

        /*
         Invoke the method dynamically
        */
        method.invoke(obj);

        // Record end time
        long end = System.nanoTime();

        // Calculate execution time
        long time = end - start;

        System.out.println("Execution Time (nanoseconds): " + time);

    }
}
