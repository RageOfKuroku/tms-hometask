package hometask.service.implementations;

import hometask.additional.RandomFloat;
import hometask.domain.Pair;




public class RaceServiceImpl {

    private final BalanceImpl balanceService;

    private final PairServiceImpl pairs;


    public RaceServiceImpl(BalanceImpl balanceService, PairServiceImpl pairs) {
        this.balanceService = balanceService;
        this.pairs = pairs;
    }

    public void test() {
        System.out.println("test");
    }
    public void startGame() {
        do {
            Pair maybeWin = pairs.choosePair();

            balanceService.makebet();

            System.out.println("Game started");
            startRaces();

            System.out.println("Winner rider" + pairs.getWinner().getHorseman() + "horse : " + pairs.getWinner().getHorse());

            if (maybeWin.equals(pairs.getWinner())) {
                System.out.println("Congratulations! You have won!");
                balanceService.addMoney();
            } else {
                System.out.println("Lost!");
                balanceService.withdrawMoney();
            }
        } while (balanceService.getBalance().getMoney() > 0);
        System.out.println("You run out of money! The end");
    }

    private void startRaces() {
        for (int i = 0; i < 5; i++) {
            try {
                pairs.getPairs().stream()
                        .map(Pair::getHorse)
                        .forEach(horse -> {
                            horse.setSpeedInfoCoef(horse.getSpeedInfoCoef() + new RandomFloat().createRandom());
                        });
                Thread.sleep(2000);
                System.out.println(i + " round finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
