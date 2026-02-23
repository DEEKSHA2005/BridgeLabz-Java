package ioprogramming.annotations.annotations;
import java.lang.annotation.*;   // Import classes required for defining custom annotations
import java.lang.reflect.*;     // Import reflection classes such as Field

/*
   Custom annotation definition
   This annotation will restrict the maximum length of a String field
*/
@Retention(RetentionPolicy.RUNTIME)   // Annotation will be available during runtime
@Target(ElementType.FIELD)            // Annotation can only be applied to fields
@interface MaxLength{

    // Parameter that stores the allowed maximum length
    int value();
}

/*
   User class containing a field with validation
*/
class User{

    // Apply MaxLength annotation to username field
    @MaxLength(10)
    String username;

    /*
       Constructor used to initialize username
       and validate its length using reflection
    */
    public User(String username) throws Exception{

        // Get the Field object representing "username"
        Field f = this.getClass().getDeclaredField("username");

        // Retrieve the MaxLength annotation applied to the field
        MaxLength ml = f.getAnnotation(MaxLength.class);

        /*
           Validate length of username
           If username length exceeds allowed value,
           throw an exception
        */
        if(username.length() > ml.value()){
            throw new IllegalArgumentException("Username too long");
        }

        // Assign value to the field if validation passes
        this.username = username;
    }
}

/*
   Main class to test the validation
*/
public class MaxLengthExample{

    public static void main(String[] args) throws Exception{

        // Create a User object with username
        User u = new User("Deeksha");

        // If username length is valid, print confirmation
        System.out.println("Username accepted");
    }
}
