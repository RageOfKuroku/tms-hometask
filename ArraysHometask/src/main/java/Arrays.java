
import java.util.Scanner;


public class Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println("Выберите задание(1-4):");

        switch (index) {
            case 1 -> firstTask();
            case 2 -> secondTask();
            case 3 -> thirdTask();
            case 4 -> fourthTask();
            default -> System.out.println("Задание не выбрано");
        }
    }

    public static void firstTask() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        java.util.Arrays.sort(arr);
        int found = java.util.Arrays.binarySearch(arr, key);

        if (found < 0) {
            System.out.print("Вашего числа нет в массиве");
        } else {
            System.out.print("Ваше число есть в массиве под индексом " + found);
        }

    }

    public static void secondTask() {
        int[] arr = new int[]{1, 2, 4, 5, 6, 7, 23, 5, 6, 1, 324, 6, 1, 2, 5, 6, 1};


        Scanner scan = new Scanner(System.in);
        int valueToRemove = scan.nextInt();

        int countToRemove = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToRemove) {
                countToRemove++;
            }
        }

        if (countToRemove > 0) {
            int[] arr2 = new int[arr.length - countToRemove];
            int index = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != valueToRemove) {
                    arr2[index] = arr[i];
                    index++;
                }
            }
            System.out.println("Начальный массив: " + java.util.Arrays.toString(arr));
            System.out.println("Новый массив: " + java.util.Arrays.toString(arr2));
        } else {
            System.out.println("Элемент не найден в массиве.");
        }
    }


    public static void thirdTask() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        int sum = 0;


        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) (Math.random() * 100);
            sum += arr[i];
        }


        java.util.Arrays.sort(arr);
        System.out.println();
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println(arr[0] + " Минимальное значение в массиве");
        System.out.println(arr[count-1] + " Максимальное значение в массиве");
        System.out.println(sum/count + " Среднее значение всех элементов в массиве");
    }

    public static void fourthTask()
    {

        int[] arr = new int[5];
        int[] arr1 = new int[5];
        int sum = 0;
        int sum1 = 0;

        for(int j = 0; j < arr.length; j++)
        {
            arr[j] = (int) (Math.random() * 100);
            sum += arr[j];
        }

        for(int i = 0; i < arr.length; i++)
        {
            arr1[i] = (int) (Math.random() * 100);
            sum1 += arr1[i];
        }
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println(java.util.Arrays.toString(arr1));

        int midInt = sum/5;
        int midInt1 = sum1/5;
        System.out.println("Среднее первого массива: " + midInt + " " + "Среднее второго массива: " + midInt1);

        if(midInt > midInt1)
        {
            System.out.println("Среднее значение элементов первого массива больше, чем во втором");
        }
        else if(midInt < midInt1)
        {
            System.out.println("Среднее значение элементов второго массива больше, чем в первом");
        }
        else if(midInt == midInt1)
        {
            System.out.println("Средние значения обоих массивов равны");
        }


    }
}


