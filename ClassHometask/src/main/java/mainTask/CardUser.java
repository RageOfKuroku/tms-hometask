import java.util.Scanner;
public class CardUser {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в Bank-Hometask\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер счёта");
        int check = scanner.nextInt();
        account(check);
    }
    public static void account(int check) {
        CreditCard user1 = new CreditCard(1, 35);
        CreditCard user2 = new CreditCard(2, 67);
        CreditCard user3 = new CreditCard(3, 723);

        int index = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Просмотреть информацию о счёте\n2.Пополнить баланс счёта\n3.Снять деньги со счёта\n4.Выйти");
            index = scanner.nextInt();
            if(index == 4) {
                System.out.println("Спасибо за использование банковской системы Bank-Hometask");
                break;
            }
            switch (index) {
                case 1:
                    if(check == 1) {
                        user1.readInfo();
                    } else if(check == 2) {
                        user2.readInfo();
                    } else if (check == 3) {
                        user3.readInfo();
                    }
                    break;
                case 2:
                    System.out.println("Введите желаемую сумму для зачисления");
                    int plusSum = scanner.nextInt();
                    if(check == 1) {
                        user1.plusSum(plusSum);
                    } else if(check == 2) {
                        user2.plusSum(plusSum);
                    } else if (check == 3) {
                        user3.plusSum(plusSum);
                    }
                    System.out.println("Средства зачислены на ваш баланс");
                    break;
                case 3:
                    System.out.println("Введите желаемую сумму для снятия");
                    int minusSum = scanner.nextInt();
                    if(check == 1) {
                        user1.checkingSum(minusSum, check);
                        user1.minusSum(minusSum);
                    } else if(check == 2) {
                        user2.checkingSum(minusSum, check);
                        user2.minusSum(minusSum);
                    } else if (check == 3) {
                        user3.checkingSum(minusSum, check);
                        user3.minusSum(minusSum);
                    }
                    System.out.println("Средства сняты с вашего баланса");
                    break;
                default:
                    System.out.println("Счёта с таким номером не существует");
            }
        } while (index != 4);
    }
}
