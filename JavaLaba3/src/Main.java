import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ================== 1.1 ==================
        System.out.println("=== Завдання 1.1 ===");
        System.out.print("Введіть кількість елементів масиву: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sumIndexes = 0;
        int countOddNegatives = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sumIndexes += i;
            }
            if (arr[i] < 0 && arr[i] % 2 != 0) {
                countOddNegatives++;
            }
        }

        System.out.println("Сума індексів додатних елементів: " + sumIndexes);
        System.out.println("Кількість непарних від'ємних елементів: " + countOddNegatives);

        // ================== 1.2 ==================
        System.out.println("\n=== Завдання 1.2 ===");
        for (double x = -2; x <= 2; x += 0.2) {
            double y = (Math.pow(x, (x - 1)) - 1) * (Math.pow(x, (x + 1)) + 1);
            System.out.printf("x = %.2f, y = %.4f%n", x, y);
        }

        // ================== 1.3 ==================
        System.out.println("\n=== Завдання 1.3 ===");
        System.out.print("Введіть кількість точок: ");
        int m = sc.nextInt();
        int[][] points = new int[m][2];

        System.out.println("Введіть координати точок (x y):");
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt(); // x
            points[i][1] = sc.nextInt(); // y
        }

        // Дзеркальне відображення відносно осі X
        for (int i = 0; i < m; i++) {
            points[i][i] = -points[i][1];
        }

        System.out.println("Координати після віддзеркалення відносно осі X:");
        for (int i = 0; i < m; i++) {
            System.out.println("(" + points[i][0] + ", " + points[i][1] + ")");
        }

        sc.close();
    }
}
