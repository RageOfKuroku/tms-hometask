package hometask.additional;

import hometask.service.RandomService;

import java.util.Random;

public class RandomFloat implements RandomService {
    @Override
    public float createRandom() {
        return new Random().nextFloat(2);
    }
}
