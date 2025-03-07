package meal_plan_generator;

public class KetoMeal implements MealPlan {
    private String mealName;
    private double fatContent;

    public KetoMeal(String mealName, double fatContent) {
        this.mealName = mealName;
        this.fatContent = fatContent;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Keto Meal: " + mealName + ", Fat Content: " + fatContent + "g");
    }
}

