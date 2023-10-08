package hometask.org.service;

public enum Post {
    WORKER(1.5),
    DIRECTOR(2);

    private final double coeffisients;

    Post(double coeffisients) {
        this.coeffisients = coeffisients;
    }

    public double getCoeffisients() {
        return this.coeffisients;
    }
}
