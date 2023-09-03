import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DateMainApp {

    public static void main(String[] args) {
        //Первое задание
        Scanner dateScan = new Scanner(System.in);
        System.out.println("Введите дату в формате ДД/ММ/ГГГГ");
        String dateInput = dateScan.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateInput, formatter);

        System.out.println(date.getDayOfWeek());

//Второе задание
        LocalDate date1 = LocalDate.now();

        switch (date1.getDayOfWeek()) {
            case MONDAY -> System.out.println(date1.plusDays(8));
            case TUESDAY -> System.out.println(date1.plusDays(7));
            case WEDNESDAY -> System.out.println(date1.plusDays(6));
            case THURSDAY -> System.out.println(date1.plusDays(5));
            case FRIDAY -> System.out.println(date1.plusDays(4));
            case SATURDAY -> System.out.println(date1.plusDays(3));
            case SUNDAY -> System.out.println(date1.plusDays(2));
        }


    }
}
