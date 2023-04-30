package org.example;

import java.util.Random;

public class Cow extends Animal{
    private int countMilk;

    public Cow() {
    }
    //метод, где при надое коровы, рандомно считается литры молока именно 1 коровы
    public int getCountMilk() {
        Random rand = new Random();
        return rand.nextInt(8)+4;

    }
    public void resetCountMilk() {
        countMilk = 0;
    }
}
