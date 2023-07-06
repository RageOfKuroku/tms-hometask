
import javax.sound.midi.Soundbank;
import java.util.Scanner;
public class Loop {
    public static void main(String[] args) {
        /*1. При помощи цикла for вывести на экран нечетные числа от 1 до 99.
При решении используйте операцию инкремента (++).*/
        System.out.println();
        for(int i = 0; i < 100 ; i++)
        {
            if(i % 2 == 1)
            {
                System.out.print(i + " ");
                continue;
            }
        }

        /*2. Необходимо вывести на экран числа от 5 до 1.
При решении используйте операцию декремента (--).*/
        System.out.println();
        for(int j = 5; j > 0 ; j--)
        {
            System.out.print(j + " ");
            continue;
        }

        /*3. Напишите программу, где пользователь вводит любое целое
положительное число. А программа суммирует все числа от 1 до
введенного пользователем числа.
Для ввода числа воспользуйтесь классом Scanner.*/
        System.out.println();
        System.out.print("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        int result = 0;
        for(int i = 0; i < index+1;i++){
            result+=i;
        }
        System.out.print("Сумма от 1 до вашего числа равна: " + result);

    }


}
