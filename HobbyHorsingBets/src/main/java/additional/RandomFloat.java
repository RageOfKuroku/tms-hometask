package additional;


import org.springframework.stereotype.Service;
import service.RandomService;

import java.util.Random;
@Service

import service.RandomService;

import java.util.Random;


public class RandomFloat implements RandomService {
    @Override
    public float createRandom() {
        return new Random().nextFloat(2);
    }
}
