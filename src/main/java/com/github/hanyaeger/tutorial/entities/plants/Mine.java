package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

public class Mine extends Plant {

    public Mine(Coordinate2D location) {
        super(25, 100, 10, location, "sprites/potatomine.png", 2);
    }

    @Override
    public void action() {}

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Zombie) {
            ((Zombie) collider).setHealth(0);
            remove();
        }
    }
}
