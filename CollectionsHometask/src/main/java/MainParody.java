import additionalTask.MostMeetInt;
import mainTask.list.ArrayListParody;

public class MainParody {
    public static void main(String[] args) {

        ArrayListParody<String> list = new ArrayListParody<>(15); //Создание списка с использованием модифицированной вместимости(15)

        list.add("Первый");
        list.add("Второй");
        list.add("Третий");

        System.out.print("Элементы массива:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + list.get(i) + " ");
        }

        System.out.println("\nСодержит ли массив элемент 'Первый': " + list.contains("Первый"));
        System.out.println("Содержит ли массив элемент 'Четвёртый': " + list.contains("Четвёртый"));

        list.remove(1);

        System.out.print("\nМассив после удаления элемента с индексом 1:");
        for (int i = 0; i < 2; i++) {
            System.out.print(" " + list.get(i) + " ");
        }

        list.clear();

        System.out.println("\nМассив после очистки(ну, тут ничего нет):");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 6, 6};
        int with = MostMeetInt.mostFrequent(arr);
        int without = MostMeetInt.mostFrequentWithoutList(arr);

        System.out.println("\nНахождение большего числа повторений с использованием коллекций: " + with);
        System.out.println("Нахождение большего числа повторений без использования коллекций: " + without);


    }


}

