package ioprogramming.annotations.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

/*
 Custom annotation definition
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{

    int priority();
    String assignedTo();
}

class TaskManager{

    /*
     Method annotated with TaskInfo
    */
    @TaskInfo(priority=1, assignedTo="Deeksha")
    public void completeTask(){
        System.out.println("Task Completed");
    }
}

public class TaskAnnotationExample{

    public static void main(String[] args) throws Exception{

        Class<TaskManager> cls = TaskManager.class;

        /*
         Loop through all methods
         and check for TaskInfo annotation
        */
        for(Method m : cls.getDeclaredMethods()){

            if(m.isAnnotationPresent(TaskInfo.class)){

                TaskInfo info = m.getAnnotation(TaskInfo.class);

                System.out.println("Method: "+m.getName());
                System.out.println("Priority: "+info.priority());
                System.out.println("Assigned To: "+info.assignedTo());
            }
        }
    }
}