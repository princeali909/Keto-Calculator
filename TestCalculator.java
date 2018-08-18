package Calculator;

import org.junit.*;
import static Calculator.CalculateGoals.*;
import static org.junit.Assert.*;


public class TestCalculator {


    @Test
    public void testRestingMetabolicRate1(){
        Collection c = new Collection("Male",190, 73,21,"Sedentary - Desk Job");
        double bmr = c.restingMetabolicRate();
        double expected = 2029;
        assertEquals(expected,bmr,3);
    }

    @Test
    public void testRestingMetabolicRate2(){
        Collection c = new Collection("Female",150, 60,21,"Sedentary - Desk Job");
        double bmr = c.restingMetabolicRate();
        double expected = 1490;
        assertEquals(expected,bmr,3);
    }

    @Test
    public void testDailyCaloricExpenditure(){
        Collection c = new Collection("Male",190, 73,21,"Low Activity - Walks around a bit");
        double bmr = c.restingMetabolicRate();
        double dce = c.dailyCaloricExpenditure(bmr);
        double expected = 2252;
        assertEquals(expected,dce,5);
    }

    @Test
    public void testLeanBodyMass(){
        Collection c = new Collection("Male",190, 73,21,"Low Activity - Walks around a bit");
        double lbm = c.leanBodyMass(20);
        double expected = 152;
        assertEquals(expected,lbm,1);
    }

    @Test
    public void testCalorieGoals(){
        Collection c = new Collection("Male",190, 73,21,"Low Activity - Walks around a bit");
        double bmr = c.restingMetabolicRate();
        double dce = c.dailyCaloricExpenditure(bmr);
        double cG = calorieGoals(dce,"Gain Weight");
        double expected = 2477;
        assertEquals(expected,cG,100);

    }

    @Test
    public void testProteinGoals(){
        Collection c = new Collection("Male",190, 73,21,"Low Activity - Walks around a bit");
        double lbm = c.leanBodyMass(20);
        double expected = 152;
        double pG = proteinGoals(lbm);
        assertEquals(expected,pG,1);
    }

    @Test
    public void testFatGoals(){
        Collection c = new Collection("Male",190, 73,21,"Low Activity - Walks around a bit");
        double bmr = c.restingMetabolicRate();
        double dce = c.dailyCaloricExpenditure(bmr);
        double cG = calorieGoals(dce,"maintain");
        double fG = fatGoals(cG);
        double expected = 175;
        assertEquals(expected,fG,10);
    }

}
