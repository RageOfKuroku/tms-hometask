package Service;

public class WorkWithStringService {
    public static void showIntegers(String userString) {

        String[] ourString = userString.split("-");
        for (int i = 0; i < 5; i++) {
            if (ourString[i].matches("\\d+")) {
                System.out.print(ourString[i] + " ");
            }
        }
    }

    public static void lettersLowerCase(String userString) {
        String ourString;
        ourString = userString.replace("-", "");
        ourString = ourString.replaceAll("\\d+", "/");
        ourString = ourString.replace("//", "/").toLowerCase();
        StringBuilder sb = new StringBuilder(ourString);
        sb.delete(0, 1);
        System.out.println(sb);

    }

    public static void lettersUpperCase(String userString) {
        String ourString;
        ourString = userString.replace("-", "");
        ourString = ourString.replaceAll("\\d+", "/");
        ourString = ourString.replace("//", "/").toUpperCase();
        StringBuilder sb = new StringBuilder(ourString);
        sb.delete(0, 1);
        sb.insert(0, "Letters:");
        System.out.println(sb);
    }

    public static void replaceWithStars(String userString) {
        String replaced = userString.replaceAll("[a-zA-Z]{3}", "***");
        System.out.println("\n" + replaced);
    }

    public static void checkChain(String userString) {
        String newString = userString.toLowerCase(); //Приводим всю строку к нижнему регистру, чтобы ABC и abc стали одинаковыми
        String chain = "abc";//Просто для того, чтобы проверить любую последовательность
        if (newString.contains(chain)) {
            System.out.println("Строка содержит последовательность " + chain);
        } else {
            System.out.println("Строка не содержит последовательность " + chain);
        }
    }

    public static void checkStartNumber(String userString) {
        int number = 555;
        String checker = String.valueOf(number); //Для более лёгкой реализации ввода любого проверяемого числа
        if (userString.startsWith(checker)) {
            System.out.println("Строка начинается с последовательности чисел " + checker );
        }else {
            System.out.println("Строка не начинается последовательности чисел " + checker);
        }
    }
}
