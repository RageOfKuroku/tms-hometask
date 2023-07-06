import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {

//1. Написать программу для вывода названия поры года по номеру месяца.(Switch-case)
        System.out.print("Введите номер месяца: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        System.out.println("Вывод с помощью switch-case");
        switch (index) {
            case 1 -> System.out.println("Зима - Jan");
            case 2 -> System.out.println("Зима - Feb");
            case 3 -> System.out.println("Весна - Mar");
            case 4 -> System.out.println("Весна - Apr");
            case 5 -> System.out.println("Весна - May");
            case 6 -> System.out.println("Лето - June");
            case 7 -> System.out.println("Лето - July");
            case 8 -> System.out.println("Лето - Aug");
            case 9 -> System.out.println("Осень - Sept");
            case 10 -> System.out.println("Осень - Oct");
            case 11 -> System.out.println("Осень - Nov");
            case 12 -> System.out.println("Зима - Dec");
            default -> System.out.println("Введен неверный номер месяца");
        }
//2. Написать программу для вывода названия поры года по номеру месяца.(If-Else)

        System.out.println("Вывод с помощью if-else");
        if(index == 1 || index == 2 || index == 12)
        {
            System.out.println("Зима");
        }
        else if(index == 3 || index == 4 || index == 5)
        {
            System.out.println("Весна");
        }
        else if(index == 6 || index == 7 || index == 8)
        {
            System.out.println("Лето");
        }
        else if(index == 9 || index == 10 || index == 11)
        {
            System.out.println("Осень");
        }
        /*3. Напишите программу, которая будет принимать на вход число и на
        выход будет выводить сообщение четное число или нет.
        Для определения четности числа используйте операцию получения
        остатка от деления - операция выглядит так: '% 2').*/
        System.out.print("Проверка числа на чётность/нечётность, введите число: ");
        Scanner scan = new Scanner(System.in);
        int check = scan.nextInt();
        if(check % 2 == 1)
        {
            System.out.println("Число нечётное");
        }
        else
        {
            System.out.println("Число чётное");
        }

        /*4. Для введенного числа t (температура на улице) вывести
        Если t>–5, то вывести «Тепло».
        Если –5>= t > –20, то вывести «Нормально».
        Если –20>= t, то вывести «Холодно».*/
        System.out.print("Введите температуру на улице: ");
        int temp = scan.nextInt();
        if(temp > -5)
        {
            System.out.println("Тепло");
        } else if(temp <= -5 && temp > -20) {

            System.out.println("Нормально");
        }else if(temp <= -20){

            System.out.println("Холодно");

        }

    }
}
