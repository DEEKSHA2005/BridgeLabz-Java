package ioprogramming.annotations.reflection;
import java.lang.annotation.*;

/*
 Custom Annotation
*/
@Retention(RetentionPolicy.RUNTIME)
@interface Author{
    String name();
}

/*
 Annotated Class
*/
@Author(name="Deeksha")
class Book{

}

public class AnnotationReflection{

    public static void main(String[] args){

        Class<Book> cls = Book.class;

        /*
         Check if annotation exists
        */
        if(cls.isAnnotationPresent(Author.class)){

            Author a = cls.getAnnotation(Author.class);

            System.out.println("Author Name: "+a.name());

        }
    }
}
