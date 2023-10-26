package com.github.hanyaeger.tutorial.entities.map;

public class ActivePlant {
    private static int activePlantId = -1;

    public static int getActivePlantId() {
        return activePlantId;
    }

    public static void setActivePlantId(int plantId) {
        activePlantId = plantId;
    }
}
