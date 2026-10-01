/**
 * PE04 - Healthy Eating.
 *
 * Provides static methods for building and analyzing meals made of Food.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class HealthyEating {

    private static final int MEAL1_SIZE = 5;
    private static final int MEAL2_SIZE = 7;

    /**
     * Program entry point that exercises each static method.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Food[] meal1 = mealPrep(MEAL1_SIZE);
        Food[] meal2 = mealPrep(MEAL2_SIZE);

        mealAnalyzer(meal1);
        mealAnalyzer(meal2);
        healthyChoice(meal1, meal2);

        meal1 = followRecipe("VEGETABLE FRUIT PROTEIN");
        meal2 = followRecipe("JUNK_FOOD DAIRY GRAIN");
        healthyChoice(meal1, meal2);

        meal1 = followRecipe("JUNK_FOOD JUNK_FOOD DAIRY");
        meal2 = followRecipe("PROTEIN GRAIN FRUIT VEGETABLE");
        healthyChoice(meal1, meal2);

        meal1 = followRecipe("PROTEIN GRAIN");
        meal2 = followRecipe("VEGETABLE");
        healthyChoice(meal1, meal2);
    }

    /**
     * Builds a meal of random foods.
     *
     * @param numFoods number of foods in the meal
     * @return an array of numFoods randomly chosen Food values
     */
    public static Food[] mealPrep(int numFoods) {
        Food[] foodArray = new Food[numFoods];
        Food[] foods = Food.values();
        for (int i = 0; i < foodArray.length; i++) {
            foodArray[i] = foods[(int) (Math.random() * foods.length)];
        }
        return foodArray;
    }

    /**
     * Builds a meal from a space-separated list of Food names.
     *
     * @param recipe space-separated Food names, e.g. "PROTEIN GRAIN"
     * @return an array of the Food values named in the recipe
     */
    public static Food[] followRecipe(String recipe) {
        String[] names = recipe.split(" ");
        Food[] foodArray = new Food[names.length];
        for (int i = 0; i < names.length; i++) {
            foodArray[i] = Food.valueOf(names[i]);
        }
        return foodArray;
    }

    /**
     * Prints how many of each type of Food are in the meal.
     *
     * @param foodArray the meal to analyze
     */
    public static void mealAnalyzer(Food[] foodArray) {
        System.out.println("The following types of food are in your meal:");
        Food[] foods = Food.values();
        int[] counts = new int[foods.length];
        for (Food food : foodArray) {
            counts[food.ordinal()]++;
        }
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i] + " " + counts[i]);
        }
    }

    /**
     * Compares two meals by the sum of their foods' ordinals and prints
     * which one is healthier.
     *
     * @param meal1 the first meal
     * @param meal2 the second meal
     */
    public static void healthyChoice(Food[] meal1, Food[] meal2) {
        int score1 = score(meal1);
        int score2 = score(meal2);
        if (score1 > score2) {
            System.out.println("The first meal is the healthier choice "
                + "with a score of " + score1 + ".");
        } else if (score2 > score1) {
            System.out.println("The second meal is the healthier choice "
                + "with a score of " + score2 + ".");
        } else {
            System.out.println("The two meals are equally healthy "
                + "with scores of " + score1 + ".");
        }
    }

    /**
     * Sums the ordinals of every Food in a meal.
     *
     * @param meal the meal to score
     * @return the meal's score
     */
    private static int score(Food[] meal) {
        int total = 0;
        for (Food food : meal) {
            total += food.ordinal();
        }
        return total;
    }
}
