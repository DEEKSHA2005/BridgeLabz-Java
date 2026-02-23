package ioprogramming.annotations.annotations;
import java.lang.annotation.*;   // Import annotation classes
import java.lang.reflect.*;     // Import reflection classes like Field

/*
   Custom annotation used to define
   custom JSON key names for fields
*/
@Retention(RetentionPolicy.RUNTIME)   // Annotation available at runtime
@Target(ElementType.FIELD)            // Annotation can only be applied to fields
@interface JsonField{

    // Name that will appear in the JSON output
    String name();
}

/*
   User class whose fields will be
   converted into JSON format
*/
class User1{

    // Map field "name" to JSON key "user_name"
    @JsonField(name="user_name")
    String name="Deeksha";

    // Map field "age" to JSON key "user_age"
    @JsonField(name="user_age")
    int age=21;
}

/*
   Main class that converts object
   into JSON using reflection
*/
public class JsonSerializer{

    public static void main(String[] args) throws Exception{

        // Create object of User class
        User1 u = new User1();

        // Get runtime class information of object
        Class<?> cls = u.getClass();

        // Retrieve all declared fields of the class
        Field[] fields = cls.getDeclaredFields();

        // Start JSON string
        String json = "{";

        /*
           Loop through each field in the class
           and check if it has JsonField annotation
        */
        for(Field f : fields){

            // Check if annotation is present
            if(f.isAnnotationPresent(JsonField.class)){

                // Retrieve annotation details
                JsonField jf = f.getAnnotation(JsonField.class);

                // Add field value to JSON string
                json += "\"" + jf.name() + "\":\"" + f.get(u) + "\",";
            }
        }

        /*
           Remove last comma from JSON string
           to maintain proper JSON format
        */
        json = json.substring(0, json.length() - 1);

        // Close JSON object
        json += "}";

        // Print JSON output
        System.out.println(json);
    }
}
