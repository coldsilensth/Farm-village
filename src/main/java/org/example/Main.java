package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        List<Animal> animals = new ArrayList<>();

        System.out.println("Добро пожаловать!");
        System.out.println("В нашей ферме есть 10 коров и 20 куриц");
        farm.addCows(10);
        farm.addChicken(20);
        animals.addAll(farm.getChickens());
        animals.addAll(farm.getCows());

        Thread threads = new Thread(() -> {
            try {
                for (int day = 1; day <= 7; day++) {
                    System.out.println("День " + day + ":");
                    farm.startNewDay();
                    Thread.sleep(5000);
                    farm.product();
                }
                Thread.sleep(5000);
                System.out.println("Итоги 1 недели");
                farm.printWeekInfo();
                Thread.sleep(5000);
                System.out.println("Мы сходили на рынок");
                Thread.sleep(5000);
                System.out.println("Купили 1 корову");
                farm.addCows(1);
                System.out.println("Купили 5 кур");
                farm.addChicken(5);
                animals.addAll(farm.getChickens());
                animals.addAll(farm.getCows());
                Thread.sleep(5000);
                farm.getAllAnimals();
                System.out.println("Пошла 2 неделя");
                Thread.sleep(5000);
                for (int day = 8; day <= 14; day++) {
                    System.out.println("День " + day + ":");
                    farm.startNewDay();
                    Thread.sleep(5000);
                    farm.product();
                }
                System.out.println("Итоги 2 недели");
                farm.printWeekInfo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.start();
    }
}