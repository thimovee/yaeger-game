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
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Zombie){
            ((Zombie) collider).setHealth(((Zombie) collider).getHealth() - this.attack);
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
