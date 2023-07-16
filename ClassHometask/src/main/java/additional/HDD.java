package Additional;

public class HDD {

    private String name;
    private int value;
    private TypeOfExternalities isExternal;

    public HDD() {
    }

    public HDD(String name, int value, TypeOfExternalities isExternal) {
        this.name = name;
        this.value = value;
        this.isExternal = isExternal;
    }

    @Override
    public String toString() {
        return "HDD " +
                "name='" + name + '\'' +
                ", value=" + value +
                ", isExternal=" + isExternal;
    }
}
