import Service.WorkWithStringService;

public class Main {
    public static void main(String[] args) {
        String userString = "5554-ABC-3333-qwe-1a2b";
        WorkWithStringService.showIntegers(userString);
        WorkWithStringService.replaceWithStars(userString);
        WorkWithStringService.lettersLowerCase(userString);
        WorkWithStringService.lettersUpperCase(userString);
        WorkWithStringService.checkChain(userString);
        WorkWithStringService.checkStartNumber(userString);
        WorkWithStringService.checkEndString(userString);
    }
}
