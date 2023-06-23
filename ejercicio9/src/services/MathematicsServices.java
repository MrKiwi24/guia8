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
        float bigger = 0;

        if (m.getNum1() > m.getNum2()){
            bigger = m.getNum1();
        } else {
            bigger = m.getNum2();
        }

        return bigger;
    }
    public float powerOf (Mathematics m){
        float powerResult = 0;

        powerResult = isBigger(m) * isSmaller(m);

        return powerResult;

    }
    public float isSmaller (Mathematics m){
        float smaller = 0;

        if (m.getNum1() < m.getNum2()){
            smaller = m.getNum1();
        } else {
            smaller = m.getNum2();
        }

        return smaller;
    }
    public float squareRoot (Mathematics m){
        float squareRootResult = 0;

        int rounded = Math.round(isSmaller(m));
        squareRootResult = (float) Math.sqrt(Double.parseDouble(String.valueOf(rounded)));

        return squareRootResult;
    }
}
