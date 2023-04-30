package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chicken extends Animal {
    private int countEgg;
    private List<Animal> animals = new ArrayList<>();

    public void resetCountEgg() {
        countEgg = 0;
    }

    //метод, при котором курица рандомно вынашивает яйца
    public int getCountEgg() {
        Random rand = new Random();
        countEgg = rand.nextInt(2);
        return countEgg;
    }
}
