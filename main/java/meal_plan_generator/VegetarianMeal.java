package meal_plan_generator;

public class VegetarianMeal implements MealPlan {
    private String mealName;
    private int calories;

    public VegetarianMeal(String mealName, int calories) {
        this.mealName = mealName;
        this.calories = calories;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegetarian Meal: " + mealName + ", Calories: " + calories);
    }
}
