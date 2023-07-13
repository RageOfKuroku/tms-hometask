package Additional;

public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer(1500, "Dota2PC");
        Computer computer2 = new Computer(2500, "Dota2PROpc", new HDD("ScytheOfVyse", 500, true), new RAM("BootsOfTravel", 16));

        computer1.toString();
        computer2.toString();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}
