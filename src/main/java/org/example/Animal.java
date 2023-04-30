package org.example;

public abstract class Animal {
    private int id;
    private static int countAnimal = 0;
    public Animal(){
        this.id = ++countAnimal;
    }
}
