package services;

import entities.Mathematics;

import java.util.Random;

public class MathematicsServices {
    public Mathematics createMath(){
        Mathematics math = new Mathematics();
        Random r = new Random();

        float random;
        int min = 1;
        int max = 100;

        random = r.nextFloat() * (max-min) + min;
        math.setNum1(random);

        random = r.nextFloat() * (max-min) + min;
        math.setNum2(random);

        return math;
    }

    public float isBigger (Mathematics m){

        float bigger = Math.max(m.getNum1(), m.getNum2());

        return bigger;
    }
    public float powerOf (Mathematics m){
        float powerResult;

        powerResult = isBigger(m) * isSmaller(m);

        return powerResult;

    }
    public float isSmaller (Mathematics m){
        float smaller = Math.min(m.getNum1(), m.getNum2());

        return smaller;
    }
    public float squareRoot (Mathematics m){
        float squareRootResult;

        int rounded = Math.round(isSmaller(m));
        squareRootResult = (float) Math.sqrt(Double.parseDouble(String.valueOf(rounded)));

        return squareRootResult;
    }
}
