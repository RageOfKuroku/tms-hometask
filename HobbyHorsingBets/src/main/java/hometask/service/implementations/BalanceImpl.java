package hometask.service.implementations;

import hometask.additional.CreateScanner;
import hometask.domain.UserBalance;
import hometask.service.Balance;
import lombok.Getter;



@Getter

public class BalanceImpl implements Balance {
    private final UserBalance balance;
    private float bet;

    public BalanceImpl(UserBalance balance) {
        this.balance = balance;
    }
    @Override
    public void makebet() {
        float bet;
        System.out.println("Your amount of money : " + balance.getMoney());
        do {
            System.out.print("Make your bet : ");
            bet = CreateScanner.scanner().nextFloat();
        } while (bet > balance.getMoney() || bet <= 0);

        this.bet = bet;
    }

    @Override
    public void addMoney() {
        balance.setMoney(balance.getMoney() + bet * 2);
    }

    @Override
    public void withdrawMoney() {
        balance.setMoney(balance.getMoney() - bet * 2);
    }
}
