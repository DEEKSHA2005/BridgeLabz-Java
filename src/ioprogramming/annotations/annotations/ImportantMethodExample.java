package ioprogramming.annotations.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

/*
 Custom annotation with default value
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{

    String level() default "HIGH";
}

class Demo{

    @ImportantMethod
    public void criticalTask(){
        System.out.println("Critical Task");
    }

    @ImportantMethod(level="MEDIUM")
    public void normalTask(){
        System.out.println("Normal Task");
    }
}

public class ImportantMethodExample{

    public static void main(String[] args){

        Method[] methods = Demo.class.getDeclaredMethods();

        for(Method m : methods){

            if(m.isAnnotationPresent(ImportantMethod.class)){

                ImportantMethod im = m.getAnnotation(ImportantMethod.class);

                System.out.println("Method: "+m.getName());
                System.out.println("Level: "+im.level());
            }
        }
    }
}