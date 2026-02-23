package ioprogramming.annotations.annotations;
import java.util.ArrayList;

public class SuppressWarningExample{

    /*
     Suppressing unchecked warnings
     because we are using raw ArrayList
    */
    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        // Raw ArrayList (no generics)
        ArrayList list = new ArrayList();

        list.add("Java");
        list.add(100);

        /*
         Iterating elements
         Compiler will not show unchecked warning
        */
        for(Object obj : list){
            System.out.println(obj);
        }
    }
}
