package ioprogramming.annotations.reflection;
import java.lang.reflect.*;   // Import Reflection classes such as Field

/*
   Product class whose fields will be converted
   into JSON using Reflection
*/
class Product{

    // Instance variables
    String name = "Laptop";
    int price = 80000;

}

public class ObjectToJSON{

    public static void main(String[] args) throws Exception{

        // Create object of Product class
        Product p = new Product();

        // Get the runtime class information of object p
        Class<?> cls = p.getClass();

        // Retrieve all declared fields of the class
        Field[] fields = cls.getDeclaredFields();

        // Start building JSON string
        String json = "{";

        /*
           Loop through each field in the Product class
           and retrieve its name and value
        */
        for(Field f : fields){

            // Allow access even if the field is private
            f.setAccessible(true);

            // Add field name and value to JSON format
            json += "\"" + f.getName() + "\":\"" + f.get(p) + "\",";

        }

        // Remove the last comma from JSON string
        json = json.substring(0,json.length()-1);

        // Close JSON object
        json += "}";

        // Print JSON output
        System.out.println(json);

    }
}
