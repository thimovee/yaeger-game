package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

public class AllStar extends Zombie {

    public AllStar(Coordinate2D location) {
        super(100, 100,  location, "sprites/AllStar.gif", 1);
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
