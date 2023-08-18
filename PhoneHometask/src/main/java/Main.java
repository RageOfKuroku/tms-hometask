public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone(375445924, Models.SAMSUNG);
        Phone phone3 = new Phone(375222333, Models.IPHONE, 123);

        System.out.println("Номера телефона: ");
        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());

        System.out.println("Звонки:");
        phone1.receiveCall("Samuel");
        phone2.receiveCall("Mark", 2134561324);
        phone3.receiveCall("Vladimir", 321512352);

        System.out.println("О телефоне:");
        phone2.infoAboutPhone();

        System.out.println("Отправка сообщений:");
        phone3.sendMessage(1231512434, 1234124524);
    }
}
