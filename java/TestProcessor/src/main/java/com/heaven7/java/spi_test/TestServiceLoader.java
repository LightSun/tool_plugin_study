package com.heaven7.java.spi_test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestServiceLoader {
    public static void main(String[] args) {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        Iterator<Animal> animalIterator = serviceLoader.iterator();
        while(animalIterator.hasNext()){
            Animal animal = animalIterator.next();
            animal.eat();
        }
    }
}