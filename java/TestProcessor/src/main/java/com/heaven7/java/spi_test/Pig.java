package com.heaven7.java.spi_test;

public class Pig implements Animal {
    @Override
    public void eat() {
        System.out.println("Pig eating...");
    }
}