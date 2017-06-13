package com.heaven7.java.spi_test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestServiceLoader {

    /**
     * 可以找到所有该接口服务的实现类. 需要在META-INFO/service 下面注册
     */
    public static void main(String[] args) {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        Iterator<Animal> animalIterator = serviceLoader.iterator();
        while(animalIterator.hasNext()){
            Animal animal = animalIterator.next();
            animal.eat();
        }
    }
}