package com.heaven7.java.spi_test;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eating...");
    }
}