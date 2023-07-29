import Service.FileWorkerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите полный путь к файлу");
        String fileName = scan.next();
        System.out.println("Введите путь к файлу с валидными номерами документов");
        String fileForValid = scan.next();
        System.out.println("Введите путь к файлу с невалидными номерами документов");
        String fileForNotValid = scan.next();
        FileWorkerService.fileReader(fileName, fileForValid, fileForNotValid);
        //Можно прописать пути в программе изначально, но у каждого разные названия папок и файлов, а создание файлов не даст возможности что-то в них записать до окончания работы программы(т.к пока программа работает, то файлы не считаются созданными)
    }
}
