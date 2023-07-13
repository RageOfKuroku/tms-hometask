package Main;

import java.util.Scanner;

public class CardUser {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в Bank-Hometask\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер счёта");
        int check = scanner.nextInt();
        account(check);


    }

    public static void checkingSum(int first, int second, int checkNumber)
    {
        if(second > first)
        {
            System.out.println("Нехватка средств, пожалуйста, пополните баланс");
            account(checkNumber);
        }
    }
    public static void account(int check)
    {
        CreditCard user1 = new CreditCard(1, 35);
        CreditCard user2 = new CreditCard(2, 67);
        CreditCard user3 = new CreditCard(3, 723);

        int index = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Просмотреть информацию о счёте\n2.Пополнить баланс счёта\n3.Снять деньги со счёта\n4.Выйти");
            index = scanner.nextInt();
            if(index == 4)
            {
                System.out.println("Спасибо за использование банковской системы Bank-Hometask");
                break;
            }
            switch (index)
            {

                case 1:
                    if(check == 1)
                    {
                        user1.ReadInfo();
                    } else if(check == 2)
                    {
                        user2.ReadInfo();
                    } else if (check == 3) {
                        user3.ReadInfo();
                    }
                    break;
                case 2:
                    System.out.println("Введите желаемую сумму для зачисления");
                    int plusSum = scanner.nextInt();
                    if(check == 1)
                    {
                        int sumUser1 = user1.getPresentSum();
                        user1.setPresentSum(sumUser1 + plusSum);
                    } else if(check == 2)
                    {
                        int sumUser2 = user2.getPresentSum();
                        user2.setPresentSum(sumUser2 + plusSum);
                    } else if (check == 3) {
                        int sumUser3 = user3.getPresentSum();
                        user3.setPresentSum(sumUser3 + plusSum);
                    }
                    System.out.println("Средства зачислены на ваш баланс");
                    break;
                case 3:

                    System.out.println("Введите желаемую сумму для снятия");
                    int minusSum = scanner.nextInt();
                    if(check == 1)
                    {
                        int sumUser1 = user1.getPresentSum();
                        checkingSum(sumUser1, minusSum, check);
                        user1.setPresentSum(sumUser1 - minusSum);

                    } else if(check == 2)
                    {
                        int sumUser2 = user2.getPresentSum();
                        checkingSum(sumUser2, minusSum, check);
                        user2.setPresentSum(sumUser2 - minusSum);


                    } else if (check == 3) {
                        int sumUser3 = user3.getPresentSum();
                        checkingSum(sumUser3, minusSum, check);
                        user3.setPresentSum(sumUser3 - minusSum);


                    }
                    System.out.println("Средства сняты с вашего баланса");
                    break;

                default:
                    System.out.println("Счёта с таким номером не существует");



            }

        } while (index != 4);
    }
}
