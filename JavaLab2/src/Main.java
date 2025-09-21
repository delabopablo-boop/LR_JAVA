import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== 1.1 =====
        System.out.println("Завдання 1.1: Порівняння дробових частин двох чисел");
        System.out.print("Введіть перше число: ");
        double a = sc.nextDouble();
        System.out.print("Введіть друге число: ");
        double b = sc.nextDouble();
        double fracA = Math.abs(a % 1), fracB = Math.abs(b % 1);
        System.out.println(fracA > fracB ? "Перше число має більшу дробову частину." :
                fracA < fracB ? "Друге число має більшу дробову частину." :
                        "Дробові частини рівні.");

        sc.nextLine(); // очищаємо буфер після nextDouble()

        // ===== 1.2 =====
        System.out.println("\nЗавдання 1.2: Перевірка нерівності");
        System.out.print("Введіть вираз (наприклад: 3 <= 9): ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        if (parts.length == 3) {
            try {
                int left = Integer.parseInt(parts[0]);
                String op = parts[1];
                int right = Integer.parseInt(parts[2]);
                boolean result = switch (op) {
                    case ">" -> left > right;
                    case "<" -> left < right;
                    case ">=" -> left >= right;
                    case "<=" -> left <= right;
                    case "==" -> left == right;
                    default -> false;
                };
                System.out.println(result ? "ТАК" : "НІ");
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введені не числа.");
            }
        } else {
            System.out.println("Невірний формат!");
        }

        // ===== 1.3 =====
        System.out.println("\nЗавдання 1.3: Сума дробових частин 10 чисел");
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Введіть число " + i + ": ");
            double num = sc.nextDouble();
            sum += Math.abs(num % 1);
        }
        System.out.println("Сума дробових частин: " + sum);

        sc.nextLine(); // знову чистимо буфер

        // ===== 1.4 =====
        System.out.println("\nЗавдання 1.4: Пошук найкоротшого рядка");
        String shortest = null;
        while (true) {
            System.out.print("Введіть рядок (або 'done' для завершення): ");
            String input = sc.nextLine();
            if (input.equals("done")) break;
            if (shortest == null || input.length() < shortest.length()) shortest = input;
        }
        System.out.println(shortest != null ? "Найкоротший рядок: " + shortest :
                "Жодного рядка не введено.");
    }
}