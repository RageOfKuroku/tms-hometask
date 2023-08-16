import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int numberOfElements = 20;
        List<Integer> list = IntStream.generate(() -> rand.nextInt(100))
                .limit(numberOfElements)
                .boxed()
                .toList();
        System.out.println(list + " изначальный список");


        List<Integer> listWithoutDuplicates = list.stream()
                .distinct()
                .toList();
        System.out.println(listWithoutDuplicates + " без дубликатов");


        List<Integer> evenElements = list.stream()
                .filter(x -> x >= 7 && x <= 17 && x % 2 == 0)
                .toList();
        System.out.println(evenElements + " чётные между 7 и 17");


        List<Integer> doubledList = list.stream()
                .map(x -> x * 2)
                .toList();
        System.out.println(doubledList + " умноженные на 2");


        List<Integer> firstFourElements = list.stream()
                .sorted()
                .limit(4)
                .toList();
        System.out.println(firstFourElements + " первые 4 элемента");


        long count = list.size();
        System.out.println(count + " количество элементов в стриме");


        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println(average + " среднее арифметическое всех элементов в стриме");


        ArrayList<String> names = new ArrayList<>();
        names.add("Egor");
        names.add("Haizenberg");
        names.add("August");
        names.add("David");
        names.add("Cooler David");
        names.add("George");
        names.add("BrainEvolved");
        System.out.println("\nСписок имён: " + names);


        String sayMyName = "Egor";
        long nameCount = names.stream()
                .filter(name -> name.equalsIgnoreCase(sayMyName))
                .count();
        System.out.println("Людей с именем " + sayMyName + " - " + nameCount);


        List<String> namesStartingWithA = names.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .toList();
        System.out.println("Элементы, которые начинаются на 'а': " + namesStartingWithA);


        String firstElement = names.stream()
                .sorted()
                .findFirst()
                .orElse("Empty");
        System.out.println("Первый элемент после сортировки(по алфавиту) - " + firstElement);
    }
}
