package Additional;

public class RAM {

    private String name;
    private int value;

    public RAM() {

    }

    public RAM(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "RAM " +
                "name='" + name + '\'' +
                ", value=" + value;
    }
}
