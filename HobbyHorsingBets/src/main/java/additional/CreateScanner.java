package additional;

import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class CreateScanner {
    public static Scanner scanner() {
        return new Scanner(System.in);
    }
}
