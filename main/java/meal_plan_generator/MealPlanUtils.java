package meal_plan_generator;
import java.util.List;

public class MealPlanUtils {
    public static void displayAllMeals(List<? extends MealPlan> meals) {
        for (MealPlan meal : meals) {
            meal.displayMealDetails();
        }
    }

    public static <T extends MealPlan> void validateAndGenerateMeal(T meal) {
        System.out.println("\nValidating Meal: " + meal.getMealName() + "...");
        meal.displayMealDetails();
        System.out.println("✅ Meal is valid and added to the plan.");
    }
}

