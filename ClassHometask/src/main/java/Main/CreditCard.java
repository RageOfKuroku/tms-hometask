package Main;

public class CreditCard {
    private int accountNumber;
    private int presentSum;

    public CreditCard(int accountNumber, int presentSum) {
        this.accountNumber = accountNumber;
        this.presentSum = presentSum;
    }

    public void setPresentSum(int presentSum) {
        this.presentSum = presentSum;
    }



    public int getPresentSum() {
        return presentSum;
    }


    public void ReadInfo()
    {
        System.out.println("Номер счёта:" + accountNumber);
        System.out.println("Текущий баланс:" + presentSum + " руб");
    }



}
