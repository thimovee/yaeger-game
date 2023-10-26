package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

public class Walnut extends Plant {

    public Walnut(Coordinate2D location) {
        super(50, 100, 10, location, "sprites/Walnut.png", 3);
    }

    @Override
    public void action() {
        if(this.getHealth() <= 0){
            remove();
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Zombie){
            this.setHealth(this.getHealth() - ((Zombie) collider).getAttack());
        }
    }

    public int setHealth(int i) {
        this.health = i;
        return this.health;
    }

    public int getHealth() {
        return this.health;
    }

}