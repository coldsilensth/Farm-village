package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Farm {
    private List<Cow> cows = new ArrayList<>();
    private List<Chicken> chickens = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private int eggsCount = 0;
    private int countMilk = 0;
    ;
    ReentrantLock lock = new ReentrantLock();


    public List<Cow> getCows() {
        return this.cows;
    }

    public List<Chicken> getChickens() {
        return this.chickens;
    }

    //метод добавления коров в список животных на ферме
    public void addCows(int cowsCount) {
        for (int i = 0; i < cowsCount; i++) {
            Cow cow = new Cow();
            cows.add(cow);
            animals.add(cow);
        }
    }

    //метод добавления куриц в список животных на ферме
    public void addChicken(int chickensCount) {
        for (int i = 0; i < chickensCount; i++) {
            Chicken chicken = new Chicken();
            chickens.add(chicken);
            animals.add(chicken);
        }
    }

    //метод сбора продукции(рандом)
    public void product() {
        int eggsCountToday = 0;
        int milkCountToday = 0;
        for (Animal animal : animals) {
            if (animal instanceof Chicken) {
                eggsCountToday += ((Chicken) animal).getCountEgg();
            } else if (animal instanceof Cow) {
                milkCountToday += ((Cow) animal).getCountMilk();
            }
        }
        lock.lock();
        try {
            eggsCount += eggsCountToday;
            countMilk += milkCountToday;
        } finally {
            lock.unlock();
        }
        System.out.println("Сегодня, " + getChickens().size() + " кур " + "отложили " + eggsCountToday +
                " яиц и " + getCows().size() + " коров" + " дали " + milkCountToday + " литра молока");
    }


    //метод, с помощью которого мы сбрасываем кол-во продукции чтобы вывести
    // сколько дали яиц и молока курица и корова на след.день
    public void startNewDay() {
        for (Cow cow : cows) {
            cow.resetCountMilk();
        }
        for (Chicken chicken : chickens) {
            chicken.resetCountEgg();
        }
    }

    //метод, при вызове узнаем сколько всего животных на ферме
    public void getAllAnimals() {
        int totalCowProduct = 0;
        for (Animal animal : animals) {
            if (animal instanceof Cow || animal instanceof Chicken) {
                totalCowProduct++;
            }
        }
        System.out.println("Всего " + totalCowProduct + " животных на ферме, " + "из них " + cows.size() +
                " коров и " + chickens.size() + " куриц");
    }

    //итоги за 7 дней
    public void printWeekInfo() {
        System.out.println("Всего куры дали " + eggsCount + " яиц и " + countMilk + " литров молока");
    }

}
