package ioprogramming.annotations.annotations;
import java.util.Scanner;

/*
 Parent class Animal
*/
class Animal{

    // Parent method
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
}

/*
 Child class Dog
*/
class Dog extends Animal{

    // Override parent method
    @Override
    public void makeSound(){
        System.out.println("Dog barks");
    }
}

public class OverrideExample{

    public static void main(String[] args){

        /*
         Creating Dog object
         Even though reference type is Animal,
         method of Dog will execute due to overriding
        */
        Animal obj = new Dog();

        obj.makeSound(); // Call overridden method
    }
}
