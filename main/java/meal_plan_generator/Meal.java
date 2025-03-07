package meal_plan_generator;

import java.util.ArrayList;
import java.util.List;

public class Meal<T extends MealPlan> {
    private List<T> mealList;

    public Meal() {
        this.mealList = new ArrayList<>();
    }

    public void addMeal(T meal) {
        mealList.add(meal);
    }

    public List<T> getMeals() {
        return mealList;
    }

    public void displayMeals() {
        for (T meal : mealList) {
            meal.displayMealDetails();
        }
    }
}
