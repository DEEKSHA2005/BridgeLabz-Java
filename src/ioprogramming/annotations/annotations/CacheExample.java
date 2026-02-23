package ioprogramming.annotations.annotations;
import java.lang.annotation.*;   // Import annotation classes
import java.lang.reflect.*;     // Import reflection classes like Method
import java.util.HashMap;       // Import HashMap for caching results

/*
   Custom annotation CacheResult
   This annotation marks methods whose results
   should be cached to avoid repeated computation
*/
@Retention(RetentionPolicy.RUNTIME)   // Annotation available at runtime
@Target(ElementType.METHOD)           // Annotation can only be applied to methods
@interface CacheResult{}


/*
   Calculator class containing a method
   whose result we want to cache
*/
class Calculator{

    // Apply caching annotation
    @CacheResult
    public int square(int n){

        // Message to show when computation actually happens
        System.out.println("Computing...");

        // Return square of the number
        return n*n;
    }
}


/*
   Main class demonstrating caching using reflection
*/
public class CacheExample{

    // HashMap used to store cached results
    static HashMap<Integer,Integer> cache = new HashMap<>();

    public static void main(String[] args) throws Exception{

        // Create object of Calculator class
        Calculator calc = new Calculator();

        /*
           Retrieve square() method using reflection
           Method takes one integer parameter
        */
        Method m = Calculator.class.getMethod("square",int.class);

        // Input value whose square needs to be computed
        int input = 5;

        /*
           Check if result already exists in cache
        */
        if(cache.containsKey(input)){

            // If present, return cached result
            System.out.println("Cached Result: " + cache.get(input));

        }else{

            /*
               If not present, invoke method dynamically
               using reflection
            */
            int result = (int)m.invoke(calc,input);

            // Store computed result in cache
            cache.put(input,result);

            // Print computed result
            System.out.println("Computed Result: " + result);
        }
    }
}
