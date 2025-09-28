import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Клас Квадрат
class Square {
    private double side;
    private double x;
    private double y;

    // Конструктор без параметрів
    public Square() {
        this.side = 1.0;
        this.x = 0.0;
        this.y = 0.0;
    }

    // Конструктор з параметрами
    public Square(double side, double x, double y) {
        this.side = Math.abs(side); // Сторона не може бути від'ємною
        this.x = x;
        this.y = y;
    }

    // Конструктор копіювання
    public Square(Square other) {
        this.side = other.side;
        this.x = other.x;
        this.y = other.y;
    }

    // Set-методи
    public void setSide(double side) {
        this.side = Math.abs(side);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Get-методи
    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Метод обрахунку площі
    public double calculateArea() {
        return side * side;
    }

    // Метод переміщення квадрата
    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    @Override
    public String toString() {
        return String.format("Квадрат: сторона=%.2f, позиція=(%.2f, %.2f), площа=%.2f",
                side, x, y, calculateArea());
    }
}

// Клас Банківська картка
class BankCard {
    public enum CardType {
        VISA("Visa"), MASTERCARD("Mastercard");

        private String name;

        CardType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private CardType type;
    private String number;
    private String expiryDate;
    private String cvv;
    private String pin;
    private double balance;

    private static int cardCount = 0;

    // Конструктор без параметрів
    public BankCard() {
        this.type = CardType.VISA;
        this.number = generateCardNumber();
        this.expiryDate = "12/25";
        this.cvv = generateCVV();
        this.pin = generatePIN();
        this.balance = 0.0;
        cardCount++;
    }

    // Конструктор з параметрами
    public BankCard(CardType type, String number, String expiryDate, String cvv, String pin, double balance) {
        this.type = type;
        this.number = validateCardNumber(number);
        this.expiryDate = validateExpiryDate(expiryDate);
        this.cvv = validateCVV(cvv);
        this.pin = validatePIN(pin);
        this.balance = Math.max(0, balance);
        cardCount++;
    }

    // Set-методи
    public void setType(CardType type) {
        this.type = type;
    }

    public void setNumber(String number) {
        this.number = validateCardNumber(number);
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = validateExpiryDate(expiryDate);
    }

    public void setCvv(String cvv) {
        this.cvv = validateCVV(cvv);
    }

    public void setPin(String pin) {
        this.pin = validatePIN(pin);
    }

    public void setBalance(double balance) {
        this.balance = Math.max(0, balance);
    }

    // Get-методи
    public CardType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    // Статичні методи
    public static int getCardCount() {
        return cardCount;
    }

    public static void resetCardCount() {
        cardCount = 0;
    }

    // Методи для операцій з балансом
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Валідація та генерація даних
    private String validateCardNumber(String number) {
        if (number != null && number.replaceAll("\\s", "").matches("\\d{16}")) {
            return number.replaceAll("\\s", "");
        }
        return generateCardNumber();
    }

    private String validateExpiryDate(String date) {
        if (date != null && date.matches("\\d{2}/\\d{2}")) {
            return date;
        }
        return "12/25";
    }

    private String validateCVV(String cvv) {
        if (cvv != null && cvv.matches("\\d{3}")) {
            return cvv;
        }
        return generateCVV();
    }

    private String validatePIN(String pin) {
        if (pin != null && pin.matches("\\d{4}")) {
            return pin;
        }
        return generatePIN();
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private String generateCVV() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

    private String generatePIN() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    @Override
    public String toString() {
        String maskedNumber = number.substring(0, 4) + " " +
                number.substring(4, 8) + " " +
                number.substring(8, 12) + " " +
                number.substring(12, 16);
        return String.format("Тип картки: %s\nНомер картки: %s\nПридатна до: %s\nБаланс: %.2f грн",
                type, maskedNumber, expiryDate, balance);
    }
}

// Клас Клієнт банку
class BankClient {
    private String fullName;
    private String birthDate;
    private List<BankCard> cards;
    private int maxCards;

    // Конструктор без параметрів
    public BankClient() {
        this.fullName = "Невідомий клієнт";
        this.birthDate = "01/01/1990";
        this.maxCards = 5;
        this.cards = new ArrayList<>();
    }

    // Конструктор з параметрами
    public BankClient(String fullName, String birthDate, int maxCards) {
        this.fullName = fullName != null ? fullName : "Невідомий клієнт";
        this.birthDate = validateBirthDate(birthDate);
        this.maxCards = Math.max(1, maxCards);
        this.cards = new ArrayList<>();
    }

    // Конструктор копіювання
    public BankClient(BankClient other) {
        this.fullName = other.fullName;
        this.birthDate = other.birthDate;
        this.maxCards = other.maxCards;
        this.cards = new ArrayList<>();
        for (BankCard card : other.cards) {
            // Створюємо нові картки з тими ж параметрами
            this.cards.add(new BankCard(card.getType(), card.getNumber(),
                    card.getExpiryDate(), card.getCvv(), card.getPin(), card.getBalance()));
        }
    }

    // Set-методи
    public void setFullName(String fullName) {
        this.fullName = fullName != null ? fullName : "Невідомий клієнт";
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = validateBirthDate(birthDate);
    }

    public void setMaxCards(int maxCards) {
        this.maxCards = Math.max(1, maxCards);
    }

    // Get-методи
    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getMaxCards() {
        return maxCards;
    }

    public List<BankCard> getCards() {
        return new ArrayList<>(cards);
    }

    public int getCardCount() {
        return cards.size();
    }

    // Метод додавання картки
    public boolean addCard(BankCard card) {
        if (cards.size() < maxCards && card != null) {
            cards.add(card);
            return true;
        }
        return false;
    }

    // Метод купівлі в торгівельних мережах (з PIN-кодом)
    public boolean purchaseInStore(double amount, String pin) {
        for (BankCard card : cards) {
            if (card.getPin().equals(pin) && card.getBalance() >= amount) {
                return card.withdraw(amount);
            }
        }
        return false;
    }

    // Метод купівлі через інтернет (з CVV2-кодом)
    public boolean purchaseOnline(double amount, String cvv) {
        for (BankCard card : cards) {
            if (card.getCvv().equals(cvv) && card.getBalance() >= amount) {
                return card.withdraw(amount);
            }
        }
        return false;
    }

    // Валідація дати народження
    private String validateBirthDate(String date) {
        if (date != null && date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return date;
        }
        return "01/01/1990";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Клієнт: %s\n", fullName));
        sb.append(String.format("Дата народження: %s\n", birthDate));
        sb.append("Картки:\n");

        if (cards.isEmpty()) {
            sb.append("  Карток немає\n");
        } else {
            for (int i = 0; i < cards.size(); i++) {
                sb.append(String.format("  Картка %d:\n", i + 1));
                String[] cardInfo = cards.get(i).toString().split("\n");
                for (String line : cardInfo) {
                    sb.append("    ").append(line).append("\n");
                }
            }
        }

        return sb.toString();
    }
}

// Клас для тестування
class TestSquare {
    public static void testSquare() {
        System.out.println("=== ТЕСТУВАННЯ КЛАСУ КВАДРАТ ===");

        // Тест конструкторів
        System.out.println("\n1. Тест конструкторів:");
        Square square1 = new Square();
        System.out.println("Конструктор без параметрів: " + square1);

        Square square2 = new Square(5.0, 10.0, 15.0);
        System.out.println("Конструктор з параметрами: " + square2);

        Square square3 = new Square(square2);
        System.out.println("Конструктор копіювання: " + square3);

        // Тест set-методів
        System.out.println("\n2. Тест set-методів:");
        square1.setSide(3.0);
        square1.setPosition(5.0, 8.0);
        System.out.println("Після зміни параметрів: " + square1);

        // Тест get-методів
        System.out.println("\n3. Тест get-методів:");
        System.out.printf("Сторона: %.2f, X: %.2f, Y: %.2f%n",
                square2.getSide(), square2.getX(), square2.getY());

        // Тест обрахунку площі
        System.out.println("\n4. Тест обрахунку площі:");
        System.out.printf("Площа квадрата зі стороною %.2f = %.2f%n",
                square2.getSide(), square2.calculateArea());

        // Тест переміщення
        System.out.println("\n5. Тест переміщення:");
        System.out.println("До переміщення: " + square2);
        square2.move(5.0, -3.0);
        System.out.println("Після переміщення на (5, -3): " + square2);

        System.out.println("\n=== ТЕСТУВАННЯ КВАДРАТА ЗАВЕРШЕНО ===\n");
    }
}

class TestBankCard {
    public static void testBankCard() {
        System.out.println("=== ТЕСТУВАННЯ КЛАСУ БАНКІВСЬКА КАРТКА ===");

        // Скидаємо лічильник для тестування
        BankCard.resetCardCount();

        // Тест конструкторів
        System.out.println("\n1. Тест конструкторів:");
        BankCard card1 = new BankCard();
        System.out.println("Конструктор без параметрів:");
        System.out.println(card1);
        System.out.println("Кількість карток: " + BankCard.getCardCount());

        BankCard card2 = new BankCard(BankCard.CardType.MASTERCARD,
                "4532123456789012", "03/27", "123", "1234", 5000.0);
        System.out.println("\nКонструктор з параметрами:");
        System.out.println(card2);
        System.out.println("Кількість карток: " + BankCard.getCardCount());

        // Тест операцій з балансом
        System.out.println("\n2. Тест операцій з балансом:");
        card2.deposit(1000.0);
        System.out.printf("Після поповнення на 1000: %.2f грн%n", card2.getBalance());

        boolean success = card2.withdraw(2000.0);
        System.out.printf("Спроба зняти 2000: %s, баланс: %.2f грн%n",
                success ? "успішно" : "неуспішно", card2.getBalance());

        success = card2.withdraw(10000.0);
        System.out.printf("Спроба зняти 10000: %s, баланс: %.2f грн%n",
                success ? "успішно" : "неуспішно", card2.getBalance());

        System.out.println("\n=== ТЕСТУВАННЯ БАНКІВСЬКОЇ КАРТКИ ЗАВЕРШЕНО ===\n");
    }
}

class TestBankClient {
    public static void testBankClient() {
        System.out.println("=== ТЕСТУВАННЯ КЛАСУ КЛІЄНТ БАНКУ ===");

        // Тест конструкторів
        System.out.println("\n1. Тест конструкторів:");
        BankClient client1 = new BankClient();
        System.out.println("Конструктор без параметрів:");
        System.out.println(client1);

        BankClient client2 = new BankClient("Петренко Петро Петрович", "15/08/1985", 3);
        System.out.println("Конструктор з параметрами:");
        System.out.println(client2);

        // Додавання карток
        System.out.println("\n2. Тест додавання карток:");
        BankCard card1 = new BankCard(BankCard.CardType.VISA, "4532123456789012",
                "12/25", "123", "1234", 10000.0);
        BankCard card2 = new BankCard(BankCard.CardType.MASTERCARD, "5555123456789012",
                "06/26", "456", "5678", 5000.0);
        BankCard card3 = new BankCard(BankCard.CardType.VISA, "4111123456789012",
                "09/27", "789", "9999", 2000.0);

        client2.addCard(card1);
        client2.addCard(card2);
        client2.addCard(card3);

        System.out.println("Після додавання карток:");
        System.out.println(client2);

        // Тест конструктора копіювання
        System.out.println("\n3. Тест конструктора копіювання:");
        BankClient client3 = new BankClient(client2);
        System.out.println("Копія клієнта:");
        System.out.println(client3);

        // Тест покупок
        System.out.println("\n4. Тест покупок:");

        // Покупка в магазині (PIN)
        boolean result = client2.purchaseInStore(3000.0, "1234");
        System.out.printf("Покупка в магазині на 3000 грн з PIN 1234: %s%n",
                result ? "успішна" : "неуспішна");

        result = client2.purchaseInStore(15000.0, "1234");
        System.out.printf("Покупка в магазині на 15000 грн з PIN 1234: %s%n",
                result ? "успішна" : "неуспішна");

        // Покупка онлайн (CVV)
        result = client2.purchaseOnline(1500.0, "456");
        System.out.printf("Покупка онлайн на 1500 грн з CVV 456: %s%n",
                result ? "успішна" : "неуспішна");

        result = client2.purchaseOnline(500.0, "999");
        System.out.printf("Покупка онлайн на 500 грн з невірним CVV: %s%n",
                result ? "успішна" : "неуспішна");

        System.out.println("\nСтан клієнта після покупок:");
        System.out.println(client2);

        System.out.println("\n=== ТЕСТУВАННЯ КЛІЄНТА БАНКУ ЗАВЕРШЕНО ===\n");
    }
}

// Головний клас з main методом
class BankingSystem {
    public static void main(String[] args) {
        System.out.println("ПОВНЕ ТЕСТУВАННЯ СИСТЕМИ КЛАСІВ");
        System.out.println("================================");

        // Тестуємо всі класи
        TestSquare.testSquare();
        TestBankCard.testBankCard();
        TestBankClient.testBankClient();

        // Додаткове демо
        System.out.println("=== ДЕМОНСТРАЦІЯ РОБОТИ СИСТЕМИ ===");

        // Створюємо клієнта з картками
        BankClient client = new BankClient("Іванов Іван Іванович", "20/03/1990", 5);

        // Додаємо різні картки
        BankCard visa = new BankCard(BankCard.CardType.VISA, "4532015112830366",
                "12/25", "123", "1111", 15000.0);
        BankCard mastercard = new BankCard(BankCard.CardType.MASTERCARD, "5555341244441115",
                "08/26", "456", "2222", 8000.0);

        client.addCard(visa);
        client.addCard(mastercard);

        System.out.println("Створено клієнта:");
        System.out.println(client);

        // Демо покупок
        System.out.println("Демонстрація покупок:");
        client.purchaseInStore(2000.0, "1111");
        client.purchaseOnline(1000.0, "456");

        System.out.println("\nФінальний стан клієнта:");
        System.out.println(client);

        System.out.println("Загальна кількість створених карток: " + BankCard.getCardCount());

        System.out.println("\n=== ТЕСТУВАННЯ ЗАВЕРШЕНО ===");
    }
}