package hometask.service.implementations;

import hometask.additional.CreateScanner;
import hometask.domain.Pair;
import hometask.service.PairService;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter

public class PairServiceImpl implements PairService {
    private final List<Pair> Pairs;

    public PairServiceImpl(List<Pair> Pairs) {
        this.Pairs = Pairs;
    }

    @Override
    public Pair choosePair() {
        int PairIndex;
        do {
            for (int i = 0; i < Pairs.size(); i++) {
                System.out.println(i + "." + Pairs.get(i));
            }
            System.out.print("Choose your pair : ");
            PairIndex = CreateScanner.scanner().nextInt();
        } while (PairIndex < 0 || PairIndex >= Pairs.size());

        return Pairs.get(PairIndex);
    }

    @Override
    public Pair getWinner() {
        List<Double> doubles = new ArrayList<>();
        for (Pair Pair : Pairs) {
            doubles.add(Pair.getHorse().getSpeedInfoCoef());
        }
        Double max = Collections.max(doubles);

        int i = doubles.indexOf(max);

        return Pairs.get(i);

    }
}
