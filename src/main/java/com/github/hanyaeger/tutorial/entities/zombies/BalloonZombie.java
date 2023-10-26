package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

public class BalloonZombie extends Zombie {
    //zweeft over planten heen kan wel geraakt worden door pea

    public BalloonZombie(Coordinate2D location) {
        super(50, 1,  location, "sprites/balloonZombie.gif", 2);
        setMotion(0.5, 270d);
    }
    @Override
    public void action() {
        if(this.getHealth() <= 0){
            remove();
        }
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
