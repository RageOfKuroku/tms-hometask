package Additional;

public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer(1500, "Dota2PC");
        Computer computer2 = new Computer(2500, "Dota2PROpc", new HDD("ScytheOfVyse", 500, TypeOfExternalities.INTERNAL), new RAM("BootsOfTravel", 16));
        Computer computer3 = new Computer(2500, "Dota2PROpcMega", new HDD("EyeOfScadi", 1000, TypeOfExternalities.EXTERNAL), new RAM("ScrollOfTeleportation", 64));


        computer1.toString();
        computer2.toString();
        computer3.toString();

        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
    }
}
