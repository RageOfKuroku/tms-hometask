public class CreditCard {
    private int accountNumber;
    private int presentSum;

    public CreditCard(int accountNumber, int presentSum) {
        this.accountNumber = accountNumber;
        this.presentSum = presentSum;
    }
    public void minusSum(int number)
    {
        presentSum-=number;
    }
    public void plusSum(int number)
    {
        presentSum+=number;
    }
    public void readInfo()
    {
        System.out.println("Номер счёта:" + accountNumber);
        System.out.println("Текущий баланс:" + presentSum + " руб");
    }
    public void checkingSum(int second, int checkNumber)
    {
        if(second > presentSum)
        {
            System.out.println("Нехватка средств, пожалуйста, пополните баланс");
            CardUser.account(checkNumber);
        }
    }




}
