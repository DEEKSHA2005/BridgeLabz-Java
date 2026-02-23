package ioprogramming.designpattern;
/*
 Template Method Pattern
 Defines skeleton of algorithm
*/

abstract class MealPreparation {

    // template method
    final void prepareMeal() {

        boilWater();
        cook();
        serve();
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    abstract void cook();

    void serve() {
        System.out.println("Serving meal");
    }
}

class PastaMeal extends MealPreparation {

    void cook() {
        System.out.println("Cooking pasta");
    }
}

class SoupMeal extends MealPreparation {

    void cook() {
        System.out.println("Cooking soup");
    }
}

public class Restaurant {

    public static void main(String[] args) {

        MealPreparation meal = new PastaMeal();
        meal.prepareMeal();
    }
}
