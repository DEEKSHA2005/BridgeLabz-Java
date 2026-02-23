package ioprogramming.annotations.reflection;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Scanner;

/*
 Custom Annotation used to mark dependencies
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}


/*
 Dependency class
*/
class DatabaseService{

    public void connect(){
        System.out.println("Database Connected");
    }

}


/*
 Class that requires dependency injection
*/
class UserService{

    // Field marked for injection
    @Inject
    private DatabaseService dbService;

    public void process(){
        dbService.connect();
        System.out.println("User Service Processing...");
    }
}


/*
 Simple DI Container
*/
class DIContainer{

    /*
      Generic method that creates object and injects dependencies
    */
    public static <T> T createObject(Class<T> clazz) throws Exception{

        // Create main object dynamically
        T obj = clazz.getDeclaredConstructor().newInstance();

        // Get all fields of the class
        Field[] fields = clazz.getDeclaredFields();

        /*
         Scan each field to check if it has @Inject annotation
        */
        for(Field field : fields){

            if(field.isAnnotationPresent(Inject.class)){

                // Get type of dependency
                Class<?> fieldType = field.getType();

                // Create dependency object dynamically
                Object dependency = fieldType.getDeclaredConstructor().newInstance();

                // Allow access to private field
                field.setAccessible(true);

                // Inject dependency
                field.set(obj, dependency);

            }

        }

        return obj;
    }

}


/*
 Main class
*/
public class DependencyInjectionDemo{

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        // Ask user which class to create
        System.out.println("Enter class name to create (UserService):");
        String className = sc.nextLine();

        /*
         Load class dynamically
        */
        Class<?> cls = Class.forName(className);

        // Create object using DI container
        Object obj = DIContainer.createObject(cls);

        // Invoke process() method
        Method method = cls.getMethod("process");
        method.invoke(obj);

    }
}
