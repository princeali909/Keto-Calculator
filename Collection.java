package Calculator;

import java.util.Scanner;


/**
 * Class takes in all necessary information needed to calculate our macro's based on our fitness goals. This calculator
 * is based on the imperial system (pounds,inches etc.) for now.
 */

public class Collection {
    private static String gender;
    private static double weight;
    private static double height;
    private static int age;
    private static String activityLevel;

    /**
     * Constructs our Collection Object.
     * @param g The gender of the individual
     * @param w The weight of the individual
     * @param h The height of the individual in inches
     * @param a the age of the individual
     * @param aL the activity level of the individual (How active they are in there day to day lives)
     */

    Collection(String g, double w, double h, int a, String aL){
        gender = g;
        weight = w;
        height = h;
        age = a;
        activityLevel = aL;
    }

    /**
     * Calculates the basic resting metabolic rate of the individual based on their gender, weight and age.
     * This formula is based on the Harris-Benedict equation.
     * @return BMR (calories) calculated
     */

    double restingMetabolicRate() {
        double bmr;
        if(this.gender.equals("Male")) {
            bmr = 66.0 + (6.2 * this.weight) + (12.7 * this.height)
                    - (6.76 *  this.age);
        }
        else {
            bmr = 655.1 + (4.35 * this.weight) + (4.7 * this.height)
                    - (4.7 * this.age);

        }

        return bmr;
    }

    /**
     * Calculates the amount of calories the individual burns per day based on there bmr calculated
     * and daily activity level. This formula was taken from the book //"Advanced Nutrition and Human Metabolism,
     * 5th Edition" and is used for the KetoGains calculator at ketogains.com.
     *
     * @param bmr basic metabolic rate calculated in previous method
     * @return The Daily Caloric Expenditure (Calories) of the individual
     */


    double dailyCaloricExpenditure(double bmr){
        double activityLevelFactor;

        switch (this.activityLevel){
            case "Sedentary - Desk Job":
                activityLevelFactor = 1;
                break;

            case "Low Activity - Walks around a bit" :
                activityLevelFactor =  1.11;
                break;

            case "Active - Lots of Walking" :
                activityLevelFactor =  1.25;
                break;

            case "High Activity - Labor Intensive Work":
                activityLevelFactor =  1.48;
                break;

            default:
                activityLevelFactor = 1;
        }

        double dce = bmr * activityLevelFactor;
        return dce;

    }

    /**
     * Calculates the individuals lean body mass.
     * Lean body mass is calculated by multiplying the individuals weight by his body fat percentage and subtracting
     * that value from his total weight. This value is helpful in calculating the individuals daily protein goals.
     * @param bodyFatPercentage Entered body fat percentage of individual
     * @return Lean Body Mass(lbs) of individual
     */

    double leanBodyMass(double bodyFatPercentage){
        double w = this.weight;
        double bfp = bodyFatPercentage / 100;
        double leanBodyMass;
        leanBodyMass = w - (w * bfp);
        return leanBodyMass;
    }

    /**
     * Main method where user enters all relevant information.
     * Note: For question on activity level and goals, you must copy and paste the options from the above methods in
     * Collection.java & CalculateGoals.java so that the program knows what you want otherwise it will go to default
     * options.
     * @param args
     */

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Male or Female?");
        String gender = input.nextLine();
        System.out.println("Weight in lbs:");
        double weight = input.nextDouble();
        input.nextLine();
        System.out.println("Height(inches):");
        double height = input.nextDouble();
        input.nextLine();
        System.out.println("Age:");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("What is your activity level?");
        String activity = input.nextLine();
        System.out.println("What is your Body Fat percentage?:");
        double bfp = input.nextDouble();
        input.nextLine();
        System.out.println("What are your goals?");
        String goals = input.nextLine();


        Collection a = new Collection(gender,weight,height,age,activity);
        double r = a.restingMetabolicRate();
        double d = a.dailyCaloricExpenditure(r);
        double cg = CalculateGoals.calorieGoals(d,goals);
        double p = CalculateGoals.proteinGoals(cg);
        double c = CalculateGoals.carbGoals();
        double f = CalculateGoals.fatGoals(cg);




        System.out.println(r);
        System.out.println(d);
        System.out.println(a.leanBodyMass(bfp));
        System.out.println(CalculateGoals.calorieGoals(d,goals));
        System.out.println(p);
        System.out.println(c);
        System.out.println(f);

        System.out.println("You are a " + gender + " who weighs " + weight + " lbs. You are also " +height + " inches tall and "
        + age + " years old");

    }
}
