package meal_plan_generator;

public class HighProteinMeal implements MealPlan {
    private String mealName;
    private int proteinContent;

    public HighProteinMeal(String mealName, int proteinContent) {
        this.mealName = mealName;
        this.proteinContent = proteinContent;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("High-Protein Meal: " + mealName + ", Protein: " + proteinContent + "g");
    }
}
