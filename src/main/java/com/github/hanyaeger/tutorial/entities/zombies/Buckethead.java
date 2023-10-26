package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

import java.util.Timer;
import java.util.TimerTask;

public class Buckethead extends Zombie {
    private double damageIncreaseFactor = 1.0;
    private Timer damageIncreaseTimer = new Timer();
    private int damageBoostTimer = 0; // Track the number of times the timer has elapsed

    public Buckethead(Coordinate2D location) {
        super(100, 1, location, "sprites/buckethead.gif", 3);
        setMotion(0.2, 270d);
        damageIncreaseTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                increaseDamage();
            }
        }, 5000, 5000);
    }

    @Override
    public void action() {
        if (getHealth() <= 0) {
            remove();
        }
        performHeadbutt();
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Plant) {
            headbutt((Plant) collider);
        }
    }

    private void headbutt(Plant plant) {
        double plantHealth = plant.getHealth();
        double newPlantHealth = plantHealth - 5;
        plant.setHealth(newPlantHealth);
    }

    private void performHeadbutt() {
        if (damageBoostTimer >= 5) {
            damageIncreaseFactor = 2.0;
            damageBoostTimer = 0;
        }

    }

    private void increaseDamage() {
        damageBoostTimer++;
    }
}
