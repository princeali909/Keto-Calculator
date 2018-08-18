package Calculator;

/**
 * Class calculates all relevant macro nutrient goals for the individual using the data collected from Collection.java.
 */

public class CalculateGoals {

    /**
     * Based on whether the individual wants to gain weight(typically meaning to gain muscle),lose weight or maintain,
     * this method calculated the amount of calories the individual should aim for roughly.
     * @param dce Daily caloric expenditure of the individual
     * @param goals What the individuals fitness goal is.
     * @return Recommended daily caloric intake.
     */

    static double calorieGoals(double dce, String goals){
        double calorieGoal;
        if(goals.equals("Lose Weight")){
            calorieGoal = dce - (dce * .10);

        }
        else if(goals.equals("Gain Weight")){
            calorieGoal = dce + (dce * .10);
        }
        else{
            calorieGoal = dce;
        }
        return calorieGoal;
    }

    /**
     * Class calculates the recommended amount of protein (in grams) the individual should consume daily.
     * This is usually calculated by either multiply your total body weight by roughly 0.8 or simply eating 1g per
     * pound of lean body mass. This calculator goes with the latter.
     * @param leanBodyMass
     * @return
     */


    static double proteinGoals(double leanBodyMass){
        double protein = leanBodyMass;
        return protein;
    }

    /**
     * @return carb goals which is typically at a maximum of 25g per day.
     */

    static double carbGoals(){
        double carbs;
        carbs = 25;
        return carbs;
    }


    /**
     * calculated the amount of fat (in grams) recommended to consume each day. This is calculated based on your calorie
     * goals.
     * @param calorieGoals Amount of calories recommended per day based on your goals.
     * @return recommended daily fat intake.
     */


    static double fatGoals(double calorieGoals){
        double fat = (0.70 * calorieGoals)/9; //we divide by 9 because there are 9 calories per gram of fat.
        return fat;
    }

}
