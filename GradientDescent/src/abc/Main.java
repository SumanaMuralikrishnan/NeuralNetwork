package abc;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Iteration: " + i);

            System.out.print("Enter the value of lambda: ");
            float lambda = scanner.nextFloat();

            System.out.print("Enter the value of x1: ");
            float x1 = scanner.nextFloat();

            System.out.print("Enter the value of x2: ");
            float x2 = scanner.nextFloat();

            System.out.print("Enter the value of y: ");
            float y = scanner.nextFloat();

            System.out.print("Enter the value of w1: ");
            float w1 = scanner.nextFloat();

            System.out.print("Enter the value of w2: ");
            float w2 = scanner.nextFloat();

            w1 = w1 - lambda * gradw1(x1, x2, y, w1, w2);
            w2 = w2 - lambda * gradw2(x1, x2, y, w1, w2);

            System.out.println("Updated w1: " + w1);
            System.out.println("Updated w2: " + w2);
        }

        scanner.close();
    }

    public static float gradw1(float x1, float x2, float y, float w1, float w2) {
        float ypred = w1 * x1 + w2 * x2;
        float error = (ypred - y);
        return 2 * ((-y)+(w1*x1+w2*x2)) *(-x1);
    }

    public static float gradw2(float x1, float x2, float y, float w1, float w2) {
        float ypred = w1 * x1 + w2 * x2;
        float error = (ypred - y);
        return 2 *((-y)+(w1*x1+w2*x2)) *(-x2);
    }
}
