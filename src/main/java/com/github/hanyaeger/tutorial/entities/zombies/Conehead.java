package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

public class Conehead extends Zombie {
// iets meer hp dan andere zombies heeft geen speciale actie
    public Conehead(Coordinate2D location) {
        super(100, 1.2,  location, "sprites/Conehead.gif", 4);
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
        if(collider instanceof Plant){
            setMotion(0, 270d);
        }
    }
}
