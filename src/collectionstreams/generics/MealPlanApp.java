package collectionstreams.generics;

import java.util.ArrayList;
import java.util.List;


interface MealPlan {
    String getMealType();
    void mealDetails();
}


class VegetarianMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public void mealDetails() {
        System.out.println("Vegetarian Meal: Rice, Dal, Vegetables");
    }
}

class VeganMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public void mealDetails() {
        System.out.println("Vegan Meal: Fruits, Vegetables, Nuts");
    }
}

class KetoMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public void mealDetails() {
        System.out.println("Keto Meal: Eggs, Cheese, Avocado");
    }
}

class HighProteinMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "High Protein";
    }

    @Override
    public void mealDetails() {
        System.out.println("High Protein Meal: Chicken, Eggs, Lentils");
    }
}


class Meal<T extends MealPlan> {

    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}


class MealPlanUtil {

    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {

        System.out.println("Generating Personalized Meal Plan...");
        for (MealPlan meal : meals) {
            System.out.println("Meal Type: " + meal.getMealType());
            meal.mealDetails();
        }
    }
}


public class MealPlanApp {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        vegetarianMeals.addMeal(new VegetarianMeal());

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal());

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal());

        Meal<HighProteinMeal> proteinMeals = new Meal<>();
        proteinMeals.addMeal(new HighProteinMeal());

        System.out.println("---- Vegetarian Plan ----");
        MealPlanUtil.generateMealPlan(vegetarianMeals.getMeals());

        System.out.println("\n---- Vegan Plan ----");
        MealPlanUtil.generateMealPlan(veganMeals.getMeals());

        System.out.println("\n---- Keto Plan ----");
        MealPlanUtil.generateMealPlan(ketoMeals.getMeals());

        System.out.println("\n---- High Protein Plan ----");
        MealPlanUtil.generateMealPlan(proteinMeals.getMeals());
    }
}
