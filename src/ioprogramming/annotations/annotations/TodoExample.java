package ioprogramming.annotations.annotations;
import java.lang.annotation.*;  // Import classes for creating custom annotations
import java.lang.reflect.*;    // Import reflection classes like Method

/*
   Define a custom annotation called Todo
   This annotation will be used to mark pending tasks in the project
*/
@Retention(RetentionPolicy.RUNTIME)  // Annotation will be available at runtime
@Target(ElementType.METHOD)          // Annotation can only be applied to methods
@interface Todo{

    // Description of the task
    String task();

    // Developer responsible for the task
    String assignedTo();

    // Priority of the task (default value is MEDIUM)
    String priority() default "MEDIUM";
}

/*
   Project class containing methods
   that represent project features
*/
class Project{

    // Annotation applied to login method
    @Todo(task="Implement login", assignedTo="Deeksha")
    public void login(){}

    // Annotation applied to payment method
    @Todo(task="Fix payment bug", assignedTo="Alex", priority="HIGH")
    public void payment(){}
}

/*
   Main class that retrieves annotation information
   using Reflection API
*/
public class TodoExample{

    public static void main(String[] args){

        /*
         Loop through all methods of Project class
         using reflection
        */
        for(Method m : Project.class.getDeclaredMethods()){

            // Check if the method contains Todo annotation
            if(m.isAnnotationPresent(Todo.class)){

                // Retrieve the annotation
                Todo t = m.getAnnotation(Todo.class);

                // Print annotation details
                System.out.println("Task: " + t.task());
                System.out.println("Assigned To: " + t.assignedTo());
                System.out.println("Priority: " + t.priority());
                System.out.println("---------------------");
            }
        }
    }
}
