package algo.drool.matlab;

import WeibullJA.Class1;

public class Weibull {
    private void invoke() {
        try {
            Class1 class1 = new Class1();
            Object[] result = {null};
            Object[] input = {3029D, 3124D, 3248D, 3345D, 3570D, 3755D, 3974D, 3993D, 4254D, 4357D};
            class1.WeibullJA(result, input);
            System.out.println(result[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
