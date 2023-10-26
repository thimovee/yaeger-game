package com.github.hanyaeger.tutorial.entities.spawners;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.sun.Sun;
import com.github.hanyaeger.tutorial.entities.sun.SunValue;
import com.github.hanyaeger.tutorial.entities.sun.SunValueDisplay;

import java.util.Random;

public class SunSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private final SunValue sunValue;
    private final SunValueDisplay sunValueDisplay;

    public SunSpawner(Coordinate2D coordinate2D, SunValue sunValue, SunValueDisplay sunValueDisplay) {
        super(20000);
        this.sceneWidth = coordinate2D.getX();
        this.sceneHeight = coordinate2D.getY();
        this.sunValue = sunValue;
        this.sunValueDisplay = sunValueDisplay;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Sun(randomLocation(), sunValue, sunValueDisplay ));
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        double y = new Random().nextInt((int) sceneHeight);
        return new Coordinate2D(x, y);
    }
}
