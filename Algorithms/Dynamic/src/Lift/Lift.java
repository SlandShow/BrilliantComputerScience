import java.util.Scanner;

public class Lift {

    private static Scanner input = new Scanner(System.in);
    private static int[][] d; // Двумерная динамика
    private static int[] coast;

    public static void main(String... args) {
        String[] coastElements = input.nextLine().split(" ");
        d = new int[coastElements.length][coastElements.length];
        coast = new int[coastElements.length];

        for (int i = 0; i < coastElements.length; i++) {
            coast[i] = Integer.parseInt(coastElements[i]);
        }

        int search = Integer.parseInt(input.nextLine());
        System.out.println("Minimum coast is " + stairCoast(search));
    }

    private static int stairCoast(int n) {
        int[] d = new int[n];
        d[0] = 0;
        d[1] = d[0] + coast[1];

        for (int index = 2; index < n; index++) {
            d[index] = Math.min(d[index - 1], d[index - 2]) + coast[index];
        }

        return d[n - 1];
    }
}
