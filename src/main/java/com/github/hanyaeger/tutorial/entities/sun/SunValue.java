package com.github.hanyaeger.tutorial.entities.sun;

public class SunValue {
    private int value;

    public SunValue() {
        this.value = 100;
    }

    public void increase() {
        value += 50;
    }

    public int getValue() {
        return value;
    }

    public void decrease(int amount) {
        value -= amount;
    }
}
