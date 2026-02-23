package ioprogramming.annotations.reflection;
import java.lang.reflect.*;

class Configuration{

    private static String API_KEY = "OLD_KEY";

}

public class ModifyStaticField{

    public static void main(String[] args) throws Exception{

        Class<?> cls = Configuration.class;

        Field field = cls.getDeclaredField("API_KEY");

        field.setAccessible(true);

        /*
         Modify static field
         null is used because static field
        */
        field.set(null,"NEW_SECRET_KEY");

        String value = (String) field.get(null);

        System.out.println("Updated API KEY: "+value);
    }
}
