package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

import java.util.Timer;
import java.util.TimerTask;

public class AllStar extends Zombie {
    // allstars kunnen "chargen" als actie
    private boolean isCharging = false;
    private int i = 0;
    public AllStar(Coordinate2D location) {
        super(100, 100, location, "sprites/AllStar.gif", 1);
        setMotion(0.5, 270d);
    }

    @Override
    public void action() {
        i++;
        if (i == 5) {
            isCharging = true;
        }
        if (isCharging) {
            setMotion(1, 270d);
        } else if (this.getHealth() <= 0) {
            remove();
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Plant){
            setMotion(0, 270d);
        }
    }
}
