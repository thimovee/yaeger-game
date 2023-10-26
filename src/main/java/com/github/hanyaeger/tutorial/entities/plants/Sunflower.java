package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.sun.Sun;
import com.github.hanyaeger.tutorial.entities.sun.SunValue;
import com.github.hanyaeger.tutorial.entities.sun.SunValueDisplay;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

public class Sunflower extends Plant {
    private int sunCounter;
    private SunValueDisplay sunValueDisplay;

    public Sunflower(Coordinate2D location, SunValueDisplay sunValueDisplay) {
        super(50, 100, 0, location, "sprites/sunflowerGif.gif", 1);
        sunCounter = 0;
        this.sunValueDisplay = sunValueDisplay;
    }

    @Override
    public void action() {
        if (this.getHealth() <= 0) {
            remove();
        }
        int sunTotal = Integer.parseInt(sunValueDisplay.getSunText());
        sunCounter++;
        if (sunCounter >= 20) {
            sunValueDisplay.setSunText(sunTotal + 50);
            sunCounter = 0;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Zombie){
            this.setHealth(this.getHealth() - ((Zombie) collider).getAttack());
        }
    }


}