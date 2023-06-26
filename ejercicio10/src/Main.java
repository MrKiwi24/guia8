import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrayASize = 50;
        int arrayBSize = 20;

        int[] arrayA = new int[arrayASize];
        int[] arrayB = new int[arrayBSize];

        fillInArray(arrayA, arrayASize);
        showArray(arrayA, arrayASize);


    }

    public static void fillInArray(int[] a, int aS) {
        Random r = new Random();

        for (int i = 0; i < aS; i++) {
            //a[i] = r.nextInt(0, 99);
            a[i] = i;
        }
    }

    public static void showArray(int[] a, int aS) {
        int breaker = 0;

        for (int i = 0; i < aS; i++) {
            if (breaker == 9) {
                if (a[i] >= 0 && a[i] <= 9) {
                    System.out.print(" |  " + a[i] + " |");
                } else {
                    System.out.print(" | " + a[i] + " |");
                }
                System.out.println("");
                breaker = 0;
            } else {
                if (a[i] >= 0 && a[i] < 9) {
                    System.out.print(" |  " + a[i]);
                    breaker++;
                } else {
                    System.out.print(" | " + a[i]);
                    breaker++;
                }
            }
        }
    }
}