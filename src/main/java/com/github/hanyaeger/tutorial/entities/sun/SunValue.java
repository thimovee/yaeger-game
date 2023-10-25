package com.github.hanyaeger.tutorial.entities;

public class SunValue {
    private int value = 0;

    public SunValue() {
        this.value = 0;
    }

    public void increase() {
        value += 50;
    }

    public int getValue() {
        return value;
    }
}
