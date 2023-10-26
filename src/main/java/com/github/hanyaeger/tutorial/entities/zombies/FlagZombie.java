package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.map.GrassTile;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

public class FlagZombie extends Zombie implements SceneBorderTouchingWatcher {
    private int turnCounter = 0;

    public FlagZombie(Coordinate2D location) {
        // flagzombie is snel maar draait soms om
        super(100, 2,  location, "sprites/flagzombie.gif", 5);
        setMotion(1.5, 270d);
    }
    @Override
    public void action() {
        if (getHealth() <= 0) {
            remove();
        }

        turnCounter++;
        if (turnCounter >= 5) {
            setMotion(1, 90d);
            turnCounter = 0;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Plant) {
            setMotion(0, 270d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border == SceneBorder.RIGHT) {
            setMotion(1.5, 270d);
        }
    }

}
