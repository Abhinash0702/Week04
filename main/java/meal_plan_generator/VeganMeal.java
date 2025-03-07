package meal_plan_generator;

public class VeganMeal implements MealPlan {
    private String mealName;
    private boolean isGlutenFree;

    public VeganMeal(String mealName, boolean isGlutenFree) {
        this.mealName = mealName;
        this.isGlutenFree = isGlutenFree;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegan Meal: " + mealName + ", Gluten-Free: " + (isGlutenFree ? "Yes" : "No"));
    }
}
