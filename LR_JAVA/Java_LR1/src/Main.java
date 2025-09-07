public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання 1.1");
        short s1 = 99;
        short s2 = 99;
        float f1 = 6; // 4 байти
        float f2;
        byte b = -10;
        boolean q = true;
        System.out.println("Завдання зроблене");
        System.out.println("Завдання 1.2");
        s1 = (byte) Math.pow(b, 2);
        System.out.println("s1 = " + s1);
        int max = 0; int min = 10;
        s2 = (short)(Math.random() * 11);
        System.out.println("s2 = " + s2);

        long d2 = (long)(Math.random() * 9999) + 1;
        System.out.println("d2 = " + d2);

        long d1 = (s1 * s2 != 0) ? d2 / (s1 * s2) : 0;
        System.out.println("Частка d1 = " + d1);
        System.out.println("Завдання 1.3");
        double y = Math.atan(f1 * (Math.pow(s2, 2))) / Math.log(s1);
        System.out.println("y = " + y);

        System.out.println("Завдання 2.1");
        String emoji1 = "\uD83D\uDE04";
        String emoji2 = "\uD83D\uDE02";
        String emoji3 = "\uD83D\uDE08";
        System.out.println(emoji1);
        System.out.println(emoji2);
        System.out.println(emoji3);

        System.out.println("Завдання 2.2");
        String originalString = "Я ПРОГРАМІСТ";
        String resultString = originalString.substring(1, originalString.length() - 1);
        System.out.println("Оригінальний рядок: " + originalString);
        System.out.println("Рядок без першої та останньої літери: " + resultString);
    }
}