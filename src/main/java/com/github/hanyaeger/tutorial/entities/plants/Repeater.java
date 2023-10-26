package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

public class Repeater extends Plant {

    public Repeater(Coordinate2D location, Size size) {
        super(200, 100, 10, location, "sprites/repeaterGif.gif", 4);
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