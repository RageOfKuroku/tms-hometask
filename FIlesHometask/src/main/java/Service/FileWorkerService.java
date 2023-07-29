package Service;

import java.io.*;



public class FileWorkerService {

    public static void fileReader(String fileName, String valid, String notValid) {

        try (LineNumberReader reader = new LineNumberReader(new BufferedReader(new FileReader(fileName))); FileWriter validWrite = new FileWriter(valid); FileWriter notValidWrite = new FileWriter(notValid)) {

            String str = reader.readLine();

            while (str != null) {
                if (!str.isEmpty()) {
                    if (str.matches("contract.*[0-9a-zA-Z]+") || str.matches("docnum.*[0-9a-zA-Z]+")) { // Регулярные выражения для проверки валидности информации
                        if (str.length() == 15) { // Проверка длины строки, если она прошла проверку на валидность информации
                            System.out.println(str);
                            validWrite.write(str + "\n");
                        } else {
                            System.out.println("Not valid length");
                            notValidWrite.write(str + " - Not valid because of length(must be 15) " + "Your length: " + str.length() + "\n");
                        }
                    } else {
                        System.out.println("Not valid docNum");
                        notValidWrite.write(str + " - Right format is contractABCEFG1 or docnumABCEFG123 and length must be 15 symbols(ABCEFG1 and ABCEFG123 can be changed to yours)" + "\n");
                    }
                }
                str = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Something went wrong with file founding");
        } catch (IOException ex) {
            System.out.println("Something went wrong with I/O");
        }


    }
}


