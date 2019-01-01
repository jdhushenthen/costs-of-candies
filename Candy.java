/***********************************************************
 * Author:         Janahan Dhushenthen                     *
 * Date:           December 12, 2016                       *
 * Description:    Finds costs of making various candies   *
 ***********************************************************/

public class Candy {

    /*******************************************************/
    // FIELD(S)

    // all ingredients and their costs per cup
    private static String[] ingredientNames = {"sugar", "corn-syrup", "water", "peppermint-extract", "red-food-colouring",
            "molasses", "butter", "vinegar", "chocolate-chips", "chopped-nuts", "vanilla", "evaporated-milk",
            "cocoa", "peanut-butter"};
    private static double[] ingredientCosts = {0.22, 1.05, 0, 16.80, 14.40, 1.06, 3.10, 0.12, 2.11, 4.73, 23.66, 0.99,
            4.35, 0.95};

    // recipes for each candy
    private static String[] candyCaneRecipe = {"2 c sugar", "1.5 c corn-syrup", "1 c water",
            "0.75 tsp peppermint-extract", "0.5 tsp red-food-colouring"};
    private static String[] butterScotchRecipe = {"1 c sugar", "0.25 c molasses", "0.25 c butter", "1 tsp water",
            "4 tsp vinegar"};
    private static String[] toffeeRecipe = {"2 c butter", "2 c sugar", "1 c chocolate-chips", "1 c chopped-nuts"};
    private static String[] peanutBrittleRecipe = {"2 c sugar", "2 tsp butter", "0.5 tsp vanilla", "1 c chopped-nuts"};
    private static String[] molassesCandyRecipe = {"1 c molasses", "0.5 c sugar", "1 tbsp butter"};
    private static String[] chocolatePeanutButterFudgeRecipe = {"3 c sugar", "1 c evaporated-milk", "0.25 c cocoa",
            "0.5 c peanut-butter", "1 tbsp butter"};

    // variables belonging to objects
    private double[] costs;
    private double[] quantity;

    /*******************************************************/
    // CLASS METHOD(S)

    // main method
    public static void main(String[] args) {

        // create objects for each candy
        Candy candyCane = new Candy(candyCaneRecipe);
        Candy butterscotch = new Candy(butterScotchRecipe);
        Candy toffee = new Candy(toffeeRecipe);
        Candy peanutBrittle = new Candy(peanutBrittleRecipe);
        Candy molassesCandy = new Candy(molassesCandyRecipe);
        Candy chocolatePeanutButterFudge = new Candy(chocolatePeanutButterFudgeRecipe);

        // print out costs of each candy
        System.out.println("The cost to make one batch of candy canes is $"+candyCane.costOfRecipe());
        System.out.println("The cost to make one batch of butter scotch is $"+butterscotch.costOfRecipe());
        System.out.println("The cost to make one batch of toffee is $"+toffee.costOfRecipe());
        System.out.println("The cost to make one batch of peanut brittle is $"+peanutBrittle.costOfRecipe());
        System.out.println("The cost to make one batch of molasses candy is $"+molassesCandy.costOfRecipe());
        System.out.println("The cost to make one batch of chocolate peanut butter fudge is $"
                +chocolatePeanutButterFudge.costOfRecipe());
    }

    /*******************************************************/
    // INSTANCE METHOD(S)

    // calculate the cost of each candy
    public double costOfRecipe() {
        double sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += (costs[i] * quantity[i]);
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    /*******************************************************/
    // CONSTRUCTOR(S)

    // initialize values for candy based on recipe
    public Candy(String[] recipe) {

        // declare local variables
        String[] ingredients = new String[recipe.length];
        double[] amounts = new double[recipe.length];
        String[] units = new String[recipe.length];

        // parse recipe and store its information
        for (int i = 0; i < recipe.length; i ++) {
            String[] tokens = recipe[i].split(" ");
            amounts[i] = Double.parseDouble(tokens[0]);
            units[i] = tokens[1];
            ingredients[i] = tokens[2];
        }

        // find quantity of cups per ingredient
        for (int i = 0; i < recipe.length; i++) {
            if(units[i].equals("tsp")) {
                amounts[i] /= 16;
            } else if(units[i].equals("tbsp")) {
                amounts[i] /= 48;
            }
        }
        quantity = amounts;

        // get costs of ingredients in recipe
        costs = new double[recipe.length];
        int i = 0;
        for (int x = 0; x < recipe.length; x++) {
            for (int y = 0; y < ingredientNames.length; y++) {
                if(ingredients[x].equals(ingredientNames[y])) {
                    costs[i] = ingredientCosts[y];
                    i++;
                }
            }
        }
    }
}
