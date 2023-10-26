package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

public class Peashooter extends Plant {

    public Peashooter(Coordinate2D location) {
        super(100, 100, 10, location, "sprites/Pea.gif", 0);
    }

    @Override
    public void action() {
        if (this.getHealth() <= 0) {
            remove();
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Zombie) {
            double peashooterHealth = this.getHealth();
            double newPeashooterHealth = peashooterHealth - ((Zombie) collider).getAttack();
            this.setHealth(newPeashooterHealth);
        }
    }

}
