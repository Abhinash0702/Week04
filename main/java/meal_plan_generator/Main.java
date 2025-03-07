package meal_plan_generator;

public class Main {
    public static void main(String[] args) {
        // Creating different meal plans
        VegetarianMeal vegMeal1 = new VegetarianMeal("Grilled Veggie Salad", 350);
        VegetarianMeal vegMeal2 = new VegetarianMeal("Tofu Stir Fry", 400);

        VeganMeal veganMeal1 = new VeganMeal("Vegan Buddha Bowl", true);
        VeganMeal veganMeal2 = new VeganMeal("Lentil Soup", false);

        KetoMeal ketoMeal1 = new KetoMeal("Avocado & Eggs", 25.5);
        KetoMeal ketoMeal2 = new KetoMeal("Grilled Salmon with Butter", 30.2);

        HighProteinMeal proteinMeal1 = new HighProteinMeal("Chicken Breast with Quinoa", 45);
        HighProteinMeal proteinMeal2 = new HighProteinMeal("Protein Shake with Almonds", 50);

        // Creating meal catalogs
        Meal<VegetarianMeal> vegetarianMealPlan = new Meal<>();
        vegetarianMealPlan.addMeal(vegMeal1);
        vegetarianMealPlan.addMeal(vegMeal2);

        Meal<VeganMeal> veganMealPlan = new Meal<>();
        veganMealPlan.addMeal(veganMeal1);
        veganMealPlan.addMeal(veganMeal2);

        Meal<KetoMeal> ketoMealPlan = new Meal<>();
        ketoMealPlan.addMeal(ketoMeal1);
        ketoMealPlan.addMeal(ketoMeal2);

        Meal<HighProteinMeal> highProteinMealPlan = new Meal<>();
        highProteinMealPlan.addMeal(proteinMeal1);
        highProteinMealPlan.addMeal(proteinMeal2);

        // Displaying meals from each plan
        System.out.println("=== Vegetarian Meal Plan ===");
        vegetarianMealPlan.displayMeals();

        System.out.println("\n=== Vegan Meal Plan ===");
        veganMealPlan.displayMeals();

        System.out.println("\n=== Keto Meal Plan ===");
        ketoMealPlan.displayMeals();

        System.out.println("\n=== High-Protein Meal Plan ===");
        highProteinMealPlan.displayMeals();

        // Using wildcard method to display all meals dynamically
        System.out.println("\n=== Displaying All Meals Using Wildcard ===");
        MealPlanUtils.displayAllMeals(vegetarianMealPlan.getMeals());
        MealPlanUtils.displayAllMeals(veganMealPlan.getMeals());
        MealPlanUtils.displayAllMeals(ketoMealPlan.getMeals());
        MealPlanUtils.displayAllMeals(highProteinMealPlan.getMeals());

        // Validating and generating meal plans
        System.out.println("\n=== Validating and Generating Meal Plans ===");
        MealPlanUtils.validateAndGenerateMeal(vegMeal1);
        MealPlanUtils.validateAndGenerateMeal(veganMeal1);
        MealPlanUtils.validateAndGenerateMeal(ketoMeal1);
        MealPlanUtils.validateAndGenerateMeal(proteinMeal1);
    }
}

