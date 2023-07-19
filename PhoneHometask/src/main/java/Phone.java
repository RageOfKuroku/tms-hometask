public class Phone {
    private int number;
    private Models model;
    private int weight;

    public int getNumber() {
        return number;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, int number){
        System.out.println("Звонит " + name + "\nНомер: " + number);
    }

    public void sendMessage(int ... numbers) {
        for(int number : numbers) {
            System.out.println("На номер " + number + " отправлено сообщение");
        }
    }

    public void infoAboutPhone() {
        System.out.println("Номер телефона: " + number +"\nМодель: "+ model + "\nВес: " + weight);
    }

    public Phone() {
    }

    public Phone(int number, Models model) {
        this.number = number;
        this.model = model;
    }

    public Phone(int number, Models model, int weight) {
        this(number, model);
        this.weight = weight;
    }
}
