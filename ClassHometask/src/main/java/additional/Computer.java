package Additional;

public class Computer {

    private int cost;
    private String model;

    private HDD hdd;
    private RAM ram;
    public Computer() {
    }

    public Computer(int cost, String model) {
        this(cost, model, new HDD(), new RAM());
        this.cost = cost;
        this.model = model;

    }

    public Computer(int cost, String model, HDD hdd, RAM ram) {
        this.cost = cost;
        this.model = model;
        this.hdd = hdd;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Computer " +
                "cost=" + cost +
                ", model='" + model + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram
                ;
    }
}
